# Java 16 Records - The problem statement

### What you'll learn
 - Traditional approach to creating immutable classes
 - Amount of boilerplate code required

---

## Introduction & The Problem Statement

### The Challenge with Traditional Immutable Classes

When creating a simple immutable data carrier class (POJO), we need to write a significant amount of boilerplate code.

### Traditional Approach - Example: User Class
```java
public final class User {
    private final String name;
    private final int age;
    
    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Getter methods only (no setters)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // equals() method
    @Override
    public boolean equals(Object o) {
        // implementation
    }
    
    // hashCode() method
    @Override
    public int hashCode() {
        // implementation
    }
    
    // toString() method
    @Override
    public String toString() {
        // implementation
    }
}
```

### Requirements for a Basic Immutable Class

1. **Make the class `final`** - Prevents subclassing
2. **Declare all fields as `private final`** - Ensures immutability
3. **Initialize fields through constructor** - No separate setter methods
4. **Provide only getter methods** - No setters to maintain immutability
5. **Implement equals(), hashCode(), and toString()** - Often required because:
    - Objects need to be passed around
    - Objects are stored in collections like Maps
    - Comparison and representation needs

### Creating an Instance
```java
User user = new User("John", 25);
String name = user.getName();
```

Since there are no setter methods, all member variables must be initialized at construction time.

### The Core Problem

**Observation:** There is a lot of boilerplate code just for a basic immutable POJO class.

**Solution:** This is where Java 16 Records come into the picture - they help generate much of this code automatically.

---

**Next Topic:** Comparison with Lombok - Ready when you are!