import { ProductRepositoryPort } from "../../core/ports/ProductRepositoryPort";
import { Product } from "../../core/domain/Product";
import mongoose, { Schema, Document, ObjectId } from "mongoose";

interface IProductDocument extends Document {
  _id: ObjectId; // Definisci _id come ObjectId
  name: string;
  description: string;
  price: number;
  stock: number;
}

const productSchema = new Schema<IProductDocument>({
  name: { type: String, required: true },
  description: { type: String, required: true },
  price: { type: Number, required: true },
  stock: { type: Number, required: true }
});

const ProductModel = mongoose.model<IProductDocument>("Product", productSchema);

export class ProductRepository implements ProductRepositoryPort {
  async save(product: Product): Promise<void> {
    const productDocument = new ProductModel(product);
    await productDocument.save();
  }

  async getAll(): Promise<Product[]> {
    const products = await ProductModel.find();
    return products.map(product => new Product(
      product._id.toString(),  // Ora _id è di tipo ObjectId e puoi chiamare toString
      product.name,
      product.description,
      product.price,
      product.stock
    ));
  }

  async getById(id: string): Promise<Product | null> {
    const product = await ProductModel.findById(id);
    if (!product) return null;
    return new Product(
      product._id.toString(),  // Conversione esplicita da ObjectId a stringa
      product.name,
      product.description,
      product.price,
      product.stock
    );
  }
}