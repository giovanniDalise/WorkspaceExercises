import { Business } from "../domains/Business";
import Book from "../models/Book";
import { MongoStorage } from "./MongoStorage";
import express from "express";

const app = express();
const port = 8080;

async function initialize() {
    try {
        const storage = new MongoStorage();
        await storage.connect();
        console.log("Connected to the database");

        const business = new Business(storage);

        app.use(express.json());

        app.get('/books', async (req, res) => {
            try {
                const books: Book[] = await business.readAll();
                console.log("get avviata");
                if (books && books.length > 0) {
                    res.status(200).json(books);
                } else {
                    res.status(200).send("DB vuoto");
                }
            } catch (error) {
                console.error(error);
                res.status(500).send("Errore");
            }
        });

        app.get('/books/:isbn', async (req, res) => { // Cambia il parametro da 'id' a 'isbn'
            try {
                const book: Book | null = await business.readById(+req.params.isbn); // Esegui il cast di 'isbn' a 'number'
                console.log("get by isbn (" + req.params.isbn + ") avviata"); // Cambia il log per riflettere l'ISBN
                if (book) {
                    res.status(200).json(book);
                } else {
                    res.status(200).send("Libro non trovato");
                }
            } catch (error) {
                console.error(error);
                res.status(500).send("Errore");
            }
        });

        app.post('/books', async (req, res) => {
            try {
                const inserito: Book = req.body;
                const id = await business.insert(inserito);
                console.log("post (" + id + ") avviata");
                res.status(200).send("Libro creato");
            } catch (error) {
                console.error(error);
                res.status(500).send("Errore");
            }
        });

        app.put('/books/:isbn', async (req, res) => { // Cambia il parametro da 'id' a 'isbn'
            try {
                const aggiornato: Book = req.body;
                await business.update(+req.params.isbn, aggiornato); // Esegui il cast di 'isbn' a 'number'
                console.log("put (" + req.params.isbn + ") avviata"); // Cambia il log per riflettere l'ISBN
                res.status(200).send("Libro aggiornato");
            } catch (error) {
                console.error(error);
                res.status(500).send("Errore");
            }
        });

        app.delete('/books/:isbn', async (req, res) => { // Cambia il parametro da 'id' a 'isbn'
            try {
                await business.delete(+req.params.isbn); // Esegui il cast di 'isbn' a 'number'
                console.log("delete (" + req.params.isbn + ") avviata"); // Cambia il log per riflettere l'ISBN
                res.status(200).send("Book cancellato");
            } catch (error) {
                console.error(error);
                res.status(500).send("Errore");
            }
        });

        app.listen(port, () => {
            console.log(`Server listening on port ${port}`);
        });

    } catch (error) {
        console.error("Error during initialization:", error);
    }
}

initialize();
