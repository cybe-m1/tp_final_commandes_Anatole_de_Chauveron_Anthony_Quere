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
  "name": "Le Croque",
  "description": "La contribution millénaire d'un des plus valeureux chevalier de Kaamelott.",
  "price": 3.5,
  "tva": 1.5,
  "type": "MAIN"
}
```

Response :
```json
{
  "id": 6,
  "name": "Le Croque",
  "description": "La contribution millénaire d'un des plus valeureux chevalier de Kaamelott.",
  "type": "MAIN",
  "price": 3.5,
  "tva": 1.5
}
```

- **[GET]** Get all dishes :

```http request
http://localhost:8080/api/v0/dishes
```

Response :
```json
[
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
    "id": 4,
    "name": "Compote de pomme",
    "description": "Il faut pas respirer la compote, ça fait tousser.",
    "type": "DESERT",
    "price": 5.0,
    "tva": 0.1
  },
  {
    "id": 5,
    "name": "Poulet frit",
    "description": "Elle est où la poulette ?",
    "type": "MAIN",
    "price": 5.0,
    "tva": 0.1
  },
  {
    "id": 6,
    "name": "Le Croque",
    "description": "La contribution millénaire d'un des plus valeureux chevalier de Kaamelott.",
    "type": "MAIN",
    "price": 3.5,
    "tva": 1.5
  }
]
```

- **[GET]** Search dishes :

```http request
http://localhost:8080/api/v0/dishes?search=fr
```

Response :
```json
[
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
  },
  {
    "id": 5,
    "name": "Poulet frit",
    "description": "Elle est où la poulette ?",
    "type": "MAIN",
    "price": 5.0,
    "tva": 0.1
  }
]
```

