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
  "name": "Roi Loth Truck",
  "description": "Ave Cesar, rosae rosam, et spiritus rex ! Ah non, parce que là, j’en ai marre !"
}
```

Response :

```json
{
  "id": 4,
  "name": "Roi Loth Truck",
  "description": "Ave Cesar, rosae rosam, et spiritus rex ! Ah non, parce que là, j’en ai marre !"
}
```

- **[GET]** Get all Trucks :

```http request
http://localhost:8080/api/v0/trucks/
```

Response : 
```json
[
  {
    "id": 1,
    "name": "Les petits pédestres",
    "description": "Le truck de Yvain et Gauvain !"
  },
  {
    "id": 2,
    "name": "Le clan des semis croustillants",
    "description": "Le truck de Provencal et Karadoc !"
  },
  {
    "id": 3,
    "name": "Les petits pédestres dont un au Lion",
    "description": "La nouvelle experience de Yvain et Gauvain"
  },
  {
    "id": 4,
    "name": "Roi Loth Truck",
    "description": "Ave Cesar, rosae rosam, et spiritus rex ! Ah non, parce que là, j’en ai marre !"
  }
]
```

- **[GET]** Search Trucks :

```http request
http://localhost:8080/api/v0/trucks?search=a
```

Response :
```json
[
  {
    "id": 2,
    "name": "Le clan des semis croustillants",
    "description": "Le truck de Provencal et Karadoc !"
  },
  {
    "id": 3,
    "name": "Les petits pédestres dont un au Lion",
    "description": "La nouvelle experience de Yvain et Gauvain"
  }
]
```