# System Testing

## Functional vs Non-Functional
- Functional testing: checking that the features/services provided by an application work
- Non-Functional testing: checking the auxiliary parts of an application
    - environment
    - database
    - logging done
    - security
    - **performance**

## Performance Testing
Performance testing as a category refers to testing how well an application works, NOT if the application works. There are some standard types of performance tests:
- **Endurance Testing**: testing how well an application can run under the expected workload in production over a long period of time
    - the timeframe can be for a workday, full 24 hours, or longer, depending on the resources available to you and the company you are testing for
    - the goal of this testing is to look for long term issues that can only be discovered after a long period of time has passed
        - memory leak
        - logging mishaps
        - poor optimizations
    - metrics tracked:
        - cpu usage
        - memory usage
        - storage usage
    - in order for this type of testing to be useful you must have the resources to both host the test/real app and simulate user traffic over a long period of time
- **Performance Testing**: testing the responsiveness of the application under normal load
    - metrics tracked
        - how long does it take to complete a user request?
        - how much data can be processed at once?
        - how many requests are handled successfully over a period of time?
    - Performance testing is very common when Service Level Agreements (SLAs) are in place
- **Load Testing**: measuring performance of the application under differing loads of traffic
    - light load
    - expected load
    - heavy load
    - extreme load
- **Stress Testing**: continually increasing the load of the application to identify the breaking points