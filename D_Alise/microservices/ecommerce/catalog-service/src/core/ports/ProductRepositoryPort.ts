import { Product } from "../domain/Product"; 

export interface ProductRepositoryPort {    //output port
  save(product: Product): Promise<void>;
  getAll(): Promise<Product[]>;
  getById(id: string): Promise<Product | null>;
}
