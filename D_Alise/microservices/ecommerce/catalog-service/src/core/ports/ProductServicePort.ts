import { Product } from "../domain/Product"; 

export interface ProductServicePort {   //input port
  addProduct(product: Product): Promise<void>;
  getAllProducts(): Promise<Product[]>;
  getProductById(id: string): Promise<Product | null>;
}
