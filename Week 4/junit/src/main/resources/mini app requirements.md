# Mini App for TDD
This document lists the simple requirements for the TDD example app

## App Purpose
This application is designed for storing usernames within database. All this application does is store usernames and make sure duplicates are not saved

## Requirements
- The application should store usernames as String objects in an ArrayList
  - return a success message if the username is stored
- It should not allow for duplicate usernames
  - throw DuplicateUserException if someone tries to store a duplicate username
    - error message should be "Username taken: please choose another"

## Test Driven Development Process
- Get requirements in order
  - What are your business logic rules?
- Outline your application
  - create your interface
  - create custom classes to represent business data
- write out tests for validating business logic can be achived
- implement methods to pass tests