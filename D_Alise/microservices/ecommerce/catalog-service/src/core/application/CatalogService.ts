import { ProductServicePort } from "../ports/ProductServicePort";
import { ProductRepositoryPort } from "../ports/ProductRepositoryPort";
import { Product } from "../domain/Product";

// Nel core (CatalogService), il repository viene iniettato nel costruttore
export class CatalogService implements ProductServicePort {
  constructor(private productRepository: ProductRepositoryPort) {}

  async addProduct(product: Product): Promise<void> {
    await this.productRepository.save(product); // Dipendenza iniettata
  }

  async getAllProducts(): Promise<Product[]> {
    return this.productRepository.getAll(); // Dipendenza iniettata
  }

  async getProductById(id: string): Promise<Product | null> {
    return this.productRepository.getById(id); // Dipendenza iniettata
  }
}
