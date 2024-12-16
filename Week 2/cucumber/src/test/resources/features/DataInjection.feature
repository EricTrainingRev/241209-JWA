# Anytime you need to execute the same steps but with new test
# data, you can utilize Cucumber's Scenario Outline and Examples
# syntax
Feature: Cucumber data injection

  # A Scenario Outline is the same as a Scenario, but it tells
  # Cucumber that there is test data that needs to be provided
  # to the scenario, and it is Cucumber's job to provide that data
  Scenario Outline: Math should work
    Given We start with the number <numOne>
    And   We have the number <numTwo>
    When  We add the numbers together
    Then  We should get the number <sum>

  # Anytime you need to organize your test data that will be
  # injected into your steps you use an Examples section. In this
  # section you create a table that organizes your test data, and
  # Cucumber can handle injecting the data for you
  Examples:
    |numOne|numTwo|sum|
    |5     |10    |15 |
    |8     |5     |13 |
