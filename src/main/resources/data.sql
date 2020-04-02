use sample;

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
