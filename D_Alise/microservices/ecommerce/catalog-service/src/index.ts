import express from "express";
import bodyParser from "body-parser";
import mongoose from "mongoose";
import { createProduct, getAllProducts, getProductById } from "./adapters/http/ProductController";

const app = express();
const port = 3000;

app.use(bodyParser.json());

mongoose.connect("mongodb://localhost:27017/catalog")
  .then(() => console.log("MongoDB connected"))
  .catch(err => console.log(err));

app.post("/products", createProduct);
app.get("/products", getAllProducts);
app.get("/products/:id", getProductById);

app.listen(port, () => {
  console.log(`Catalog Service listening at http://localhost:${port}`);
});
