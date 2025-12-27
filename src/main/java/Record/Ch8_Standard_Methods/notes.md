# Java 16 Records - Standard Methods

### What you'll learn
- Auto-generated equals(), hashCode(), and toString()
- Overriding these methods

---

## Standard Methods (equals, hashCode, toString)

### Automatic Generation of Standard Methods

Records automatically generate three important standard methods:

1. **equals()**
2. **hashCode()**
3. **toString()**
```java
public record User(String name, int age) { }

// Automatically generates:
// - public boolean equals(Object obj)
// - public int hashCode()
// - public String toString()
```

### Why These Methods are Important

These methods are commonly needed because:
- Objects are passed around in applications
- Objects are stored in collections (Maps, Sets)
- Objects need to be compared for equality
- Objects need string representation for debugging/logging

### Using Auto-generated Methods
```java
public record User(String name, int age) { }

User user1 = new User("John", 25);
User user2 = new User("John", 25);
User user3 = new User("Jane", 30);

// equals() method
user1.equals(user2);  // true (same values)
user1.equals(user3);  // false (different values)

// hashCode() method
int hash = user1.hashCode();

// toString() method
System.out.println(user1.toString());
// Output: User[name=John, age=25]
```

### Overriding Standard Methods

You can override these methods to provide custom implementations if needed.
```java
public record User(String name, int age) {
    
    @Override
    public boolean equals(Object obj) {
        // Custom equality logic
        if (this == obj) return true;
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        // Custom comparison logic here
        return this.name.equalsIgnoreCase(other.name) && this.age == other.age;
    }
    
    @Override
    public int hashCode() {
        // Custom hashCode logic
        return Objects.hash(name.toLowerCase(), age);
    }
    
    @Override
    public String toString() {
        // Custom toString logic
        return "User{name='" + name + "', age=" + age + "}";
    }
}
```

### When to Override

Common scenarios for overriding:
- **equals()**: Custom comparison logic (e.g., case-insensitive string comparison)
- **hashCode()**: Must override when equals() is overridden to maintain contract
- **toString()**: Custom formatting for better readability or specific output format

### Benefits of Auto-generation

- Saves time and reduces boilerplate
- Implements best practices by default
- Consistent behavior across all records
- Less prone to errors compared to manual implementation

### Summary

| Method | Auto-generated? | Can Override? | Purpose |
|--------|----------------|---------------|---------|
| equals() | ✅ Yes | ✅ Yes | Compare object equality |
| hashCode() | ✅ Yes | ✅ Yes | Generate hash for collections |
| toString() | ✅ Yes | ✅ Yes | String representation |

---

**Next Topic:** Nested Records - Ready when you are!