<h1 align="center">TP FINAL - CUSTOMER, TRUCK AND ORDERS</h1>

_TP final de programmation par composant - Anatole de Chauveron et Anthony Quéré_

Ce dépot est le rendu final du dernier TP de programmation par composants, traitant de la partie sur les commandes.

___

**Author :** Anatole de Chauveron, Anthony Quéré

**Technos :** Java, Spring Boot

**Licence :** All rights reserved

___

## Summary

Les éléments à implémenter étaient les suivants :

| Component | Documentation | Code |
|:---|:---:|:---:|
| :people_holding_hands: Customers | [customer's doc](docs/customers.md) | [customer's code](src/main/java/com/fges/commandes/commandes/order) |
| :cake: Dishes | [dishe's doc](docs/dishes.md) | [dish's code](src/main/java/com/fges/commandes/commandes/dish) |
| :scroll: Menus | [menu's doc](docs/menus.md) | [menu's code](src/main/java/com/fges/commandes/commandes/menu) |
| :page_facing_up: Orders | [order's](docs/orders.md) | [order's code](src/main/java/com/fges/commandes/commandes/order) |
| :truck: Trucks | [truck's](docs/trucks.md) | [truck's code](src/main/java/com/fges/commandes/commandes/truck) |

## Utilisation

### Pré-requis

```bash
❯ java -version
openjdk version "11.0.11" 2021-04-20
```

### Installation

Pour installer le projet sur votre machine locale, lancez la commance suivante :

```bash
git clone https://github.com/cybe-m1/tp_final_commandes_Anatole_de_Chauveron_Anthony_Quere.git
```

### Lancement du projet

Ouvrez le projet dans un editeur de code, et lancez le projet.

:globe_with_meridians: Le projet tourne sur le port _8080_ par défaut, vous pouvez le changer dans .

## :test_tube: Tester les requêtes

Le code source du projet inclus un export de requetes pour le logicier Postman [ici](tp_component_prog_final.postman_collection.json).

Des fichiers `.http` sont également disponibles pour tester les requêtes dirrectement depuis votre IDE. La fonctionnalité est native sur Intellij IDEA Ultimate. 
Vous trouverez ces fichiers dans le dossier [http](https://github.com/cybe-m1/tp_final_commandes_Anatole_de_Chauveron_Anthony_Quere/tree/master/http).

Si vous avez modifié le port dans votre application.yml, vous devez également le modifier dans _http/http-client.env.json_.

## Authentication
L'authentification est gérée par spring security avec une Basic Auth. Les utilisateurs sont stockés en mémoire pendant l'execussions. 
Leurs credentials sont spécifiés dans le _application.yml_.

Toutes les routes nécessitent une authentification. Les routes avec une méthode GET peuvent être accéder par les utiliseurs avec les roles USER et ADMIN.
Les autres routes nécessitent le rôle ADMIN.

## Données et bases de données
2 bases de données sont disponibles avec ce projet, postgres et H2. La base H2 est selectionnée par défaut. 
### H2
Les données sont stockées en mémoire, 
la structure est générée par hibernate et des données de test sont crées depuis le fichier _data.sql_ dans les ressources.

### Postgres
La structure de la base est générée par hibernate, il n'y a pas de données par défaut afin d'évier d'ajouter des données à chaque démarrage.

```
➜ tree .
.
├── docs
│     ├── customers.md
│     ├── dishes.md
│     ├── menus.md
│     ├── orders.md
│     └── trucks.md
├── http
│     ├── customer.http
│     ├── dish.http
│     ├── http-client.env.json
│     ├── menu.http
│     ├── order.http
│     └── truck.http
├── mvnw
├── mvnw.cmd
├── pom.xml # Fichier de configuration maven
├── README.md # Vous êtes ici !
├── src
│     ├── main
│     │     ├── java
│     │     │     └── com
│     │     │         └── fges
│     │     │             └── commandes
│     │     │                 └── commandes
│     │     │                     ├── CommandesApplication.java
│     │     │                     ├── customer
│     │     │                     │     ├── CustomerController.java
│     │     │                     │     ├── Customer.java
│     │     │                     │     ├── CustomerNotFoundException.java
│     │     │                     │     ├── CustomerPhoneNumberTakenException.java
│     │     │                     │     ├── CustomerRepository.java
│     │     │                     │     ├── CustomerService.java
│     │     │                     │     ├── dto
│     │     │                     │     │     └── CreateCustomerRequestDto.java
│     │     │                     │     └── ICustomer.java
│     │     │                     ├── dish
│     │     │                     │     ├── DishController.java
│     │     │                     │     ├── Dish.java
│     │     │                     │     ├── DishNotFoundException.java
│     │     │                     │     ├── DishRepository.java
│     │     │                     │     ├── DishService.java
│     │     │                     │     ├── DishType.java
│     │     │                     │     ├── dto
│     │     │                     │     │     └── CreateDishRequestDto.java
│     │     │                     │     └── IDish.java
│     │     │                     ├── menu
│     │     │                     │     ├── dto
│     │     │                     │     │     ├── AddDishToMenuRequestDto.java
│     │     │                     │     │     └── CreateMenuRequestDto.java
│     │     │                     │     ├── IMenu.java
│     │     │                     │     ├── MenuController.java
│     │     │                     │     ├── Menu.java
│     │     │                     │     ├── MenuNotFoundException.java
│     │     │                     │     ├── MenuRepository.java
│     │     │                     │     └── MenuService.java
│     │     │                     ├── order
│     │     │                     │     ├── dto
│     │     │                     │     │     ├── AddDishRequestDto.java
│     │     │                     │     │     ├── AddMenuRequestDto.java
│     │     │                     │     │     ├── CreateOrderRequestDto.java
│     │     │                     │     │     └── TotalAmountResponseDto.java
│     │     │                     │     ├── IOrder.java
│     │     │                     │     ├── OrderController.java
│     │     │                     │     ├── Order.java
│     │     │                     │     ├── OrderNotFoundException.java
│     │     │                     │     ├── OrderRepository.java
│     │     │                     │     └── OrderService.java
│     │     │                     ├── orderdishes
│     │     │                     │     └── OrderDish.java # Liaison entre Dish et Menu
│     │     │                     ├── ordermenus
│     │     │                     │     └── OrderMenu.java # Liaison entre Order et Menu
│     │     │                     ├── truck 
│     │     │                     │     ├── dto
│     │     │                     │     │     └── CreateTruckRequestDto.java
│     │     │                     │     ├── ITruck.java
│     │     │                     │     ├── TruckController.java
│     │     │                     │     ├── Truck.java
│     │     │                     │     ├── TruckNotFoundException.java
│     │     │                     │     ├── TruckRepository.java 
│     │     │                     │     └── TruckService.java 
│     │     │                     └── users
│     │     │                         ├── AuthenticationConfig.java # Configuration de l'authentification pour le application.yml
│     │     │                         ├── SecurityConfig.java # Configuration de la sécurité dans l'application
│     │     │                         └── UserDefinition.java # Définition du model d'un utilisateur dans la configuration de l'application
│     │     └── resources
│     │         ├── application.yml # Fichier de configuration de l'application
│     │         └── data.sql # Fichier de donnée par défaut pour la base H2
│     └── test
│         └── java
│             └── com
│                 └── fges
│                     └── commandes
│                         └── commandes
│                             └── CommandesApplicationTests.java # Fichier de test par défaut
└── tp_component_prog_final.postman_collection.json # Collection postman du sujet

```



