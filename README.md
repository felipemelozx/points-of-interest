## Voting system


This project was a solution to the challenge proposed on [GitHub repository](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md), where the goal was to create a service that would
return points (coordinates) near a point and a maximum distance provided by the user.

This application was developed using Java and Spring Web, and its operation is simple but efficient. The service is designed to assist users in locating Points of Interest (POIs)
based on GPS coordinates. By leveraging a database of predefined POIs, the system offers two key functionalities:
Registering Points of Interest: Users can add POIs to the database, each with three attributes: a name, and its X and Y coordinates (both non-negative integers).
Finding POIs by Proximity: Users can specify a reference point (X, Y) and a maximum distance (d-max) in meters. The system calculates the proximity of each POI from the reference point and returns those that are within the given distance.
## Technology

Here are the technologies used in this project:

* Java version 17.0.0
* Spring Boot 3.4.0
* H2 database


## Dependencies

* Spring Boot Starters
    - spring-boot-starter-web
    - spring-data-jpa
    - h2-database
    - spring-boot-starter-test (scope test)

## Getting Started

### Pre-requisites

- Java 17
- Maven

### Build and Run

1. Clone the repository:
    ```bash
    git clone https://github.com/felipemelozx/points-of-interest
    cd ./points-of-interest
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```
3. Run the project:
    ```bash
    mvn spring-boot:run
    ```

4. Access the application at `http://localhost:8080/point-interest`

## Routes
- ####  Make a GET on the route returns all registered points that are close to the given point and within the maximum distance
- GET `http://localhost:8080/point-interest`
- Body👇
 ```json
{
  "name": "lanchonete",
  "coordinateX": 20,
  "coordinateY": 10
}
```
- ####   Make a GET on the route returns all registered points
- GET `http://localhost:8080/point-interest/get-all`
- Body👇
 ```json
{}
```
- ####  Make a POST on this route and record the point present in the body of the request
- POST `http://localhost:8080/point-interest/save-point`
- Body👇
 ```json
{
  "coordinateX": 20,
  "coordinateY": 10,
  "maxD": 10
}
```
- ####   Make a POST to this route and record all the points present in the request body.
- POST `http://localhost:8080/point-interest/save-many-points`
- Body - Register as many points as you want👇
 ```json
{
  "listPointDto":[
    {
      "name": "lanchonete",
      "coordinateX": 20,
      "coordinateY": 10
    },
    {
      "name": "Posto",
      "coordinateX": 31,
      "coordinateY": 18
    },
    {
      "name": "Joalheria",
      "coordinateX": 15,
      "coordinateY": 12
    }
  ]
}
```

## Links

- Repository: https://github.com/felipemelozx/point-of-interest

## Versioning

0.0.1-SNAPSHOT

## Authors

* **Felipe Melo**

Please follow GitHub and join us! Thanks for visiting and happy coding!