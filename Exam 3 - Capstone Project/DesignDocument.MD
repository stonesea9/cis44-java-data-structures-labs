# Exam 3 Capstone Project - Phase 1 Design Document
I chose **Option B: The Smart Scheduler**, which focuses on **Priority Queues and Heaps**.
## Project Title
**Emergency Room Triage Scheduler**
## Project Overview
For this project, I want to build a simple emergency room triage scheduling system in Java. In real life, emergency rooms do not always treat patients based only on arrival time. Patients with more serious symptoms need to be treated before patients with less urgent conditions.
I chose this topic because I had a personal experience taking my child to the emergency room. Since the symptoms were not very serious, we had to wait for a long time. I understood why the emergency room worked this way, but it made me interested in learning how this kind of priority system operates. This project will help me better understand how hospitals can manage patients more efficiently and assign treatment priority in a fair and organized way.

## Real-World Problem
The problem is that many patients may arrive at the emergency room at different times, but their medical needs are not all equally urgent. A patient with a serious condition should be treated before someone with a minor symptom, even if the less serious patient arrived earlier.
This system needs to manage incoming patients and always select the patient with the highest priority for treatment.

## Data Structure Choice
I will use a Max-Heap Priority Queue for this project. Each patient will have a priority level based on the seriousness of their condition. A higher priority number means the patient should be treated sooner. A heap is a good choice because it allows the system to quickly find and remove the highest-priority patient. When a new patient is added, the heap can reorganize itself using a bubbling-up process. When the highest-priority patient is removed, the heap restores order using a bubbling-down process.

## Main Classes

### Patient
The `Patient` class will store information about each patient.
Attributes:
- `name`
- `symptom`
- `priorityLevel`
- `arrivalOrder`

The `priorityLevel` represents the urgency of the patient’s condition. The `arrivalOrder` can be used to break ties when two patients have the same priority.
### EmergencyRoomScheduler
The `EmergencyRoomScheduler` class will manage the priority queue.
Main methods:
- `addPatient(Patient patient)`
- `treatNextPatient()`
- `peekNextPatient()`
- `isEmpty()`
- `size()`

This class will use a Max-Heap structure to make sure the most urgent patient is treated first.
### Main
The `Main` class will be used later to test the program. It will create patients, add them to the scheduler, and print whether the correct patient is selected first.

## UML Diagram

```text
+----------------------+
|       Patient        |
+----------------------+
| - name: String       |
| - symptom: String    |
| - priorityLevel: int |
| - arrivalOrder: int  |
+----------------------+
| + Patient(...)       |
| + getName(): String  |
| + getSymptom(): String |
| + getPriorityLevel(): int |
| + getArrivalOrder(): int  |
| + toString(): String |
+----------------------+

              used by

+--------------------------------+
|   EmergencyRoomScheduler       |
+--------------------------------+
| - heap: ArrayList<Patient>     |
| - arrivalCounter: int          |
+--------------------------------+
| + addPatient(patient: Patient): void |
| + treatNextPatient(): Patient  |
| + peekNextPatient(): Patient   |
| + isEmpty(): boolean           |
| + size(): int                  |
| - bubbleUp(index: int): void   |
| - bubbleDown(index: int): void |
| - compare(p1: Patient, p2: Patient): int |
+--------------------------------+
              tested by

+----------------------+
|        Main          |
+----------------------+
| + main(args: String[]): void |
+----------------------+

Big-O Expectations

The Max-Heap Priority Queue is efficient for this emergency room scheduling system. Adding a new patient takes O(log n) time because the patient may need to bubble up to the 
correct position in the heap. Removing the next patient to be treated also takes O(log n) time because the heap must bubble down after removing the root.

Checking the next patient with peekNextPatient() takes O(1) time because the highest-priority patient is always stored at the root of the heap. The size() and isEmpty() 
methods also take O(1) time.
Overall, this design is better than using an unsorted list because an unsorted list would require O(n) time to search for the highest-priority patient. A heap keeps the 
emergency room scheduler is organized and efficient as more patients arrive.

Boundary and Edge Cases

This design should also handle special cases. If there are no patients in the scheduler, treatNextPatient() should return null or show that no patient is available. If two patients have the same priority level, the system can use arrivalOrder so the patient who arrived earlier is treated first. Invalid priority levels should also be handled carefully in the implementation phase. 
