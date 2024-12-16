Feature: Cucumber can test Scenarios and Rules

  # If you want to specify the rule you are testing (business, security, etc.)
  # you can use the Rule keyword if you are using Cucumber version 6 or later
  Rule:  Can't divide by 0
    
    # an Example section is used instead of Scenario when using the Rule syntax, but
    # it functions the same as a Scenario
    Example: dividing by 0 does not work
      # because we already defined the code for "we have the number <numTwo>"
      # Cucumber can reuse that code here, but instead of getting data from an
      # examples table we are providing it directly
      Given   We have the number 10
      When    We try to divide by 0
      Then    The system should throw an exception
