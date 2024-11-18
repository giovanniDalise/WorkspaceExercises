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
    readById(id) {
        return __awaiter(this, void 0, void 0, function* () {
            const objectId = new mongodb_1.ObjectId(id);
            const book = yield this.collection.findOne({ "_id": objectId });
            return book;
        });
    }
    update(id, element) {
        return __awaiter(this, void 0, void 0, function* () {
            const objectId = new mongodb_1.ObjectId(id);
            yield this.collection.updateOne({ "_id": objectId }, { $set: element });
        });
    }
    delete(id) {
        return __awaiter(this, void 0, void 0, function* () {
            const objectId = new mongodb_1.ObjectId(id);
            yield this.collection.deleteOne({ "_id": objectId });
        });
    }
}
exports.MongoStorage = MongoStorage;
