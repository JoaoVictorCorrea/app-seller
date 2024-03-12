# AppSeller

![](https://i.imgur.com/mBkemZW.png)

## About this Project

The idea of the App is:

"Manipulate seller registrations in a simple way."

PS: Seller Registration was just the context chosen by me for this project, but all the code inside this application can be reused for any application that has CRUD as a domain, so you can reuse everything here in your next CRUD or anything inside this context!

## Why?

This project is part of my personal portfolio and my assessment on the [BootcampDevJr](https://bootcampdevjr.com/) course, so I'll be happy if you can give me any feedback on the project, code, structure or that you can report that could make me a better developer!

Email-me: correa.joaov25@gmail.com

Connect with me at [LinkedIn](https://www.linkedin.com/in/joaovcorrea/).

Also, you can use this Project as you wish, be for study, be for make improvements or earn money with it!

It's free!

## Some Observations about this App

1 - This is a monorepo, that is, it contains both the backend and the frontend in the same repository.

2 - The Home screen is for UI issues only.

3 - He is responsive.

## Installers

[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - for the backend.

[Node](https://nodejs.org/en/download) - to install Angular.

## Functionalities

- Sellers

    - Register a seller.
    - Update a seller.
    - Delete a seller.
    - Consult a seller.
    
## API Sellers

This is a RESTful API developed in Spring Boot to manage sellers in a registration system. It provides endpoints to perform CRUD (Create, Read, Update, Delete) operations on sellers.

### Endpoints

- List all Sellers
    ```
    GET /sellers
    ```
    Returns a list of all registered sellers.

- Get a Seller
    ```
    GET /sellers/{id}
    ```
    Returns the details of a specific seller based on the provided ID.

- Register a new Seller
    ```
    POST /sellers
    ```
    Creates a new seller with the data provided in the request body.

- Update a Seller
    ```
    PUT /sellers/{id}
    
    Updates an existing seller's details based on the provided ID and data provided in the request body.
    ```

- Remove a Seller
     ```
    DELETE /sellers/{id}
    ```
    Removes an existing seller based on the provided ID.
    

### Data Models

- SellerRequestDTO
     ```
    {
        "name": "string",
        "salary": "double",
        "bonus": "double",
        "gender": "int"
    }
    ```

- SellerResponseDTO
     ```
    {
        "id": "long"
        "name": "string",
        "salary": "double",
        "bonus": "double",
        "gender": "int"
    }
    ```

### Validation Constraints

- Name: is mandatory and must have a minimum of 5 characters and a maximum of 255 characters.

- Salary: is mandatory and must be greater than or equal to 1.

- Bonus: is mandatory and must be between 0 and 100.

- Gender: is mandatory and must be 0 (female) or 1 (male).

## Getting Started

### Prerequisites

To run this project in development mode, you will need to have a basic environment to run an Angular and Java-Spring application, which can be found [here (Angular)](https://angular.io/quick-start) and [here (Java)](https://www.java.com/en/download/help/windows_manual_download.html).

### Installing

```
$ git clone https://github.com/JoaoVictorCorrea/app-seller.git

$ cd app-seller/frontend
```

**Installing dependencies**

```
$ npm install
```

### Running

With all dependencies installed and the environment properly configured, you can now run the app:

API - Java-Spring
```
$ cd ../backend

With the left mouse button, select the AppSellerApplication.java file and run Java.
```

Angular
```
$ cd ../frontend

$ ng build

$ ng serve

$ Navigate to `http://localhost:4200/`
```

## Built With

- Frontend

    - Angular
    - TypeScript
    - Ng-Bootstrap
    
- Backend

    - Java
    - Spring Boot
    - Spring Web
    - Spring Data JPA
    - Spring Validation
    - Spring DevTools
    - Maven
    
## Contributing

You can send how many PR's do you want, I'll be glad to analyse and accept them! And if you have any question about the project...

Email-me: correa.joaov25@gmail.com

Connect with me at [LinkedIn](https://www.linkedin.com/in/joaovcorrea/)

Thank you!
