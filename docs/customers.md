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

- **[POST]** Create a new customer :

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

- **[GET]** Get customer by phone number :

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

- **[GET] Get customer previous orders :

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

- **[GET]** List all customers :

```http request
http://localhost:8080/api/v0/customers
```

Response :
```json
[
  {
    "id": 1,
    "firstName": "Artur",
    "lastName": "Pendragon",
    "phoneNumber": "0123456789"
  },
  {
    "id": 2,
    "firstName": "Léodagan",
    "lastName": "De Carmélide",
    "phoneNumber": "1234567890"
  },
  {
    "id": 3,
    "firstName": "Perceval",
    "lastName": "De Galle",
    "phoneNumber": "2345678901"
  },
  {
    "id": 4,
    "firstName": "Karadoc",
    "lastName": "De Vanne",
    "phoneNumber": "3456789012"
  },
  {
    "id": 5,
    "firstName": "Lancelot",
    "lastName": "Du Lac",
    "phoneNumber": "4567890123"
  },
  {
    "id": 6,
    "firstName": "Guenièvre",
    "lastName": "De Carmélide",
    "phoneNumber": "5678901234"
  },
  {
    "id": 7,
    "firstName": "Bohort",
    "lastName": "De Gaune",
    "phoneNumber": "6789012345"
  },
  {
    "id": 8,
    "firstName": "Le père",
    "lastName": "Blaise",
    "phoneNumber": "7890123456"
  },
  {
    "id": 9,
    "firstName": "Séli",
    "lastName": "De Carmélide",
    "phoneNumber": "8901234567"
  },
  {
    "id": 10,
    "firstName": "Yvain",
    "lastName": "Chevalier au Lion",
    "phoneNumber": "9012345678"
  }
]
```
