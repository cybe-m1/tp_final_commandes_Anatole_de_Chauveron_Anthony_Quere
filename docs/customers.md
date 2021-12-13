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

With this body as JSON :

```json
{
  "firstName": "Georges",
  "lastName": "Dupont",
  "phoneNumber": "0123456789"
}
```

- **[GET]** Get user by phone number :

```http request
http://localhost:8080/api/v0/customers/phonenumber/0123456789
```

- **[GET] Get user previous orders :

```http request
http://localhost:8080/api/v0/customers/1/previous_orders
```