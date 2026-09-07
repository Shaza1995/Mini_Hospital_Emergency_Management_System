# Mini Hospital Emergency Management System

## Introduction

The Mini Hospital Emergency Management System is a Java-based application designed to manage patients, emergency treatment, treatment history, and previous patient visits using different data structures.

## Data Structures Used

- Binary Search Tree (BST) – Patient registration, searching, deletion, and display
- Queue – Emergency patient management using FIFO
- Stack – Completed treatment history using LIFO
- Singly Linked List – Previous patient visit management

## Main Features

### Patient Management
- Register new patients
- Search patients by Patient ID
- Delete patients
- Display all patients in Patient ID order

### Emergency Queue
- Add patients to the emergency queue
- Treat the next patient
- Display waiting patients
- FIFO operation

### Treatment Stack
- Add completed treatments
- Remove the latest treatment
- Display treatment history
- LIFO operation

### Patient Visit History
- Add previous visits
- Remove visits
- Search visits
- Display visit history

## Technologies Used

- Java
- Visual Studio Code
- Git
- GitHub

## Project Structure

```text
Mini_Hospital_Emergency_Management_System
├── .gitignore
├── README.md
├── src
│   └── hospital
│       ├── Patient.java
│       ├── PatientBST.java
│       ├── EmergencyQueue.java
│       ├── Treatment.java
│       ├── TreatmentStack.java
│       ├── Visit.java
│       ├── VisitLinkedList.java
│       └── HospitalManagementSystem.java
└── out