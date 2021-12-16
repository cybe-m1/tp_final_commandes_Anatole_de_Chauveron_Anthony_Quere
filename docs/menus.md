## 📜 Menus

Menus are a group of dishes, and can be ordered by customers.

### Scheme

```json
{
  "id": 1,
  "name": "Menu name",
  "description": "Menu description",
  "tva": 1.5,
  "dishes": []
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
  "name": "Le gras c'est la vie",
  "description": "Un repas regroupant les meilleurs création de la légende",
  "tva": 1.5,
  "dishes": []
}
```

Response :

```json
{
  "id": 4,
  "name": "Le gras c'est la vie",
  "description": "Un repas regroupant les meilleurs création de la légende",
  "tva": 1.5,
  "dishes": []
}
```

- **[Get]** List all menus :

```http request
http://localhost:8080/api/v0/menus
```

```json
[
  {
    "id": 1,
    "name": "Le Petit frichti",
    "description": "Pour les grand voyageurs",
    "tva": 0.3,
    "dishes": [
      {
        "id": 1,
        "name": "Tarte aux fraises",
        "description": "Sans vouloir la ramener, la seule différence concrète avec des briques, c'est que vous appelez ça des tartes !",
        "type": "DESERT",
        "price": 5.0,
        "tva": 0.1
      },
      {
        "id": 3,
        "name": "Lasagnes végétariennes",
        "description": "JE NE MANGE PAS DE GRAINES !",
        "type": "MAIN",
        "price": 5.0,
        "tva": 0.1
      },
      {
        "id": 2,
        "name": "Assiette de fromage",
        "description": "Arthour !… Pas changer assiette pour fromage !",
        "type": "ENTRY",
        "price": 4.0,
        "tva": 0.15
      }
    ]
  },
  {
    "id": 2,
    "name": "Le Banquet",
    "description": "Pour les grand gourmands",
    "tva": 0.31,
    "dishes": [
      {
        "id": 1,
        "name": "Tarte aux fraises",
        "description": "Sans vouloir la ramener, la seule différence concrète avec des briques, c'est que vous appelez ça des tartes !",
        "type": "DESERT",
        "price": 5.0,
        "tva": 0.1
      },
      {
        "id": 2,
        "name": "Assiette de fromage",
        "description": "Arthour !… Pas changer assiette pour fromage !",
        "type": "ENTRY",
        "price": 4.0,
        "tva": 0.15
      }
    ]
  },
  {
    "id": 3,
    "name": "Le repas de belle maman",
    "description": "Pour ceux qui ont les dents solides",
    "tva": 0.32,
    "dishes": []
  },
  {
    "id": 4,
    "name": "Le gras c'est la vie",
    "description": "Un repas regroupant les meilleurs création de la légende",
    "tva": 1.5,
    "dishes": []
  }
]
```

- **[Get]** Add dish to menu :

```http request
http://localhost:8080/api/v0/menus/1/dishes
```

Body :
```json
{
  "dishId": "4"
}
```

Response :
```json
{
  "id": 1,
  "name": "Le Petit frichti",
  "description": "Pour les grand voyageurs",
  "tva": 0.3,
  "dishes": [
    {
      "id": 3,
      "name": "Lasagnes végétariennes",
      "description": "JE NE MANGE PAS DE GRAINES !",
      "type": "MAIN",
      "price": 5.0,
      "tva": 0.1
    },
    {
      "id": 4,
      "name": "Compote de pomme",
      "description": "Il faut pas respirer la compote, ça fait tousser.",
      "type": "DESERT",
      "price": 5.0,
      "tva": 0.1
    },
    {
      "id": 2,
      "name": "Assiette de fromage",
      "description": "Arthour !… Pas changer assiette pour fromage !",
      "type": "ENTRY",
      "price": 4.0,
      "tva": 0.15
    },
    {
      "id": 1,
      "name": "Tarte aux fraises",
      "description": "Sans vouloir la ramener, la seule différence concrète avec des briques, c'est que vous appelez ça des tartes !",
      "type": "DESERT",
      "price": 5.0,
      "tva": 0.1
    }
  ]
}
```

- **[Delete]** Remove dish from menu :

```http request
http://localhost:8080/api/v0/menus/1/dishes/2
```

```json
{
  "id": 2,
  "name": "Le Banquet",
  "description": "Pour les grand gourmands",
  "tva": 0.31,
  "dishes": [
    {
      "id": 1,
      "name": "Tarte aux fraises",
      "description": "Sans vouloir la ramener, la seule différence concrète avec des briques, c'est que vous appelez ça des tartes !",
      "type": "DESERT",
      "price": 5.0,
      "tva": 0.1
    }
  ]
}
```