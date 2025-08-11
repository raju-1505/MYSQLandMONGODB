//MongoDB queries for the *product.json* dataset from database (https://github.com/rvsp/database/blob/master/mongodb/product.json).

// 1. Find all the information about each product
db.product.find({});

// 2. Find the products whose price is between 400 and 800
db.product.find({product_price: { $gte: 400, $lte: 800 }});

// 3. Find the products whose price is not between 400 and 600
db.product.find({ $or: [ { product_price: { $lt: 400 } },{ product_price: { $gt: 600 } }]});

// 4. List four products which have price greater than 500
db.product.find({ product_price: { $gt: 500 } }).limit(4);

// 5. Find the product name and product material of each product
db.product.find({}, { product_name: 1, product_material: 1, _id: 0 });

// 6. Find the product with a row id of 10
db.product.find({ id: "10" });

// 7. Find only the product name and product material
db.product.find({}, { product_name: 1, product_material: 1, _id: 0 });

// 8. Find all products which have the value "Soft" in product_material
db.product.find({ product_material: "Soft" });

// 9. Find products which have product_color "indigo" and product_price 492.00
db.product.find({ product_color: "indigo",product_price: 492.0});

// 10. Delete the products whose product_price value is 28
db.product.deleteMany({ product_price: 28 });
