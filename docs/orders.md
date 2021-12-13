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

- **[PUT]** Add dish to order :

```http request
http://localhost:8080/api/v0/orders/5/menus
```

With this body as JSON :

```json
{
  "menuId": "2"
}
```