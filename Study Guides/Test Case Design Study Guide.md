# Test Case Design Study Guide

## Terminology

### Test Case
A **test case** is a set of preconditions, inputs, actions, expected results, and postconditions, developed based on **test conditions**. **Test conditions** are testable aspects of a component or system identified as a basis for testing. This means that a **test case** is a formal collection of resources needed to do the actual testing, and the **test conditions** are the things that need to be tested

### Test Objective
**Test Objectives**, also known as test goals, are your end-reasons for testing. Some typical types of objectives:
- Evaluate work products
- Find defects
- Ensure coverage and compliance
- Reduce risk
- Verify requirements and completeness
- Provide general information
- Build confidence in product/service

### Test Object
Whatever you are testing, whether it be an individual component of an application or the entirety of an application, the thing being tested is your **test object**, also referred to as a test item. 

### Test Data
When creating test cases you will often have specific data sets for one or more of your test cases: this collection of data is your **test data**. Oftentimes initial **test data** can be aggregated and sorted during the test analysis activity, and then later specified once test conditions are determined. For instance, if your test object is a registration feature and your test objective is to validate username constraints are enforced by the application, during your test analysis you would determine what the constraints should be (character length, character types, unique, minimum number of non alphabet characters required, etc.), and then when designing your tests you would provide specific values that meet (or don't, depending on the type of testing you are doing) those constraints

### Test Suite
Similar or related test cases can be organized into groupings called **test suites**. These groupings can be due to related test objectives, test objects, test data, etc.

### Positive & Negative Testing
**Positive testing** and **negative testing**, also known as "happy path" and "sad path" testing, are two fundamental testing strategies. Positive testing is used too confirm that things work correctly when user interactions and data used are valid. For instance, if your test objective is to confirm a registration feature works correctly, you could do positive testing by checking that a new user is created in the system when a valid username and any other relevant details are provided to the system.

On the flip side, **negative testing** would involve the inverse: you would provide the system with invalid new user data (username that is too long, not enough characters, missing special characters, empty, etc) and confirm that the system does not create an account for the user

### Defect
A core goal of testing is to discover **defects**: a **defect** is any failed requirement or deviation of an expected outcome. This could be a business requirement not being met, a software feature not working correctly, gaining access to resources you are not supposed to, etc.

Note that the terms **defect** and "bug" can be used interchangeably, but **defect** is the more formal way of describing deviations from expected results

### Error
In software work, any mistake a developer adds to code, whether calling the wrong variable, forgetting to implement a business rule, or any other mistake, is called an **error**. It is **errors** that lead to defects being present in code

### Failure
Anytime a defect is executed/triggered in your application it will trigger one or more **failures**. Note that defects and **failures** represent the same thing, a deviation from the expected or required. The main difference is in how the defect is revealed: **failures** happen when a defect is triggered in a active application (this can be user discovered in production or tester discovered in the testing environment). This means that all **failures** are defects, but not all defects are **failures**.

## Technique

### Black Box & White Box Testing
**Black box** and **white box** testing are two fundamentally different approaches to testing software. In **black box** testing you build and execute tests based off the system specifications, design documentation, and your general understanding of how the application is supposed to work. It is called **black box** because the underlying implementation, the source code and application environment, is unavailable to you, and therefore should have no bearing on how you design your tests. This makes system and acceptance testing more prevalent in **black box testing**.

**White box** testing has the tester use the internal structure of the application being tested to create tests: the source code, internal configurations, application environment, and any other internally used resources are available to the tester. All levels of testing can be done in **white box** testing


### Black Box: State Transition Diagram
Anytime you have a system or service where there are multiple "states" to consider, a **state transition diagram** can be used to organize your data before creating your test cases. A **state transition diagram** is simply a flow chart that shows the various states in the service and the way they connect to each other. For instance, if you are testing a reimbursement system you may have the following states of a reimbursement request: "pending", "accepted", "rejected". Each state of the request would have different actions, expectations, and other general requirements associated with it, and if you have your states organized in a **state transition diagram** it will be easier to organize the tests you create and prevent redundant overlap

### Black Box: Decision Table
When a user must make a string of "decisions" using a service, such as providing multiple inputs to a form, a **decision table** can be used to organize the inputs and expected results of providing the data. For instance, if testing a login feature, you could craft a decision table where all combinations of "valid" usernames and passwords are matched with "invalid" usernames and passwords, and for each possible combo list the expected results (logged in or rejected). By organizing the data combinations in a **decision table** you can accommodate the potential combinations of inputs and test the inputs produce the expected results

### Black Box: Boundary Value Analysis
When creating test data for business requirements, there will often be "boundaries" that are specified by those requirements. For instance, if testing a registration feature, there may be limits on how many characters can be included in the username. These restrictions create your natural "boundaries", which make for great determiners for your test data. Determining what these boundaries are and organizing your test data by those boundaries is called **boundary value analysis**. Typically when performing **boundary value analysis** you would determine your boundaries and then organize your valid and invalid data by selecting values just in the boundaries of requirements and just outside the boundaries. You would then let these values represent their "class" of data in your tests

### Black Box: Equivalence Partitioning
Similar to boundary value analysis, **equivalence partitioning** is a technique where you divide your test data in to "classes" of data and use a single value to represent the entirety of the class. This technique is useful when you don't have requirements that create natural boundaries for your data, or when the amount of potential test data is overwhelmingly large. By implementing **equivalence partitioning** you can optimize the number of test cases you need while keeping your tests from being redundant
