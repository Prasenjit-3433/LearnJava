# Java 16 Records - Constructor in Records

### What you'll learn
- Canonical constructor (auto-generated)
- Overriding canonical constructor
- Compact constructor (shorthand form)
- Custom constructors with different parameters
- Constructor access level rules
- Defensive copying considerations

---

## Constructors in Records

### Canonical Constructor (Auto-generated)

When you define a record, Java automatically generates a constructor called the **canonical constructor**.
```java
public record User(String name, int age) { }

// Internally generates this canonical constructor:
public User(String name, int age) {
    this.name = name;
    this.age = age;
}
```

**Canonical Constructor:** A constructor that takes all record components as parameters in the same order they are declared.

### Characteristics of Canonical Constructor

- Takes all record components as parameters
- Parameters are in the **same order** as defined in the record components
- Automatically initializes all fields
- Generated implicitly if not explicitly defined

### Overriding the Canonical Constructor

You can override the canonical constructor to add custom logic (like validation).
```java
public record User(String name, int age) {
    // Override canonical constructor
    public User(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }
}
```

**Note:** When overriding, you must:
- Include all record components as parameters
- Initialize all fields (this.name, this.age)
- Maintain the same order

### Compact Constructor (Shorthand Form)

Records provide a special **compact constructor** - a shorthand way to write the canonical constructor.

**Regular canonical constructor:**
```java
public record User(String name, int age) {
    public User(String name, int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.name = name;
        this.age = age;
    }
}
```

**Compact constructor (shorthand):**
```java
public record User(String name, int age) {
    public User {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        // No need to write: this.name = name; this.age = age;
        // Compiler adds initialization automatically!
    }
}
```

### Features of Compact Constructor

1. **Skip parameter list** - Don't need to write `(String name, int age)`
2. **Skip field initialization** - Don't need to write `this.name = name; this.age = age;`
3. **Just write validation/logic** - Focus only on your custom logic
4. **Compiler adds the rest** - Automatically adds parameters and initialization

**Important:** This automatic addition only works with the **compact constructor**, not with regular constructors.

### Additional Constructors with Different Parameters

You can create additional constructors with different parameter lists.
```java
public record User(String name, int age) {
    // Additional constructor with only age
    public User(int age) {
        this("Unknown", age);  // Must call canonical constructor
    }
}
```

### Restriction: Must Invoke Canonical Constructor

**Rule:** Any additional constructor MUST invoke the canonical constructor.
```java
public record User(String name, int age) {
    // ✅ CORRECT - Calls canonical constructor
    public User(int age) {
        this("Unknown", age);
    }
    
    // ❌ WRONG - Doesn't call canonical constructor
    public User(int age) {
        // Logic without calling this(...)
    }
}
```

### Why This Restriction?

This ensures that **no field is left uninitialized**. By requiring all constructors to eventually call the canonical constructor, Java guarantees all record components are properly initialized.

The canonical constructor must:
- Accept all record components
- Be called in the correct parameter order
- Initialize every field

### Constructor Access Level Rules

The access level of the canonical constructor must **_match or be more accessible_** than the record itself.

#### Rule 1: Cannot Restrict Access Level
```java
// ❌ NOT ALLOWED
public record User(String name, int age) {
    User(String name, int age) {  // Package-private constructor
        this.name = name;
        this.age = age;
    }
}
```

**Error:** Cannot restrict access. Record is public, so constructor must be public.

#### Rule 2: Can Increase Access Level
```java
// ✅ ALLOWED
record User(String name, int age) {  // Package-private record
    public User(String name, int age) {  // Public constructor
        this.name = name;
        this.age = age;
    }
}
```

Record is package-private (default), but constructor can be public (more accessible).

#### Rule 3: Same Access Level is Fine
```java
// ✅ ALLOWED
record User(String name, int age) {  // Package-private record
    User(String name, int age) {      // Package-private constructor
        this.name = name;
        this.age = age;
    }
}
```

### Summary of Access Level Rules

| Record Access | Constructor Access | Valid? |
|---------------|-------------------|--------|
| public | public | ✅ Yes |
| public | package-private | ❌ No (restricted) |
| package-private | public | ✅ Yes (expanded) |
| package-private | package-private | ✅ Yes (same) |

**General Rule:** You can increase the constructor access level, but you **cannot decrease** it below the record's access level.

### Defensive Copying for Mutable Objects

**Important Consideration:** When record components are mutable objects (like Lists), special care is needed.
```java
public record User(String name, List<String> hobbies) { }

// Internally generates:
// private final List<String> hobbies;
```

### The Problem with Mutable Fields
```java
List<String> hobbies = new ArrayList<>();
hobbies.add("Reading");

User user = new User("John", hobbies);

// ⚠️ PROBLEM: Can still modify the list!
hobbies.add("Gaming");  // This modifies the user's hobbies too!
```

**Issue:** Making the reference `final` only prevents reassignment of the reference itself, not modification of the object it points to.
```java
private final List<String> hobbies;  // Reference is immutable
// But the List object itself is still mutable!
```

### Solution: Defensive Copying

Override the canonical constructor to create an immutable copy:
```java
public record User(String name, List<String> hobbies) {
    public User(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = List.copyOf(hobbies);  // Creates immutable copy
    }
}
```

**What `List.copyOf()` does:**
- Creates an immutable copy of the list
- Any attempt to modify it throws `UnsupportedOperationException`
- Ensures true immutability of the record

### Important Understanding

Even though a field is declared `private final`, if it references a mutable object:
- The **reference** is immutable (can't point to a different object)
- The **object itself** remains mutable (contents can be changed)

Only the reference is immutable, not the actual object. This is why defensive copying is advisable for mutable types in records.

---

**Next Topic:** Accessor Methods (Getters) - Ready when you are!