"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const Business_1 = require("../domains/Business");
const MongoStorage_1 = require("./MongoStorage");
const express_1 = __importDefault(require("express"));
const app = (0, express_1.default)();
const port = 8080;
function initialize() {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const storage = new MongoStorage_1.MongoStorage();
            yield storage.connect();
            console.log("Connected to the database");
            const business = new Business_1.Business(storage); //costruttore con storage definito nella classe Business che sarà un istanza di MongoStorage
            app.use(express_1.default.json());
            app.get('/books', (req, res) => __awaiter(this, void 0, void 0, function* () {
                try {
                    const books = yield business.readAll();
                    console.log("get avviata");
                    if (books && books.length > 0) {
                        res.status(200).json(books);
                    }
                    else {
                        res.status(200).send("DB vuoto");
                    }
                }
                catch (error) {
                    console.error(error);
                    res.status(500).send("Errore");
                }
            }));
            app.get('/books/:isbn', (req, res) => __awaiter(this, void 0, void 0, function* () {
                try {
                    const book = yield business.readById(+req.params.isbn);
                    console.log("get by isbn (" + req.params.isbn + ") avviata");
                    if (book) {
                        res.status(200).json(book);
                    }
                    else {
                        res.status(200).send("Libro non trovato");
                    }
                }
                catch (error) {
                    console.error(error);
                    res.status(500).send("Errore");
                }
            }));
            app.post('/books', (req, res) => __awaiter(this, void 0, void 0, function* () {
                try {
                    const inserito = req.body;
                    const id = yield business.insert(inserito);
                    console.log("post (" + id + ") avviata");
                    res.status(200).send("Libro creato");
                }
                catch (error) {
                    console.error(error);
                    res.status(500).send("Errore");
                }
            }));
            app.put('/books/:isbn', (req, res) => __awaiter(this, void 0, void 0, function* () {
                try {
                    const aggiornato = req.body;
                    yield business.update(+req.params.isbn, aggiornato);
                    console.log("put (" + req.params.isbn + ") avviata");
                    res.status(200).send("Libro aggiornato");
                }
                catch (error) {
                    console.error(error);
                    res.status(500).send("Errore");
                }
            }));
            app.delete('/books/:isbn', (req, res) => __awaiter(this, void 0, void 0, function* () {
                try {
                    yield business.delete(+req.params.isbn);
                    console.log("delete (" + req.params.isbn + ") avviata");
                    res.status(200).send("Book cancellato");
                }
                catch (error) {
                    console.error(error);
                    res.status(500).send("Errore");
                }
            }));
            app.listen(port, () => {
                console.log(`Server listening on port ${port}`);
            });
        }
        catch (error) {
            console.error("Error during initialization:", error);
        }
    });
}
initialize();
