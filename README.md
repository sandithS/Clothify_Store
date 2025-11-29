# 🛍️ Clothify Store Management System

**Clothify Store** is a modern, feature-rich Point-of-Sale (POS) and management system specifically designed for clothing and retail businesses. Developed using **JavaFX** for a user-friendly desktop experience and structured around a robust **Layered Architecture**, this system ensures efficient inventory control, streamlined sales transactions, and easy management of store operations.

## ✨ Key Features

  * **Secure User Authentication:** Role-based login system for Admin and Staff access.
  * **Product & Inventory Management:**
      * Add, edit, and categorize products (e.g., shirts, jeans, accessories).
      * Monitor real-time stock levels and low-stock alerts.
  * **Sales & Order Processing:**
      * Intuitive interface for placing new sales orders.
      * Calculate totals, manage discounts, and process payments.
      * Generate printable receipts/invoices.
  * **Customer Management:** Maintain detailed customer profiles and purchase history.
  * **Staff/Employee Management:** Manage employee details and roles within the system.
  * **Supplier Management:** Track and manage vendor/supplier information.
  * **Reporting & Analytics:** Generate sales reports, inventory summaries, and other business intelligence reports (often using tools like JasperReports).
  * **Modern UI/UX:** Utilizes **JFoenix** to implement Google Material Design principles for a sleek, responsive, and visually appealing interface.

## 💻 Technology Stack

| Category | Technology | Purpose |
| :--- | :--- | :--- |
| **Frontend/UI** | **JavaFX** | Desktop application framework. |
| **UI Components** | **JFoenix** | Material Design components library for JavaFX. |
| **Language** | **Java** (JDK 17+) | Core programming language. |
| **Persistence** | **MySQL** | Relational database for data storage. |
| **ORM/Connector** | JDBC (or Hibernate) | Database connectivity and mapping. |
| **Build Tool** | **Maven** | Dependency management and project build. |
| **Utilities** | **Lombok** | Boilerplate code reduction. |

## 🏗️ Architecture

The project adheres to a strict **Layered Architecture** (often referred to as N-tier) to achieve modularity and separation of concerns.

| Layer | Responsibility | Key Components |
| :--- | :--- | :--- |
| **1. Presentation** | User interaction, display, and event handling. | JavaFX FXML, Controllers |
| **2. Business (Service)** | Encapsulates all business logic, validation, and transaction management. | Service Interfaces & Implementations |
| **3. Data Access (Repository)** | Handles communication with the database (CRUD operations). | DAO Interfaces & Implementations (JDBC/Hibernate) |

## 🚀 Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

  * Java Development Kit (**JDK 22**)
  * **Maven** (3.6.0+)
  * **MySQL Server** (Running instance)
  * A compatible IDE (IntelliJ IDEA or Eclipse) with JavaFX support.

### Cloning and Setup

```bash
# Clone the repository
git clone https://github.com/sandithS/Clothify_Store.git
cd Clothify_Store
```

