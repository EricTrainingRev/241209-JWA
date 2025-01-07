Feature: We follow government regulations
  Rule: all user interactions with the system should be logged
    Example: user login
      Given on login page
      When  login attempt made
      Then  logs generated whether login successful or not

    Example: interact with resource
      Given logged in
      When  interact with planet
      Then  logs generated whether resource interaction successful or not