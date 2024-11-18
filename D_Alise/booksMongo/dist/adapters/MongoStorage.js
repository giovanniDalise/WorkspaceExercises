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
Object.defineProperty(exports, "__esModule", { value: true });
exports.MongoStorage = void 0;
const mongodb_1 = require("mongodb");
const url = 'mongodb://127.0.0.1:27017';
const dbName = 'corso';
const collectionName = 'books';
class MongoStorage {
    constructor() {
        this.client = new mongodb_1.MongoClient(url);
    }
    connect() {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.client.connect();
            const db = this.client.db(dbName);
            this.collection = db.collection(collectionName);
        });
    }
    disconnect() {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.client.close();
        });
    }
    insert(element) {
        return __awaiter(this, void 0, void 0, function* () {
            const result = yield this.collection.insertOne(element);
            return result.insertedId;
        });
    }
    readAll() {
        return __awaiter(this, void 0, void 0, function* () {
            const books = yield this.collection.find({}).toArray();
            return books;
        });
    }
    readById(isbn) {
        return __awaiter(this, void 0, void 0, function* () {
            const book = yield this.collection.findOne({ isbn });
            return book;
        });
    }
    update(isbn, element) {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.collection.updateOne({ isbn }, { $set: element });
        });
    }
    delete(isbn) {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.collection.deleteOne({ isbn });
        });
    }
}
exports.MongoStorage = MongoStorage;
