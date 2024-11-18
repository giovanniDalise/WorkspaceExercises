import { MongoClient, Collection, ObjectId } from 'mongodb';
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

    async insert(element: Book): Promise<any> {
        const result = await this.collection.insertOne(element);
        return result.insertedId as any;
    }
    
    async readAll(): Promise<Book[]> {
        const books = await this.collection.find({}).toArray();
        return books;
    }

    async readById(id: any): Promise<Book | null> { 
        const objectId = new ObjectId(id);
        const book = await this.collection.findOne({"_id": objectId });
        return book;
    }

    async update(id: any, element: Book): Promise<void> { 
        const objectId = new ObjectId(id);
        await this.collection.updateOne({"_id": objectId }, { $set: element }); 
    }

    async delete(id: any): Promise<void> {
        const objectId = new ObjectId(id);
        await this.collection.deleteOne({ "_id": objectId });
    }

}
