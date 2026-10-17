# 🏛️ Core Academic Monorepo: Advanced OOP, Concurrency & Transactional Persistence

This repository serves as an authoritative **Engineering Portfolio Index**. It centralizes the chronological architecture progression, thread-safety milestones, data validation structures, and relational persistence tracks across a 9-week academic cycle at **Duoc UC**.

---

## 📈 9-Week Conceptual & Architectural Evolution Timeline (SpeedFast to SchoolLibrary)

The modules below document my shift from linear procedural execution into thread-safe, decoupled, and hardened production-oriented code.

### 🟢 Phase 1: Domain Representation, Encapsulation & Behavioral Blueprints [Weeks 1 - 2]
Focused on memory modeling, encapsulation boundaries, and sealing execution sequences.

#### 📦 Week 01: State Traceability & Primitive Modeling
* **Core Objective:** Establish immutable state control and deterministic execution paths.
* **Engineering Impact:** Prevented runtime data corruption in delivery orders through defensive constraint validation. Protected distance and weight parameters using `final` modifiers. Logic and orchestration remained collapsed within the entity; no service boundary existed.

#### 📦 Week 02: Sequential Lifecycle Locking via Template Method
* **Core Objective:** Mitigate architectural leaks and enforce algorithmic sequence immutability.
* **Engineering Impact:** Implemented the **Template Method Pattern** (`public final void ejecutarProceso()`) to freeze the dispatch execution order. Leveraged granular visibility scopes (`public`, `protected`, `private`) to prevent subclass subversion.

---

### 🟡 Phase 2: Dynamic Swapping & Priority Ordering [Weeks 3 - 4]
Shifted focus toward decoupling infrastructure strategies and driving runtime flexibility via open-ended hierarchies.

#### 📦 Week 03: Runtime Algorithmic Inversion via Strategy Pattern
* **Core Objective:** Eradicate nested conditional branching (`if/else` inflation) when assigning transport fleets.
* **Engineering Impact:** Decoupled vehicle routing mechanics using the **Strategy Pattern** via `DespachoStrategy`. Configured stateless process strategies (`DespachoMoto`, `DespachoCamion`) that query execution states safely on demand using the `this` pointer context.

#### 📦 Week 04: Unified Priority Ordering Contracts & Managed Allocation
* **Core Objective:** Manage workload prioritization in memory and transition into managed execution runtimes.
* **Engineering Impact:** Implemented the strong-typed **`Comparable<Pedido>`** contract to sort order sequences automatically by urgency via `TipoPedido` enums (Food > Express > Freight). Abandoned raw threads to instantiate a managed context via `Executors.newFixedThreadPool`. Shared history write mutations were protected using a thread-safe `CopyOnWriteArrayList`.

---

### 🔴 Phase 3: Lock-Free Concurrency & UI Integration [Weeks 5 - 6]
Transitioned into multi-threaded runtime environments, managing shared memory buffers and asynchronous desktop layouts.

#### 📦 Week 05: High-Performance Producer-Consumer Concurrency
* **Core Objective:** Multithreaded workload distribution and lock-free thread synchronization.
* **Engineering Impact:** Built a **Producer-Consumer architecture** using a thread-safe `LinkedBlockingQueue` inside `ZonaDeCarga.java`. Worker threads extract payloads atomically via `.poll()`, confining synchronization strictly to task ownership inside the JDK queue and removing "check-then-act" race conditions.

#### 📦 Week 06: Asynchronous GUI Integration & Functional Callbacks
* **Core Objective:** Integration of Java Swing UI and clean cross-thread interaction.
* **Engineering Impact:** Decoupled layout orchestration using an MVC flow. Pushed visual mutations safely to the Event Dispatch Thread (EDT) via `SwingUtilities.invokeLater()`. Decoupled logging execution paths using short instance-level monitors on a functional `LogListener` callback.

---

### 🛢️ Phase 4: Full Relational Matrix & Security Hardening [Weeks 7 - 8]
The relational peak of the SpeedFast track: integrating persistent state management, database offloading, and enterprise environment controls.

