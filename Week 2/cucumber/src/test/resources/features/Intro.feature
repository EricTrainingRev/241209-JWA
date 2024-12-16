# A Feature is an overarching name or explanation for the content being tested in the feature file
Feature: Thing being tested
  you can provide extended descriptions after the Feature is declared
  # Scenarios are the actual tests: these sections are where you specify what aspect of the
  # "feature" is being tested. You may have multiple scenarios associated with a Feature, but you
  # can only have one Feature section per Feature file
  Scenario: positive test of thing being tested
    Given Some starting condition
    When  Some positive action is taken
    Then  Some positive outcome should be achieved