CREATE KEYSPACE IF NOT EXISTS sample WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE sample;

CREATE TABLE product(
    id uuid PRIMARY KEY,
    name text,
    price int,
    image text,
    description text,
    sellBy text,
    brand text,
    category text,
    createdAt timestamp,
    lastUpdated timestamp
);

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Apples', 1000, 'https://sample.jpg', 'Doles'' produce: A bag of apples', 'Each', 'Dole', 'Grocery', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Oranges', 1200, 'https://sample.jpg', 'A bag of organic oranges', 'Each', 'Local Farm', 'Grocery', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Broccoli', 1000, 'https://sample.jpg', 'Locally produced broccoli', 'Per pound', 'Local Farm', 'Grocery', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Bannas', 1000, 'https://sample.jpg', 'A bag of bannas', 'Each', 'Dole', 'Grocery', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Nike Air Force womens', 11000, 'https://sample.jpg', 'Nike Air Force 1 Sage Low features a platform midsole and a pared-down upper for a bold yet feminine look.', 'Each', 'Nike', 'Shoes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Nike Air Max 2090', 15000, 'https://sample.jpg', 'Inspired by the iconic Air Max 90, the 2090 features Nike Air cushioning underfoot that adds unparalleled comfort, while transparent mesh on the upper blend with timeless OG features for an edgy, modernized look.', 'Each', 'Nike', 'Shoes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Men''s adidas 3-Stripe Track Pant', 28000, 'https://sample.jpg', 'Get your fitness wardrobe on the right track with these men''s adidas pants', 'Each', 'Addidas', 'Clothes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Adidas logo print hoodie', 6900, 'https://sample.jpg', 'Purple cotton logo print hoodie from adidas featuring a relaxed fit, a hood with drawstring tie fastenings, long sleeves, fitted cuffs and a cropped length. POSITIVELY CONSCIOUS: This product is made with a material widely recognised as being better for the planet, so you can be confident you are choosing positively.', 'Each', 'Addidas', 'Clothes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Addidas NMD_R1 shoes', 140000, 'https://sample.jpg', 'Iconic NMD plugs in the midsole stay true to the signature look', 'Each', 'Addidas', 'Shoes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Addidas STAN SMITH shoes', 140000, 'https://sample.jpg', 'True to its original design, the Stan Smith''s classic silhouette has endured sneaker style for over four decades.', 'Each', 'Addidas', 'Shoes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Nike Sportswear Club Printed Pullover Hoodie', 68000, 'https://sample.jpg', 'Stay comfortable during any activity with this men''s Nike pullover hoodie', 'Each', 'Nike', 'Clothes', dateof(now()), dateof(now()));

INSERT INTO product(id, name, price, image, description, sellBy, brand, category, createdAt, lastUpdated)
VALUES (uuid(), 'Nike Club Fleece Crew', 30000, 'https://sample.jpg', 'Nike sweatshirt is always a solid choice', 'Each', 'Nike', 'Clothes', dateof(now()), dateof(now()));
