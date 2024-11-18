import { Request, Response } from "express";
import { ProductServicePort } from "../../core/ports/ProductServicePort";
import { Product } from "../../core/domain/Product";
import { ProductRepository } from "../persistence/ProductRepository";
import { CatalogService } from "../../core/application/CatalogService";

// Inizializza i repository
const productRepository = new ProductRepository();// Adattatore
const catalogService = new CatalogService(productRepository); 
// Core che dipende dal repository tramite iniezione, sto dicendo che questo servizio 
// utilizzerà mongo nello specifico definendo l'implementazione e facendo si che il core sia slegato all'implementazione

export const createProduct = async (req: Request, res: Response): Promise<void> => {
  const { name, description, price, stock } = req.body;
  const product = new Product(
    String(new Date().getTime()), // Genera un ID temporaneo
    name,
    description,
    price,
    stock
  );
  await catalogService.addProduct(product);
  res.status(201).send(product);
};

export const getAllProducts = async (req: Request, res: Response): Promise<void> => {
  const products = await catalogService.getAllProducts();
  res.status(200).send(products);
};

export const getProductById = async (req: Request, res: Response): Promise<void> => {
  const productId = req.params.id;
  const product = await catalogService.getProductById(productId);
  if (!product) {
    res.status(404).send({ message: "Product not found" });
  } else {
    res.status(200).send(product);
  }
};
