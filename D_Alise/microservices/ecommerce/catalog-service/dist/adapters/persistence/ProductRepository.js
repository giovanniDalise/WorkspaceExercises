"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
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
exports.ProductRepository = void 0;
const Product_1 = require("../../core/domain/Product");
const mongoose_1 = __importStar(require("mongoose"));
const productSchema = new mongoose_1.Schema({
    name: { type: String, required: true },
    description: { type: String, required: true },
    price: { type: Number, required: true },
    stock: { type: Number, required: true }
});
const ProductModel = mongoose_1.default.model("Product", productSchema);
class ProductRepository {
    save(product) {
        return __awaiter(this, void 0, void 0, function* () {
            const productDocument = new ProductModel(product);
            yield productDocument.save();
        });
    }
    getAll() {
        return __awaiter(this, void 0, void 0, function* () {
            const products = yield ProductModel.find();
            return products.map(product => new Product_1.Product(product._id.toString(), // Ora _id è di tipo ObjectId e puoi chiamare toString
            product.name, product.description, product.price, product.stock));
        });
    }
    getById(id) {
        return __awaiter(this, void 0, void 0, function* () {
            const product = yield ProductModel.findById(id);
            if (!product)
                return null;
            return new Product_1.Product(product._id.toString(), // Conversione esplicita da ObjectId a stringa
            product.name, product.description, product.price, product.stock);
        });
    }
}
exports.ProductRepository = ProductRepository;
