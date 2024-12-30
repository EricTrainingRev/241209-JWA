# Full Stack 3 Tier Architecture Review
In a 3 tier full stack app, the different layers of the application are intended to perform specific tasks
- Controller Layer (API)
    - handles interpreting incoming interactions by the user and converts any relevant data into a format the application can understand
        - think converting a HTTP request json into a Java object
    - also handles returning data from the application to the end user, and converting the data into a meaningful format
        - think converting a Java object into a HTTP response json
- Service Layer
    - handles enforcing the requirements of the application, receives and returns data from the Controller layer
        - requirements == business logic
    - if the data from the Controller layer meets all requirements then it is passed along to the Repository layer if required in order for one or more queries to the assocaited database to be made. Data returned from the Repository layer is checked to make sure all requirements are being followed, and then sent up to the Controller layer to be returned to the end user
- Repository Layer (DAO)
    - handles interacting with the associated database
        - takes data that is assumed to be valid from the Service layer and injects it into sql queries in order to find the desired rows in the database
    - once data is retrieved, it is converted into a meaningful format and returned to the Service layer for validation
        - think converting data from a ResultSet into one or more Java objects