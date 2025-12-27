# Java 16 Records - Access Methods

### What you'll learn
- Auto-generated public accessor methods
- Naming convention differences from traditional getters
- No setter methods
- Overriding accessor methods

---

## Accessor Methods (Getters)

### Automatic Accessor Method Generation

For every record component, Java automatically generates a **public accessor method**.
```java
public record User(String name, int age) { }

// Automatically generates:
public String name() { return name; }
public int age() { return age; }
```

### Important Naming Convention Difference

**Traditional getter naming:**
```java
public String getName() { }  // Traditional style
public int getAge() { }
```

**Record accessor naming:**
```java
public String name() { }     // Record style - same as field name!
public int age() { }
```

**Key Difference:**
- Records do NOT use the `get` prefix
- Method names are **exactly the same** as the record component names
- This is a deliberate design choice for records

### Using Accessor Methods
```java
public record User(String name, int age) { }

User user = new User("John", 25);

// Calling accessor methods
String name = user.name();   // NOT user.getName()
int age = user.age();        // NOT user.getAge()
```

### No Setter Methods

**Records do NOT generate setter methods.**
```java
public record User(String name, int age) { }

User user = new User("John", 25);

// ❌ No setter methods available
// user.setName("Jane");   // Does not exist!
// user.setAge(30);        // Does not exist!
```

This enforces immutability - once a record is created, its values cannot be changed.

### Overriding Accessor Methods

You can override the accessor methods to add custom logic if needed.
```java
public record User(String name, int age) {
    // Override the age accessor method
    @Override
    public int age() {
        // Custom logic - e.g., validation or transformation
        return age < 0 ? 0 : age;
    }
}
```

**Use cases for overriding:**
- Add validation
- Format the return value
- Add logging
- Perform calculations

### Adding Additional Methods

You can add more custom methods to records as needed.
```java
public record User(String name, int age) {
    // Additional custom method
    public boolean isAdult() {
        return age >= 18;
    }
    
    public String getFormattedName() {
        return name.toUpperCase();
    }
}

// Usage
User user = new User("John", 25);
boolean adult = user.isAdult();  // true
String formatted = user.getFormattedName();  // "JOHN"
```

Nobody stops you from adding extra methods - records are flexible in this regard.

### Summary of Accessor Methods

| Feature | Details |
|---------|---------|
| Auto-generated | ✅ Yes, for all record components |
| Naming convention | Same as component name (no `get` prefix) |
| Access modifier | public |
| Setter methods | ❌ Not generated (maintains immutability) |
| Can override | ✅ Yes, custom logic allowed |
| Additional methods | ✅ Yes, can add freely |

---

**Next Topic:** Standard Methods (equals, hashCode, toString) - Ready when you are!