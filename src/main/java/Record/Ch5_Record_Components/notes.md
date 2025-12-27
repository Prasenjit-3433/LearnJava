# Java 16 Records - Record Components

### What you'll learn
- Private final field generation
- Transparent data carrier concept
- Instance field restrictions
- Static fields in records

---

## 5. Record Components (Fields)

### What are Record Components?

The fields defined in parentheses beside the record name are called **record components**.
```java
public record User(String name, int age) { }
//                 ^^^^^^^^^^^^^^^^^^^
//                 These are record components
```

From now on, these fields will be referred to as **record components**.

### Automatic Field Generation

When you define record components, Java automatically generates **private final fields** for each component.
```java
public record User(String name, int age) { }

// Internally generates:
private final String name;
private final int age;
```

### Transparent Data Carrier Concept

Records are known as **"transparent data carriers"** - this means:

**Just by looking at the record definition, you can immediately know what data it carries.**
```java
public record User(String name, int age) { }
```

From this single line, it's clear that `User` carries:
- A `name` (String)
- An `age` (int)

This transparency is a core design principle of records.

### Restriction: No Additional Instance Fields

**You CANNOT add more instance fields inside the record body.**
```java
// ❌ NOT ALLOWED
public record User(String name, int age) {
    private String lastName;  // Compilation Error!
}
```

### Why This Restriction?

This restriction exists to maintain the **transparent data carrier** principle:

- If you could add hidden instance fields inside the record body, someone looking at the record definition wouldn't know all the data it carries
- All data must be declared in the record components for transparency
- This ensures you can see exactly what data the record holds just by looking at its declaration

### How to Add More Fields

If you need more fields, define them in the record components:
```java
// ✅ CORRECT WAY
public record User(String name, int age, String lastName) { }
```

### Static Fields ARE Allowed

While instance fields are not allowed, **static fields can be defined inside the record body**.
```java
// ✅ ALLOWED
public record User(String name, int age) {
    static String companyName = "TechCorp";
}
```

### Why Are Static Fields Allowed?

**Key Understanding:**

1. **Static fields belong to the class, NOT to individual objects**
2. **Instance fields belong to each object**
```java
public record User(String name, int age) {
    static String companyName;  // Belongs to User class
}

// These fields are generated as private final:
// private final String name;    // Belongs to each User object
// private final int age;         // Belongs to each User object
```

### Impact on Immutability
```java
User user1 = new User("John", 25);
User user2 = new User("Jane", 30);
```

- Each `user1` and `user2` object has its own `name` and `age` (instance fields)
- Both objects share the same `companyName` (static field - belongs to class)
- **Objects remain immutable** because static fields don't affect object state
- The static field doesn't break the immutability guarantee of individual record instances

### Key Rule Summary

The rule that "objects are immutable" remains intact because:
- Record components (instance fields) are always `private final`
- Static fields belong to the class, not instances
- Each object's state (defined by record components) cannot be changed

---

**Next Topic:** Constructors in Records - Ready when you are!