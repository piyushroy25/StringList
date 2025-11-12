# StringList (Java)

A custom list Abstract Data Type (ADT) implemented in Java, featuring both array-based and linked-list-based versions. Demonstrates dynamic resizing, node manipulation, interface design, and core data-structure fundamentals.

---

## Overview
This project implements multiple versions of a **StringList** — a simplified alternative to Java’s `ArrayList<String>` and `LinkedList<String>`.

It showcases:
- Array-backed list logic  
- Linked-node data structures  
- Manual resizing  
- Append, insert, remove, and search operations  
- Interface-driven design (`StringList` interface)  
- Clean OOP structure  

---

## Key Features

### **ArrayStringList**
- Backed by a dynamically resizing `String[]`
- Doubling strategy for automatic capacity expansion  
- Fast random access (`O(1)`)
- Supports:
  - `add(String s)`
  - `insert(int index, String s)`
  - `remove(int index)`
  - `get(int index)`
  - `size()`
  - `contains(String s)`

### **LinkedStringList**
- Uses `Node` objects (singly-linked)
- Efficient insertion/removal at arbitrary positions  
- Memory-efficient for variable workloads  
- Same interface methods as ArrayStringList
