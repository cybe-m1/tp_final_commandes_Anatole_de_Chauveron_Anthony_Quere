## :people_holding_hands: Customers

Customers are able to take orders, and are identified by a unique phone number

### Scheme

```json
{
  "id": 1,
  "firstName": "Georges",
  "lastName": "Dupont",
  "phoneNumber": "0123456789"
}
```

### Routes

Here are the availables routes for `customers` :

- **[POST]** Create a new user :

```http request
http://localhost:8080/api/v0/customers
```

Body :

```json
{
  "firstName": "Bohort",
  "lastName": "De Gaune",
  "phoneNumber": "9876543210"
}
```

Response :
```json
{
  "id": 11,
  "firstName": "Bohort",
  "lastName": "De Gaune",
  "phoneNumber": "9876543210"
}
```

- **[GET]** Get user by phone number :

```http request
http://localhost:8080/api/v0/customers/phonenumber/0123456789
```

Response :
```json
{
  "id": 1,
  "firstName": "Artur",
  "lastName": "Pendragon",
  "phoneNumber": "0123456789"
}
```

- **[GET] Get user previous orders :

```http request
http://localhost:8080/api/v0/customers/1/previous_orders
```

Reponse :
```json
[
  {
    "id": 1,
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
    "dishes": [],
    "menus": []
  },
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
    "dishes": [],
    "menus": []
  }
]
```