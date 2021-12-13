## :truck: Truck

Trucks are the places where the customers take orders.

### Scheme

```json
{
    "id": "1",
    "name": "Truck name",
    "description": "Truck description"
}
```

### Routes

Here are the availables routes for `truck` :

- **[POST]** Create new truck :

```http request
http://localhost:8080/api/v0/trucks/
```

With this body as JSON :

```json
{
    "name": "Truck name",
    "description": "Truck description"
}
```

- **[GET]** Get all Trucks :

```http request
http://localhost:8080/api/v0/trucks/
```