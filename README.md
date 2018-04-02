# TheatreSeating
Barclays Design problem

# Theatre Seating 

This program parses a theater layout and a list of ticket requests and produces a list of tickets or explanations in the same order as the requests received.   

## Getting Started

In Eclipse or Any development IDE for java, Import as Java Project. 

### Prerequisites

```
Java 1.7 or 1.8
IDE like Eclipse 

```

### Installing and Demo

Run as Java Application from main class: TheatreSeating.java


Sample Input's & Output's

Provide inputs from console. Inputs were read using scanner class.

```
Enter number of rows for a theatre layout:
5
Enter number of seats in each section seperated by space for each row: 
6 6
3 5 5 3
4 6 6 4
2 8 8 2
6 6
Please enter ticket requests:
Please type "end" when done.
Smith 2
Jones 5
Davis 6
Wilson 100
Johnson 3
Williams 4
Brown 8
Miller 12
end

Output:

Smith Row 1 Section 1
Jones Row 2 Section 2
Davis Row 1 Section 2
Wilson Sorry, we can't handle your party.
Johnson Row 2 Section 1
Williams Row 1 Section 1
Brown Row 4 Section 2
Miller Call to split party.

```

## Built With

* [Java Application]

