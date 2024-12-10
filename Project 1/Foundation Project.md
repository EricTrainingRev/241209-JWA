# JWA Foundation Project
The Planetarium is a web application designed by Revature Space Initiative for astronomers to track celestial bodies they discover in the night sky. Development work on the application is progressing, and the company wants to bring in testers to implement Quality Control to improve product quality. Your job this Sprint is to build an initial test suite with two main goals: to look for defects in the product, and to give feedback on the user experience working with the app

## Project Technology Focus
- Jira
- Manual Testing
- Automated Testing
- Test Case Creation
- Test Reporting
- System Testing
- Acceptance Testing

## Setup Requirements

### Database Setup
- an environment variable called "DATABASE_URL" needs to be set with the JDBC url for the planetarium database
    - SQLite3 is used by the application
- a database needs to be created and set up for the planetarium to work properly. Use the ```setup-reset.sql``` file to create the database at the same location as your "DATABASE_URL" environment variable

### Webserver Setup
- an environment variable called "PLANETARIUM_URL" needs to be set with the url for the webserver
    - if running the app locally set it to "localhost:8080"
    - if running in the cloud set it to "{public ip or dns}:8080"

### Application start
-  start the application with the command ```java -jar path/to/Planetarium-1.0.jar```
