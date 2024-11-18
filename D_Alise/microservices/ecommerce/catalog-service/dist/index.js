"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = __importDefault(require("express"));
const body_parser_1 = __importDefault(require("body-parser"));
const mongoose_1 = __importDefault(require("mongoose"));
const ProductController_1 = require("./adapters/http/ProductController");
const app = (0, express_1.default)();
const port = 3000;
app.use(body_parser_1.default.json());
mongoose_1.default.connect("mongodb://localhost:27017/catalog")
    .then(() => console.log("MongoDB connected"))
    .catch(err => console.log(err));
app.post("/products", ProductController_1.createProduct);
app.get("/products", ProductController_1.getAllProducts);
app.get("/products/:id", ProductController_1.getProductById);
app.listen(port, () => {
    console.log(`Catalog Service listening at http://localhost:${port}`);
});
