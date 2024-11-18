export interface Storage<T> {
  insert(element: T): Promise<number>;
  readAll(): Promise<T[]>;
  readById(isbn: number): Promise<T | null>; // Cambia il nome del metodo da 'readById' a 'readByIsbn'
  update(isbn: number, element: T): Promise<void>; // Cambia il nome del metodo da 'update' a 'updateByIsbn'
  delete(isbn: number): Promise<void>; // Cambia il nome del metodo da 'delete' a 'deleteByIsbn'
}
