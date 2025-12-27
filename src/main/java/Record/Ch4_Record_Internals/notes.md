# Java 16 Records - Records Internals

### What you'll learn
- Record keyword vs final class
- Implicit extension of java.lang.Record
- Why records can't extend other classes

---

## 4. Record Keyword & Internal Mechanics

### Record Keyword Equivalence

The `record` keyword is equivalent to a `final class`. When you use `record`, you're essentially creating a final class with automatic code generation.
```java
public record User(String name, int age) { }

// Is conceptually equivalent to:
public final class User {
    // ... with all the boilerplate
}
```

### Access Modifiers for Records

Records follow the same access modifier rules as normal classes:

- **`public record`** - Publicly accessible
- **Package-private record** (no modifier) - Accessible within the package only

**Example:**
```java
public record User(String name, int age) { }  // Public access

record User(String name, int age) { }         // Package-private access
```

There is no special difference in access modifier rules for records compared to regular classes.

### Implicit Extension of java.lang.Record

**All records implicitly extend `java.lang.Record` class.**
```java
public record User(String name, int age) { }

// Internally extends:
// java.lang.Record
```

### Why This Implicit Extension?

The Java framework needs to identify whether a class is a record or a normal class. It does this by checking the superclass:
```java
// Framework checks:
if (user.getClass().getSuperclass() == Record.class) {
    // Apply record-specific rules and logic
}
```

When the superclass equals `java.lang.Record`, the framework knows it's a record and applies all record-specific rules.

### Limitation: Cannot Extend Other Classes

**Records cannot extend another class using `extends` keyword.**
```java
// ❌ NOT ALLOWED
public record User(String name, int age) extends MyService {
}
```

**Error:** `extends` is not allowed on records.

### Why Can't Records Extend Other Classes?

Java does not support multiple inheritance. Since records already implicitly extend `java.lang.Record`, they cannot extend another class.

**Rule:** You cannot extend from more than one class in Java.

### Records CAN Implement Interfaces

While records cannot extend classes, they **can implement multiple interfaces**.
```java
// ✅ ALLOWED
public record User(String name, int age) implements Serializable, Comparable<User> {
    // Provide interface method implementations
    @Override
    public int compareTo(User other) {
        // implementation
    }
}
```

You can:
- Implement as many interfaces as needed
- Provide implementations for interface methods just like in normal classes

### Summary of Inheritance Rules

| Feature | Allowed? | Reason |
|---------|----------|--------|
| Extend another class | ❌ No | Already extends java.lang.Record |
| Extend multiple classes | ❌ No | Java doesn't support multiple inheritance |
| Implement interfaces | ✅ Yes | Multiple interface implementation is allowed |
| Implement multiple interfaces | ✅ Yes | No restriction on interface count |

---

**Next Topic:** Record Components (Fields) - Ready when you are!