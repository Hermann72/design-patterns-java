# Design Patterns in Java

A practical reference project covering the 15 classic **Gang of Four (GoF)** design patterns implemented in **Java 17** with **Gradle**, using a cohesive enterprise reporting system domain throughout.

---

## Tech Stack

- **Java 17** (LTS)
- **Gradle** (build tool)
- **IntelliJ IDEA** (Community Edition)

---

## Project Structure

```
src/main/java/com/hero/patterns/
├── creational/
│   ├── singleton/
│   ├── factory/
│   ├── abstractfactory/
│   ├── builder/
│   └── prototype/
├── structural/
│   ├── adapter/
│   ├── decorator/
│   ├── facade/
│   ├── composite/
│   └── proxy/
└── behavioral/
    ├── strategy/
    ├── observer/
    ├── command/
    ├── templatemethod/
    └── chainofresponsibility/
```

---

## Patterns Covered

### Creational Patterns
These patterns deal with object creation mechanisms.

| Pattern | Intent | Key Concept |
|---|---|---|
| **Singleton** | Ensures a class has only one instance | Double-Checked Locking + `volatile` |
| **Factory Method** | Delegates object creation to subclasses | Open/Closed Principle |
| **Abstract Factory** | Creates families of related objects | Dependency Injection |
| **Builder** | Constructs complex objects step by step | Immutability + nested static class |
| **Prototype** | Clones existing objects | Shallow vs Deep Copy |

### Structural Patterns
These patterns deal with how classes and objects are composed.

| Pattern | Intent | Key Concept |
|---|---|---|
| **Adapter** | Makes incompatible interfaces work together | Composition over inheritance |
| **Decorator** | Adds responsibilities to objects dynamically | Avoids class explosion |
| **Facade** | Provides a simplified interface to a subsystem | Orchestration, API Gateway |
| **Composite** | Treats individual objects and compositions uniformly | Recursion by polymorphism |
| **Proxy** | Controls access to an object | Cache, lazy loading, Spring AOP |

### Behavioral Patterns
These patterns deal with communication between objects.

| Pattern | Intent | Key Concept |
|---|---|---|
| **Strategy** | Defines a family of interchangeable algorithms | Open/Closed Principle |
| **Observer** | Notifies dependents of state changes | Decoupled subscriptions |
| **Command** | Encapsulates actions as objects | Undo/redo, command history |
| **Template Method** | Defines the skeleton of an algorithm | Fixed skeleton, variable steps |
| **Chain of Responsibility** | Passes requests along a chain of handlers | Decoupled request handling |

---

## Domain

All patterns are implemented within a cohesive **enterprise reporting system** domain, making examples realistic and relatable to backend development:

- `ConfigurationManager` — Singleton
- `ReportFactory` — Factory Method (PDF, Excel, CSV)
- `DatabaseFactory` — Abstract Factory (MySQL, PostgreSQL)
- `Report.Builder` — Builder
- `DocumentTemplate` — Prototype
- `LegacyReportSystem` — Adapter
- `LoggingDecorator`, `EncryptionDecorator`, `CompressionDecorator` — Decorator
- `ReportFacade` — Facade (Auth, Data, Formatter, Email, Audit)
- `ReportFolder` / `ReportLeaf` — Composite
- `CacheReportProxy` — Proxy
- `SortStrategy` — Strategy (by name, date, amount, region)
- `ReportEventManager` — Observer
- `ReportCommandInvoker` — Command (create, export, delete + undo)
- `ReportTemplate` — Template Method (Sales, HR)
- `ReportHandler` chain — Chain of Responsibility (PUBLIC → INTERNAL → CONFIDENTIAL → TOP_SECRET)

---

## How to Run

### Clone the repository
```bash
git clone https://github.com/Hermann72/design-patterns-java.git
cd design-patterns-java
```

### Run with Gradle
```bash
./gradlew run        # Linux / macOS
gradlew.bat run      # Windows
```

### Run from IntelliJ IDEA
Open the project, navigate to `com.hero.patterns.creational.Main` and run it directly.

---

## SOLID Principles Applied

This project consistently demonstrates the following principles:

- **S** — Single Responsibility: each class has one clear purpose
- **O** — Open/Closed: new behavior added without modifying existing code (Factory, Strategy, Observer, Chain)
- **L** — Liskov Substitution: subclasses are interchangeable with their base types
- **I** — Interface Segregation: small, focused interfaces throughout
- **D** — Dependency Inversion: always programming to interfaces, not implementations

---

## Connection to Spring Framework

Understanding these patterns provides insight into how Spring works internally:

| Pattern | Spring equivalent |
|---|---|
| Singleton | `@Bean` (default scope) |
| Factory Method | `BeanFactory`, `ApplicationContext` |
| Abstract Factory | `@Configuration` + `@Bean` |
| Proxy | `@Transactional`, `@Cacheable`, Spring AOP |
| Observer | `@EventListener`, `ApplicationEventPublisher` |
| Template Method | `JdbcTemplate`, `RestTemplate` |
| Decorator | Spring Security filter chain |
| Facade | `@Service` orchestrating repositories |
| Chain of Responsibility | Spring Security filter chain |

---

## Author

Backend developer with 25+ years of experience in Java and enterprise software development.  
This project was built as a personal knowledge refresh and portfolio reference.

---

## References

- *Design Patterns: Elements of Reusable Object-Oriented Software* — Gang of Four (GoF)
- [Refactoring Guru — Design Patterns](https://refactoring.guru/design-patterns)
- [Java 17 Documentation](https://docs.oracle.com/en/java/javase/17/)
