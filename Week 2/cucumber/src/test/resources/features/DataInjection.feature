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

  # When working with strings, if you want the test data injected you need to wrap the placeholder with
  # quotes, otherwise Cucumber will inject the string value into the step text directly and you will need
  # unique step implementations for each piece of data. See the phrase steps for an example of how this works
  Scenario Outline: Strings can be concatenated
    Given We start with the word "<wordOne>"
    And   We have the word "<wordTwo>"
    When  We concatenate the words
    Then  We should have the phrase <phrase>

  Examples:
    |wordOne|wordTwo|phrase|
    |Hello  |world  |Hello world|
    |Super  |coder  |Super-coder|
