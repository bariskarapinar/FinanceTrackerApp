# 💰 Finance Tracker App - Personal Educational Project

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" alt="Android" />
  <img src="https://img.shields.io/badge/Kotlin-2.1.0-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white" alt="Kotlin" />
  <img src="https://img.shields.io/badge/Architecture-MVVM-FF4081?style=for-the-badge" alt="Architecture" />
  <img src="https://img.shields.io/badge/UI-Jetpack_Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white" alt="Jetpack Compose" />
</p>

---

## 🌟 Overview

Welcome to the **Finance Tracker App**! This project is a **Personal Educational Endeavor** designed to master the modern Android development ecosystem. The goal was to build a robust, production-ready financial application while adhering to the highest standards of software engineering, Clean Architecture, and the **MAD (Modern Android Development)** approach.

This app allows users to track their daily transactions, visualize their financial health through a vibrant dashboard, and manage their income and expenses with ease.

---

## 🚀 Key Features

- **Vibrant Dashboard**: A visually stunning summary of Total Balance, Income, and Expenses using modern gradients.
- **Transaction Management**: Effortlessly add and track income/expense items with categories.
- **Persistent Storage**: Robust local data management using **Room Database**.
- **Modern Navigation**: Seamless screen transitions powered by **Jetpack Navigation**.
- **Reactive UI**: State-driven UI updates using **StateFlow** and **Jetpack Compose**.
- **Real-time Calculations**: Automatic balance updates as transactions are recorded.

---

## 📸 Visual Showcase

<p align="center">
  <img src="https://github.com/user-attachments/assets/119c6325-72c4-4ff0-85bb-29bc3325f6b4" width="24%">
  <img src="https://github.com/user-attachments/assets/90770ea2-3f58-461b-9ef3-3db18f64c53a" width="24%">
  <img src="https://github.com/user-attachments/assets/57b9ce17-b453-450e-9edf-ec430eab5269" width="24%">
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/c8790f2b-fe6c-4df5-b128-81b41441ed01" width="24%">
  <img src="https://github.com/user-attachments/assets/61cd86e3-9595-4c46-aafd-c54e48601c03" width="24%">
  <img src="https://github.com/user-attachments/assets/96615cb1-b6ca-4be5-9bcf-a06dfec13a03" width="24%">
</p>

---

## 🏗️ Architecture & Flow

This project strictly follows the **Clean Architecture** principles and the **MVVM (Model-View-ViewModel)** pattern to ensure scalability, maintainability, and testability.

### 🧩 MVVM Architecture Chart

```mermaid
graph TD
    subgraph UI_Layer [UI Layer - Jetpack Compose]
        View[Compose Screens]
        VM[TransactionViewModel]
    end

    subgraph Domain_Layer [Domain Layer - Business Logic]
        UC[Use Cases]
        Model[Domain Models]
    end

    subgraph Data_Layer [Data Layer - Infrastructure]
        Repo[Repository Implementation]
        Local[Room Database / DAOs]
        Remote[Retrofit / API Service]
    end

    View --> VM
    VM --> UC
    UC --> Repo
    Repo --> Local
    Repo --> Remote
    Repo -.-> Model
```

### 🌊 Data Flow Diagram

```mermaid
sequenceDiagram
    participant User as User (Compose UI)
    participant VM as TransactionViewModel
    participant UC as Use Cases
    participant Repo as FinanceRepository
    participant DB as Room Database

    User->>VM: Enter Transaction Info
    VM->>UC: AddTransactionUseCase(transaction)
    UC->>Repo: insertTransaction(transaction)
    Repo->>DB: Save Entity
    DB-->>Repo: Confirm Save
    Repo-->>VM: Flow Updated (StateFlow)
    VM-->>User: UI Updates with New Balance
```

---

## 🛠️ Tech Stack (MAD Skills)

This project leverages the latest tools and libraries recommended by Google for **Modern Android Development**.

| Category | Technology | Purpose |
| :--- | :--- | :--- |
| **Language** | [Kotlin](https://kotlinlang.org/) | Modern, concise, and safe programming. |
| **UI** | [Jetpack Compose](https://developer.android.com/jetpack/compose) | Declarative UI toolkit for building native UI. |
| **DI** | [Hilt (Dagger)](https://dagger.dev/hilt/) | Dependency injection for better modularity. |
| **Database** | [Room](https://developer.android.com/training/data-storage/room) | SQLite abstraction for local persistence. |
| **Networking** | [Retrofit](https://square.github.io/retrofit/) | Type-safe HTTP client for API communication. |
| **Async** | [Coroutines & Flow](https://kotlinlang.org/docs/coroutines-overview.html) | Reactive streams and structured concurrency. |
| **Navigation** | [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) | In-app navigation for Compose. |

---

## 📊 MAD Scorecard

| Modern Android Development Area | Score | Status |
| :--- | :--- | :--- |
| **Language (Kotlin)** | 10/10 | 100% Kotlin, using Coroutines/Flow. |
| **UI (Compose)** | 10/10 | Fully declarative UI with Material 3. |
| **Architecture (Jetpack)** | 9/10 | Use Cases, ViewModels, and Hilt. |
| **Storage (Room)** | 10/10 | Reactive Flow-based database. |
| **Networking (Retrofit)** | 9/10 | Ready for API integration. |

**Overall MAD Mastery: 🚀 EXCELLENT**

---

## 🎓 Learning Objectives

Through this project, I have successfully gained expertise in:
- **Clean Architecture**: Decoupling code into distinct layers (Data, Domain, UI).
- **Jetpack Compose**: Managing state, building custom layouts, and using modern themes.
- **Dependency Injection**: Mastering Hilt for managing complex dependency graphs.
- **Reactive Programming**: Using `Flow` and `StateFlow` for real-time UI updates.
- **Gradle & Build Systems**: Managing KSP, Hilt plugins, and Version Catalogs (`libs.versions.toml`).

---
