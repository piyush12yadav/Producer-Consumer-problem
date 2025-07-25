# 🧵💻 Producer-Consumer Problem in Java (Multithreading)

This project showcases the classic 🔁 **Producer-Consumer Problem** using Java's **multithreading** model with `synchronized`, `wait()`, and `notify()` for thread communication over a **bounded buffer**.

---

## 📌 Problem Statement

The Producer-Consumer problem is a timeless multithreading challenge:

👨‍🏭 **Producer** creates data → 🧍‍♂️ **Consumer** processes it → using a shared buffer 🧺  
Rules:
- Producer 🛑 **waits** if buffer is full  
- Consumer 🛑 **waits** if buffer is empty  
- Both must access buffer in a thread-safe 👮‍♂️ manner

---

## 🧠 Core Concepts Used

| 🔧 Concept            | 📖 Description                                                                   |
|----------------------|-----------------------------------------------------------------------------------|
| 🔐 `synchronized`     | Ensures exclusive access to shared resource                                        |
| ⏳ `wait()`           | Suspends a thread until it's safe to continue                                      |
| 🔔 `notify()`         | Wakes up a waiting thread to resume execution                                      |
| 🧠 Monitor Lock       | Ensures only one thread accesses a critical section at a time                     |

---

## 🌍 Real-World Applications

- 🛒 **E-commerce Checkout** – Order producer & inventory manager consumer  
- 📋 **Logging System** – App writes logs (producer) and logger thread consumes  
- 📡 **Sensor Network** – IoT devices push data, analytics system consumes

---

## 🧪 How It Works (Code Snippet)

```java
SharedResource shared = new SharedResource(3);
Thread producer = new Thread(() -> shared.produce(...));
Thread consumer = new Thread(() -> shared.consume());
