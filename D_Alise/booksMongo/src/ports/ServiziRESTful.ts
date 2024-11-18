import Book from "../models/Book";

export interface ServiziRESTful{
    post(element: Book): number;
    get(): Book[];
    getById(id: number):Book;
    put(id: number, element: Book):void;
    delete(id: number):void;
}