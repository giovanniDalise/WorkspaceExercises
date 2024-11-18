export interface Storage<T> {
  insert(element: T): Promise<number>;
  readAll(): Promise<T[]>;
  readById(isbn: number): Promise<T | null>;
  update(isbn: number, element: T): Promise<void>; 
  delete(isbn: number): Promise<void>; 
}