#### 📦 Week 07: Multi-Tier Persisted Frameworks & Layer Separation
* **Core Objective:** Transition transient RAM states into a persistent relational infrastructure under shifting requirements.
* **Engineering Impact:** Implemented full structural layer separation (**MVC + DAO + DB**). Encapsulated raw SQL queries inside explicit `PreparedStatement` parameters wrapped in **try-with-resources** blocks across all data handlers to prevent resource leaks and SQL Injection risks.

#### 📦 Week 08: Full CRUD Matrix, Caching Optimization & Environment Hardening
* **Core Objective:** Complete data lifecycle mapping, in-memory compute optimization, and access token protection.
* **Engineering Impact:** REACHED full CRUD lifecycle management over primary aggregates via explicit DAO implementations. Optimized reporting performance by implementing **Java Streams and Lambda Expressions** to query local cached collections via partial matching predicates (`.contains()`), eliminating redundant network roundtrips to MySQL. Secured cross-table operations inside `EntregaDAO.create()` via atomic transactions (`setAutoCommit(false)` + `rollback()`). Mitigated plaintext credential exposure (**CWE-522**) by fetching access tokens dynamically from the Host OS using `System.getenv()`.

---

### 🏆 Phase 5: The Architectural Culmination [Week 9 - SchoolLibrary System]
* **Core Objective:** Generalize transactional isolation boundaries, implement fixed thread pools, and establish rich domain invariant validation.
* **Engineering Impact:** Consolidated all previous lessons into a clean framework. Reused the Semana 8 stream-caching strategies but offloaded execution loops to a dedicated two-thread fixed pool (`AppThreadPool`), returning completion tokens to the UI via thread-safe EDT channels (`SwingUtilities.invokeLater()`). Centralized multi-table transaction lifecycles into a reusable **Functional Command Wrapper** inside `DatabaseConnection.java`, allowing DAOs to pass type-safe closures. Enforced arithmetic identity validation via a strict **Modulo 11 check digit sequence** (`RutValidator.java`) directly inside the domain boundaries before allowing state persistence.

---

## 🔒 Defensive Engineering & Security-by-Design (Academic Baseline)

Even within academic boundaries, software safety and runtime code robustness were treated as first-class citizens:
* **Database Injection Defense:** Every relational operation relies on `PreparedStatement` parameters, neutralizing SQL injection vectors by ensuring inputs are treated strictly as data literals rather than executable query fragments.
* **Vulnerability Shielding:** Mitigated **Technical Information Disclosure (CWE-209)** across multi-threaded operations by implementing global framework boundaries that mask internal raw database error traces before visual layout presentation.

---

## ⚠️ Audited Technical Debt & Post-Mortem Analysis (Self-Auditing)

True technical maturity requires acknowledging where architectures break or experience regression:

1. **Synchronized Logging and Completion Coordination:** In Weeks 6 and 7, the concurrent execution layer implemented targeted, short, instance-level monitors (`synchronized` blocks) exclusively to serialize log dispatching to the `LogListener`. Task and payload extraction remained concurrent through the underlying lock-free `BlockingQueue`, ensuring these specific monitors never created a core processing bottleneck.
2. **Compute-Memory Trade-offs:** The in-memory stream pipelines inside reporting controllers (Weeks 8 & 9) successfully reduce database engine roundtrip overhead, at the deliberate architectural cost of loading complete result sets into the JVM heap.
3. **Relational Synchronization Bottlenecks (Week 7 Regression):** Shifting requirements in Week 7 forced a rapid migration from lock-free task queues to active relational verification. This temporarily introduced instance-level monitors that enclosed JDBC network reads inside `retirarPedidoPorRepartidor()`, creating single-lane bottlenecks that were subsequently resolved in later refactoring tracks.

> 💡 *The Evolutionary Bridge:* Systematically identifying these precise constraints—specifically the need for a generalized non-blocking asynchronous pooling infrastructure, secret externalization, and reusable functional transactional commands—directly drove the clean-architecture design and strict isolation layers implemented in the final project.

---
⚙ *Developed utilizing Java OpenJDK 25, Apache Maven, MySQL Server, Swing GUI bindings, and Host OS Environment Configurations.*
