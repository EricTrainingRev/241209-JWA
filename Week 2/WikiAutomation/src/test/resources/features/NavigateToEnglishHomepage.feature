Feature: English readers should be able to view Wikipedia in English
  Scenario: Going to the English version of Wikipedia
    Given   The English user is on the Wikipedia main page
    When    The English user clicks the English link
    Then    The English user should be sent to the English homepage of Wikipedia