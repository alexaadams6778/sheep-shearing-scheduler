# Sheep Shearing Scheduler

A Java program that schedules sheep shearing based on arrival and shearing times using a MinHeap priority queue.

## What it does
Reads a list of sheep (name, shearing time, arrival time) from a text file and determines the optimal shearing order.

## Key Features
- Custom MinHeap implementation  
- Greedy scheduling algorithm  
- File input/output and validation
- Command-line simulator (`SheepSchedulerSimulator.java`)

## How to Run
Compile and run from the command line:

```bash
javac -d out src/*.java
java -cp out SheepSchedulerSimulator sheep.txt
```

## Concepts Demonstrated
- Priority queues and heaps  
- Algorithmic scheduling  
- Object-oriented programming in Java  

## Author
Alexa Adams  
Algorithmic Design II — University of South Carolina
