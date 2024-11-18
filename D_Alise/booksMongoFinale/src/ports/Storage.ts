export interface Storage<T> {
  insert(element: T): Promise<number>;
  readAll(): Promise<T[]>;
  readById(id: any): Promise<T | null>;
  update(id: any, element: T): Promise<void>; 
  delete(id: any): Promise<void>; 
}
