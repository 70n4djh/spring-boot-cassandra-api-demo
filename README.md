# spring-boot-cassandra-api-demo
This is a simple RESTful API for the purpose of learning how to use Spring Boot + Cassandra
The app is deployed onto GCP, the demo API is available at [here](http://35.197.110.104/products)

# REST API
The api does simple CRUD operations on a dummy product database

## Get all products
#### Request
`GET /products`
#### Response
1. Product list empty:
```
[]
```
2. Product list: 
```
[{
  "id": "936aca2c-745f-11ea-bc55-0242ac130003", 
  "name": "Product1", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
  "createdAt": "2020-04-03T16:44:54.674+0000",  
  "lastUpdated": "2020-04-03T16:44:54.674+0000"
}]
```

## Get all products by brand
#### Request
`GET /products/brand/:brand`
#### Response
1. Product list empty:
```
[]
```
2. Product list: 
```
[{
  "id": "936aca2c-745f-11ea-bc55-0242ac130003", 
  "name": "Product1", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
  "createdAt": "2020-04-03T16:44:54.674+0000",  
  "lastUpdated": "2020-04-03T16:44:54.674+0000"
}]
```

## Get all products by category: 
`GET /products/category/:category`
#### Response
1. Product list empty:
```
[]
```
2. Product list: 
```
[{
  "id": "936aca2c-745f-11ea-bc55-0242ac130003", 
  "name": "Product1", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
  "createdAt": "2020-04-03T16:44:54.674+0000",  
  "lastUpdated": "2020-04-03T16:44:54.674+0000"
}]
```

## Get product by ID
#### Request
`GET /product/:id`
#### Response
1. Product id not found:
```
HTTP/1.1 404 Not Found
```
2. Product id exists: (return updated product)
```
HTTP/1.1 200 OK

{
  "id": "936aca2c-745f-11ea-bc55-0242ac130003", 
  "name": "Product1", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
  "createdAt": "2020-04-03T16:44:54.674+0000",  
  "lastUpdated": "2020-04-03T16:44:54.674+0000"
}
```

## Create new product
#### Request
`POST /product`

POST body:
```
{
  "name": "newProductName", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
}
```
#### Response
```
HTTP/1.1 200 OK
{
  "id": "936aca2c-745f-11ea-bc55-0242ac130003", 
  "name": "newProductName", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
  "createdAt": "2020-04-03T16:44:54.674+0000",  
  "lastUpdated": "2020-04-03T16:44:54.674+0000"
}
```

## Update product
#### Request
`PATCH /product/:id`

Request body:
```
Content-type: application/json-patch+json

[{
  "op": "replace",
  "path": "/name",
  "value": "newProductName"
}]
```

#### Response
1. Product id not found:
```
HTTP/1.1 404 Not Found
```
2. Product id exists: (return updated product)
```
HTTP/1.1 200 OK

{
  "id": "936aca2c-745f-11ea-bc55-0242ac130003", 
  "name": "newProductName", 
  "price": 100, 
  "image": "sample_image_url", 
  "description": "some description", 
  "sellBy": "Each",
  "brand": "Brand1",
  "category": "Category1",
  "createdAt": "2020-04-03T16:44:54.674+0000",  
  "lastUpdated": "2020-04-03T16:44:54.674+0000"
}
```

## Delete product
#### Request
`DELETE /product/:id`
#### Response
1. Product id not found:
```
HTTP/1.1 404 Not Found
```
2. Product id exists:
```
HTTP/1.1 200 OK

{"message": "Product deleted", "productId": "936aca2c-745f-11ea-bc55-0242ac130003"}
```
