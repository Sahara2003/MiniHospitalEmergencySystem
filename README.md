# 🏥 Mini Hospital Emergency Management System

> A Java-based hospital management system implementing four fundamental data structures for the CIT300 Data Structures & Algorithms course.

---

## 📋 Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Data Structures Used](#data-structures-used)
- [Project Structure](#project-structure)
- [How to Run](#how-to-run)
- [Sample Output](#sample-output)
- [GitHub Repository](#github-repository)
- [Author](#author)
- [Date](#date)

---

## 📖 Overview

This is a **Mini Hospital Emergency Management System** developed as part of the CIT300 Mid Assignment. The system demonstrates the practical implementation of four key data structures:

1. **Binary Search Tree (BST)** - Patient Records Management
2. **Queue** - Emergency Patient Queue (FIFO)
3. **Stack** - Treatment History (LIFO)
4. **Singly Linked List** - Patient Visit History

---

## ✨ Features

### 1. Patient Records (BST)
- ✅ Insert new patients
- ✅ Search patients by Patient ID
- ✅ Delete patients from records
- ✅ Display patients in ascending ID order (In-order traversal)

### 2. Emergency Queue (Queue - FIFO)
- ✅ Enqueue - Add patient to waiting list
- ✅ Dequeue - Treat next patient in line
- ✅ Display all waiting patients

### 3. Treatment History (Stack - LIFO)
- ✅ Push - Add completed treatment record
- ✅ Pop - Remove most recent treatment
- ✅ Display treatment history (most recent first)

### 4. Visit History (Singly Linked List)
- ✅ Add a new visit
- ✅ Remove an existing visit
- ✅ Search for a visit by ID
- ✅ Display complete visit history

---

## 📊 Data Structures Used

### 🌳 Binary Search Tree (BST)
- **Purpose**: Store and manage patient records
- **Key**: Patient ID (auto-generated)
- **Operations**: Insert, Search, Delete, In-order Traversal
- **Time Complexity**: O(log n) average case

### 🚑 Queue
- **Purpose**: Manage emergency patients waiting for treatment
- **Principle**: FIFO (First-In, First-Out)
- **Operations**: Enqueue, Dequeue, Display
- **Time Complexity**: O(1) for all operations

### 📚 Stack
- **Purpose**: Store treatment history
- **Principle**: LIFO (Last-In, First-Out)
- **Operations**: Push, Pop, Display
- **Time Complexity**: O(1) for all operations

### 🔗 Singly Linked List
- **Purpose**: Store patient visit history
- **Operations**: Add, Remove, Search, Display
- **Time Complexity**: O(n) for search/remove, O(1) for add at end

---

## 📁 Project Structure
MiniHospitalEmergencySystem/
│
├── src/
│ ├── Patient.java # Patient model class
│ ├── Visit.java # Visit model class
│ ├── PatientBST.java # BST implementation
│ ├── EmergencyQueue.java # Queue implementation
│ ├── TreatmentStack.java # Stack implementation
│ ├── VisitHistory.java # Singly Linked List implementation
│ └── Main.java # Main program with console menu
│
├── README.md # Project documentation
└── .gitignore # Git ignore file

Sample Output
========================================
   MINI HOSPITAL EMERGENCY SYSTEM
========================================
1. Add Patient
2. Search Patient
3. Delete Patient
4. Display Patients (In-order)
5. Add Emergency Patient
6. Treat Next Patient
7. Display Emergency Queue
8. Add Treatment Record
9. Remove Latest Treatment
10. Display Treatment History
11. Add Patient Visit
12. Remove Patient Visit
13. Search Patient Visit
14. Display Visit History
0. Exit
========================================
Enter your choice:

🔗 GitHub Repository
Repository URL: https://github.com/Sahara2003/MiniHospitalEmergencySystem

Commit History: https://github.com/Sahara2003/MiniHospitalEmergencySystem/commits/main/

👩‍💻 Author
Sahara
ID - 23DA2-1009
CIT300 - Data Structures & Algorithms
Sri Lanka Technological Campus (SLTC)

📅 Date
5th September 2026
