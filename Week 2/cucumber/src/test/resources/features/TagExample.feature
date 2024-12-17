# You can use tags to mark up your Features, Scenarios, Scenario Outlines, and Examples. These tags
# can be used as targets for your hooks so that your hooks only trigger for the scenarios/features you
# need them to trigger for.
@Search
Feature: Search Feature

  @Mobile
  Scenario: Mobile search
    Given website open in phone

  @Desktop
  Scenario: Desktop search
    Given website open in desktop browser