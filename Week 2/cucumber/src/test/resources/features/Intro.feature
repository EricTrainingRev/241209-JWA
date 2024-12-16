# A Feature is an overarching name or explanation for the content being tested in the feature file
Feature: Thing being tested
  you can provide extended descriptions after the Feature is declared

  # Background is used to provide shared starting conditions that all scenarios
  # in a feature file make use of
  # Note the official Cucumber documentation strongly suggests that
  # you use a Background section specifically for any setup that does
  # not neatly fit in your acceptance criteria steps. They suggest
  # things like being logged in, database organization, things the
  # user either would not have access to, or actions they would have
  # already taken before the scenario, be placed in the Background
#  Background:
#    Given Some starting condition

  # Scenarios are the actual tests: these sections are where you specify what aspect of the
  # "feature" is being tested. You may have multiple scenarios associated with a Feature, but you
  # can only have one Feature section per Feature file
  Scenario: positive test of thing being tested
    Given Some starting condition
    When  Some positive action is taken
    Then  Some positive outcome should be achieved
  # You can have multiple scenarios associated with a feature file,
  # they will run in the order they are present in the feature file
  # from top to bottom
  Scenario: negative test of the thing being tested
    Given Some starting condition
    When  Some negative action is taken
    Then  Some negative outcome should be prevented