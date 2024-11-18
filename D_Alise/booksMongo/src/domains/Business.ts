import Book from "../models/Book";
import { Storage } from "../ports/Storage";

export class Business<T extends Book> {   //di tipo T che estende la classe Book. quindi è una sottoclasse generica di Book
    constructor(private storage: Storage<T>) {}
   //quando creiamo un istanza di business possiamo specificare il tipo del parametro generico T 
    async insert(element: T): Promise<number> { 
        return this.storage.insert(element);
    }

    async readAll(): Promise<T[]> { 
        return this.storage.readAll();
    }

    async readById(id: number): Promise<T | null> { 
        return this.storage.readById(id);
    }

    async update(id: number, element: T): Promise<void> { 
        return this.storage.update(id, element);
    }

    async delete(id: number): Promise<void> { 
        return this.storage.delete(id);
    }
}
