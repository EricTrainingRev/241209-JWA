Feature: Wiki Link Functionality

  Background:
    Given The user is on the wiki home page

  Scenario: English users of Wikipedia can browse the site in English
    When  The user clicks the English link
    Then  The user should be sent to the English version of Wikipedia

  Scenario Outline: Non-English Users of Wikipedia can browse the site in their preferred language
    When  The user clicks the "<language>" link of their choice
    Then  The user should be sent to the "<title>" page

  Examples:
    |language|title|
    |spanish |Wikipedia, la enciclopedia libre|
    |german  |Wikipedia – Die freie Enzyklopädie|