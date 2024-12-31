# Service Layer Testing Requirements
This document outlines the testing requirements for the Service layer of the Planetarium application

## User Service
- All listed methods should have a Positive Unit Test validating functionality
- All listed methods should have Negative Unit Tests validating any associated requirements are enforced

### User Creation
- **Method**: `createUser`
- **Input**: `User` object with `username` and `password` fields set
    - `id` should be set to 0
- **Expected Output**:
    - **Success**:
        - String message "User created successfully" returned
    - **Failure**:
        - if username is invalid
            - throw unhandled 'UserFail` exception with message "Invalid username"
        - if password is invalid
            - throw unhandled 'UserFail` exception with message "Invalid password"

### Authentication
- **Method**: `authenticate`
- **Input**: `User` object with `username` and `password` fields set
    - `id` should be set to 0
- **Expected Output**:
    - **Success**:
        - `User` object returned with the `username` and `id` fields set
            - `password` should not be set
    - **Failure**:
        - if `username` is invalid
            - throw unhandled 'UserFail` exception with message "Invalid username"
        - if `password` is invalid
            - throw unhandled 'UserFail` exception with message "Invalid credentials"

## Planet Service
- All listed methods should have a Positive Unit Test validating functionality
- All listed methods should have Negative Unit Tests validating any associated requirements are enforced

### Planet Creation
- **Method**: `createPlanet`
- **Input**: `Planet` object with `planetname`, `ownerId`, and `imageData` fields set
    - `planetId` should be set to 0
- **Expected Output**:
    - **Success**:
        - return true `boolean` primitive
    - **Failure**:
        - if `planetName` is invalid
            - throw unhandled 'PlanetFail` exception with message "Invalid planet name"
        - if `imageData` is invalid
            - throw unhandled 'PlanetFail` exception with message "Invalid file type"

### Planet Retrieval for User
- **Method**: `selectByOwner`
- **Input**: user id as `int` primitive
- **Expected Output**:
    - **Success**:
        - `Planet` objects returned inside an `ArrayList` object
    - **Failure**:
        - empty `List` object

### Planet Deletion
- **Method**: `deletePlanet`
- **Input**: planet name as `String` object
- **Expected Output**:
    - **Success**:
        - true `boolean`
    - **Failure**:
        - throw unhandled 'PlanetFail` exception with message "Invalid planet name"

## Moon Service
- All listed methods should have a Positive Unit Test validating functionality
- All listed methods should have Negative Unit Tests validating any associated requirements are enforced

### Moon Creation
- **Method**: `createMoon`
- **Input**: `Moon` object with `moonName`, `ownerId` and `imageData` fields set
    - `id` should be set to 0
- **Expected Output**:
    - **Success**:
        - return true `boolean` primitive
    - **Failure**:
        - if `moonName` is invalid
            - throw unhandled 'MoonFail` exception with message "Invalid moon name"
        - if `ownerId` is invalid
            - throw unhandled 'MoonFail` exception with message "Invalid planet ID"
        - if `imageData` is invalid
            - throw unhandled 'MoonFail` exception with message "Invalid file type"

### Moon Retrieval for Planet
- **Method**: `selectByPlanet`
- **Input**: planet id as `int` primitive
- **Expected Output**:
    - **Success**:
        - `Moon` objects returned inside an `ArrayList` object
    - **Failure**:
        - empty `List` object returned

### Moon Deletion
- **Method**: `deleteMoon`
- **Input**: moon name as "String" object
- **Expected Output**:
    - **Success**:
        - true `boolean`
    - **Failure**:
        - if `moonName` is invalid
            - throw unhandled 'MoonFail` exception with message "Invalid moon name"
