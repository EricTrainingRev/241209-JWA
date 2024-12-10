# Testing Intro

## Testing Mindset
- As a developer, you have the mindset of "this is going to work"
- As a tester, you have the mindset of "this has errors/mistakes, and I am going to find them"

## Why Test
- There are a multitude of reasons to test
    - validate a piece of software works
    - discover defects
        - ANYTHING unexpected is a defect
    - aggregating metrics for reporting purposes
    - build confidence in the product

Testing is not just about validating an application works, there are a multitude of auxiliary uses for testing

## Quality Management
Testing, whether validating an app works correctly or gathering metrics, is fundamentally about maintaining a high level of "quality". Quality Management has two main categories of activities:
- Quality Assurance
    - focus
        - process-oriented
        - preventative
    - "good practice leads to good quality"
    - QA is testing your work flow
- Quality Control
    - focus
        - product-oriented
        - corrective
    - actually testing a product to validate it works correctly
    - QC is testing your work product

## Requirements
Requirements are any features, rules, processes, etc., that are a part of an application or service. For instance, consider an application that has a login feature: that login feature is a "requirement" of the application. Requirements can also be narrow: consider a registration feature. There may be limits on what usernames are allowed (must be unique, must contain certain characters, must NOT contain certain characters, etc.).

## Verification & Validation
Most testing falls under verification and validation:
- verification answers the question "are we building the product correctly?"
    - verification typically involves static testing
        - does not require running software
            - checking documentation
            - checking logs are configured correctly
            - checking workflows are useful
- validation answers the question "are we building the right product?"
    - validation typically involves dynamic testing
        - requires running software
            - checking features of an application work correctly
            - checking performance measurements are being met

# Testing Principles
- Testing reveals defects, not their absence
- Exhaustive testing is impossible
- Test early
- Defects cluster
- Tests wear out (Pesticide Paradox)
- Testing is Contextual
- Absence of error fallacy
