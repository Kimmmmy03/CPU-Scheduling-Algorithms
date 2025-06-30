# CPU Scheduling Algorithms

## Original Author  
This project is created and maintained by **Akmal Hakimi bin Abd Rashid**

---

## Introduction  
**CPU Scheduling Algorithms** is a Java-based console application developed as part of the **ISB16204 - Computer Organization and Operating Systems** course at **Universiti Kuala Lumpur (UniKL)** for the March 2024 session. The project was completed under the guidance of:

- **Course Lecturer**: Prof. Roslan

The main objective of this project is to simulate and analyze three fundamental CPU scheduling techniques:
- First Come First Serve (FCFS)
- Shortest Job First (SJF)
- Round Robin (RR)

Each algorithm is implemented using core Java programming concepts such as arrays, loops, conditionals, classes, and console input/output handling.

---

## Problem Statements & Objectives

### Problem Statements
- **Efficiency Analysis**: Understanding how scheduling affects waiting and response times in a CPU.
- **Manual Simulation Difficulty**: Manual calculations of scheduling behavior are time-consuming and error-prone.
- **Learning through Application**: Students benefit from simulating scheduling algorithms using code.

### Objectives
- Implement FCFS, SJF (Non-preemptive), and RR scheduling algorithms
- Accept dynamic user input for arrival and burst times
- Display detailed per-process information (arrival, burst, start, complete, wait)
- Calculate and display average waiting time for comparison
- Reinforce Java programming fundamentals through practical application

---

## Program Scope  

This project includes three individual Java programs:

### 🔵 FCFS.java  
Implements the **First Come First Serve** scheduling where the first arriving process is executed first.

### 🟢 SJF.java  
Implements the **Shortest Job First (Non-preemptive)** scheduling where the process with the shortest burst time among the ready processes is chosen.

### 🔴 RoundRobin.java  
Implements **Round Robin Scheduling** using a fixed time quantum (20 units). The implementation runs through 3 cycles of scheduling and calculates the average waiting time at the end.

Each program:
- Uses **Scanner** for input
- Calculates **start**, **completion**, and **waiting** times
- Prints a clear process table
- Displays **average waiting time**

---

## Sample Output

### FCFS Output
```text
First Come First Serve (FCFS)
![Screenshot 2025-06-30 172409](https://github.com/user-attachments/assets/46428a30-465b-4e4b-9879-21734554e8e4)

Short Job First (SJF)
![Screenshot 2025-06-30 172415](https://github.com/user-attachments/assets/5ae02001-d232-4f85-9f93-ca68794b9d5a)

Round Robin (RR)
![Screenshot 2025-06-30 172424](https://github.com/user-attachments/assets/f98b32c5-6554-4c3a-9f34-e32eb6fe1573)
