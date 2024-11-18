"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.getProductById = exports.getAllProducts = exports.createProduct = void 0;
const Product_1 = require("../../core/domain/Product");
const ProductRepository_1 = require("../persistence/ProductRepository");
const CatalogService_1 = require("../../core/application/CatalogService");
// Inizializza i repository
const productRepository = new ProductRepository_1.ProductRepository(); // Adattatore
const catalogService = new CatalogService_1.CatalogService(productRepository); // Core che dipende dal repository tramite iniezione
const createProduct = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const { name, description, price, stock } = req.body;
    const product = new Product_1.Product(String(new Date().getTime()), // Genera un ID temporaneo
    name, description, price, stock);
    yield catalogService.addProduct(product);
    res.status(201).send(product);
});
exports.createProduct = createProduct;
const getAllProducts = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const products = yield catalogService.getAllProducts();
    res.status(200).send(products);
});
exports.getAllProducts = getAllProducts;
const getProductById = (req, res) => __awaiter(void 0, void 0, void 0, function* () {
    const productId = req.params.id;
    const product = yield catalogService.getProductById(productId);
    if (!product) {
        res.status(404).send({ message: "Product not found" });
    }
    else {
        res.status(200).send(product);
    }
});
exports.getProductById = getProductById;
