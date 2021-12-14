## :cake: Dishes

Dishes are either contained in menus, or directly added in orders.

### Schema

```json
{
  "id": "id",
  "name": "Name",
  "description": "Description",
  "price": 10.0,
  "tva": 1.5,
  "type": "MAIN"
}
```

### Routes

Here are the availables routes for `dishes` :

- **[POST]** Create new dish :

```http request
http://localhost:8080/api/v0/dishes
```

With this body as JSON :

```json
{
  "name": "Name",
  "description": "Description",
  "price": 10.0,
  "tva": 1.5,
  "type": "MAIN"
}
```

- **[GET]** Get all dishes :

```http request
http://localhost:8080/api/v0/dishes
```