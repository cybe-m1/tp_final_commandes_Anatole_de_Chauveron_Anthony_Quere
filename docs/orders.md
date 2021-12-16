## :page_facing_up: Orders

Orders are taken by customers and linked to trucks. Then can contain menus or dishes.

### Scheme

```json
{
  "id": "1",
  "truckId": "1",
  "customerId": "1",
  "dishs": [],
  "menus": []
}
```

### Routes

Here are the availables routes for `orders` :

- **[POST]** Create new order :

```http request
http://localhost:8080/api/v0/orders
```

```json
{
  "customerId": "4",
  "truckId": "1"
}
```

Response :
```json
{
  "id": 3,
  "customer": {
    "id": 1,
    "firstName": "Artur",
    "lastName": "Pendragon",
    "phoneNumber": "0123456789"
  },
  "truck": {
    "id": 3,
    "name": "Les petits pédestres dont un au Lion",
    "description": "La nouvelle experience de Yvain et Gauvain"
  },
  "dishes": [],
  "menus": []
}
```

- **[PUT]** Add dish to order :

```http request
http://localhost:8080/api/v0/orders/5/dishes
```

With this body as JSON :

```json
{
  "dishId": "2"
}
```

Response :
```json
{
  "id": 2,
  "customer": {
    "id": 1,
    "firstName": "Artur",
    "lastName": "Pendragon",
    "phoneNumber": "0123456789"
  },
  "truck": {
    "id": 1,
    "name": "Les petits pédestres",
    "description": "Le truck de Yvain et Gauvain !"
  },
  "dishes": [
    {
      "id": 3,
      "quantity": 1,
      "dish": {
        "id": 1,
        "name": "Tarte aux fraises",
        "description": "Sans vouloir la ramener, la seule différence concrète avec des briques, c'est que vous appelez ça des tartes !",
        "type": "DESERT",
        "price": 5.0,
        "tva": 0.1
      }
    }
  ],
  "menus": []
}
```

- **[PUT]** Add menu to order :

```http request
http://localhost:8080/api/v0/orders/5/menus
```

With this body as JSON :

```json
{
  "menuId": "2"
}
```

Response :
```json
{
  "id": 2,
  "customer": {
    "id": 1,
    "firstName": "Artur",
    "lastName": "Pendragon",
    "phoneNumber": "0123456789"
  },
  "truck": {
    "id": 1,
    "name": "Les petits pédestres",
    "description": "Le truck de Yvain et Gauvain !"
  },
  "dishes": [
    {
      "id": 3,
      "quantity": 1,
      "dish": {
        "id": 1,
        "name": "Tarte aux fraises",
        "description": "Sans vouloir la ramener, la seule différence concrète avec des briques, c'est que vous appelez ça des tartes !",
        "type": "DESERT",
        "price": 5.0,
        "tva": 0.1
      }
    }
  ],
  "menus": []
}
```

- **[GET]** Get total amount of order :

```http request
http://localhost:8080/api/v0/orders/1/total
```

Response :
```json
{
  "price": 0.0,
  "tva": 0.0,
  "total": 0.0
}
```