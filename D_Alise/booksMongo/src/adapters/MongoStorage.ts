import { MongoClient, Collection } from 'mongodb';
import Book from "../models/Book";
import { Storage } from "../ports/Storage";

const url = 'mongodb://127.0.0.1:27017'; 
const dbName = 'corso'; 
const collectionName = 'books'; 

export class MongoStorage implements Storage<Book> {
    private client: MongoClient;
    private collection!: Collection<Book>; 

    constructor() {
        this.client = new MongoClient(url);
    }

    async connect(): Promise<void> {
        await this.client.connect();
        const db = this.client.db(dbName);
        this.collection = db.collection<Book>(collectionName);
    }

    async disconnect(): Promise<void> {
        await this.client.close();
    }

    async insert(element: Book): Promise<number> {
        const result = await this.collection.insertOne(element);
        return result.insertedId as any; 
    }

    async readAll(): Promise<Book[]> {
        const books = await this.collection.find({}).toArray();
        return books;
    }

    async readById(isbn: number): Promise<Book | null> { 
        const book = await this.collection.findOne({ isbn }); 
        return book;
    }

    async update(isbn: number, element: Book): Promise<void> { 
        await this.collection.updateOne({ isbn }, { $set: element }); 
    }

    async delete(isbn: number): Promise<void> { 
        await this.collection.deleteOne({ isbn });
    }
}
