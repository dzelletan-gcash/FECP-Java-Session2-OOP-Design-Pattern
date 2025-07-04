# FECP Java Session2 OOP Design Pattern - Group 14

## 1. Group Information

| Name              | GitHub Username | Role |
|:------------------| :--- | :--- |
| **Kayne Rodrigo** | `kaynerodrigo` | Main Application & Patient Management |
| **Dzelle Tan**    | `dzelletan-gcash` | Service Management & Factory Pattern |
| **Andre Lacra**   | `Andyzxc4` | Billing Computation & Strategy Pattern |

---

## 2. Project Title

**Hospital Billing System**

---

## 3. Project Description

This project is a Java-based console application designed to manage a simple hospital billing process. It demonstrates core Object-Oriented Programming (OOP) principles and applies fundamental design patterns to handle patient registration, service management, and flexible billing computations.

The system allows a user to:
* Register new patients.
* Add various medical services (like Consultation, X-Ray, and Surgery) to a patient's record.
* Calculate the final bill by applying different discount strategies based on the payment method (e.g., HMO, Senior Citizen, Cash).

This project fulfills the requirements of the **Lab 3: Java OOP Capstone Project**.

---

## 4. Design Patterns Implemented

This project leverages two key design patterns to ensure a flexible and maintainable codebase.

### Factory Pattern
* **Purpose:** To create objects without exposing the creation logic to the client.
* **Implementation:** The `ServiceFactory` class is used to create different `Service` objects. The main application requests a service by type (e.g., "surgery"), and the factory handles the instantiation, decoupling the main system from the specific service classes.

### Strategy Pattern
* **Purpose:** To define a family of algorithms, encapsulate each one, and make them interchangeable.
* **Implementation:** The `BillingStrategy` interface defines a common method for bill calculation. Concrete classes like `HmoBillingStrategy`, `SeniorBillingStrategy`, and `CashBillingStrategy` implement this interface, each providing a different discount algorithm. The main system selects the appropriate strategy at runtime, allowing billing logic to be changed or added easily.

---

## 5. Project Structure

The project is organized into several classes, each with a distinct responsibility, following OOP principles.

## 6. Screenshot of Output

Here is a screenshot of the application running in the console.

![Application Screenshot](docs/screenshot.png)

*(**Instructions:** Replace `docs/screenshot.png` with the actual path to your screenshot in the repository. It's good practice to create a `docs` or `images` folder for this.)*