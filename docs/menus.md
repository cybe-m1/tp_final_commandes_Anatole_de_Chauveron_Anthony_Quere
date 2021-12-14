## 📜 Menus

Menus are a group of dishes, and can be ordered by customers.

### Scheme

```json
{
  "id": 1,
  "name": "Menu name",
  "description": "Menu description",
  "tva": 1.5,
  "dishes": [],
  "menus": []
}
```

### Routes

Here are the availables routes for `menus` :

- **[POST]** Create new menu :

```http request
http://localhost:8080/api/v0/menus
```

With this body as JSON :

```json
{
  "name": "Menu name",
  "description": "Menu description",
  "tva": 1.5,
  "dishes": []
}
```
