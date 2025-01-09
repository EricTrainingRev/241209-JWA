# Coding Challenge: Genre Analysis

## Challenge

The Chinook Music Company wants to analyze the distribution of tracks across different genres. They are interested in knowing the number of tracks in each genre and the percentage of total tracks that each genre represents. Your task is to write an SQL query to retrieve this information.

Create a query that returns the `Genre` name, the number of tracks in the genre as `TrackCount`, and the percentage of total tracks in the genre as `Percentage`. The results should be sorted by the percentage in descending order.

You can assume the following table structures:![Chinook Database](Chinook-Database-ERD.png)
## Example
Given the tables and data in the Chinook database, the expected output of the query should look like:

| Genre       | TrackCount | Percentage |
|-------------|------------|------------|
| Rock        | 1297       | 30.12      |
| Jazz        | 1002       | 23.25      |
| Classical   | 789        | 18.32      |

## Constraints
- The output should include all genres that have tracks
- Sort the results by the percentage of total tracks in descending order
