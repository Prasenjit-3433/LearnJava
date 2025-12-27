# Java 16 Records - Local Records

### What you'll learn
- Creating records within blocks (methods, if-blocks, etc.)
- Access modifier restrictions
- Scope limitations
- Why static local records don't exist

---
## Local Records

### What are Local Records?

Local records are records defined **within a block** such as:
- Method blocks
- if-condition blocks
- while-loop blocks
- Any other code block
```java
public void someMethod() {
    // This is a local record - defined inside a method
    record Address(String city, String country) { }
}
```

### Similarity with Local Classes

Local records are very similar to local classes. If you understand local classes, local records follow the same principles.

**Prerequisite:** Understanding of local classes is recommended before studying local records.

### Access Modifier Restrictions

**Local records CANNOT have access modifiers** (public, private, protected).
```java
public void someMethod() {
    // ❌ NOT ALLOWED
    public record Address(String city) { }
    private record Address(String city) { }
    protected record Address(String city) { }
    
    // ✅ CORRECT - No access modifier
    record Address(String city) { }
}
```

### Why No Access Modifiers?

The scope of a local record is **limited to the block** in which it's defined.
```java
public void someMethod() {
    record Address(String city) { }
    // Scope ends here when method ends
}
```

Since it's only accessible within that block:
- There's no point in making it public, private, or protected
- These modifiers would be meaningless
- The scope is inherently restricted to the block

### Scope Limitation

**Local records cannot be accessed outside of the block** where they are defined.
```java
public class User {
    public void methodA() {
        record Address(String city) { }
        // Address can only be used within methodA
    }
    
    public void methodB() {
        // ❌ Cannot access Address here
        // Address addr = new Address("Mumbai");  // Compilation error!
    }
}
```

### Object Creation Scope

**Local records can only be instantiated within the same block** where they are defined.
```java
public void printAddress() {
    // Define local record
    record Address(String city, String country) { }
    
    // ✅ Create instance within same block
    Address address = new Address("Mumbai", "India");
    System.out.println(address);
    
} // After this block, Address cannot be used
```

You cannot create objects of the local record outside its defining block.

### No Static Local Records

**There is NO concept of static local records.**
```java
public void someMethod() {
    // ❌ NOT ALLOWED
    static record Address(String city) { }
}
```

### Why No Static Local Records?

**Understanding `static`:**
- `static` means something belongs to a **class**
- Static members are class-level, not instance-level

**Why it doesn't make sense for local records:**
- Local records are scoped to a **block**, not a class
- Once the block execution finishes, the local record's scope ends
- It doesn't belong to the class; it belongs to the block's execution context
- Making it static would be contradictory to its local nature
```java
public void someMethod() {
    record Address(String city) { }
    // When this method ends, Address is gone
    // It never "belonged" to the class
}
```

Static implies class-level accessibility, but local records are block-level by design.

### Complete Example: Local Record in a Method
```java
public record User(String name, int age) {
    
    public void printAddress() {
        // Define local record within method
        record Address(String city, String country) {
            public void display() {
                System.out.println(city + ", " + country);
            }
        }
        
        // Create instance within the same method
        Address address = new Address("Mumbai", "India");
        address.display();
        
        // Can create multiple instances
        Address address2 = new Address("Delhi", "India");
        address2.display();
    }
}

// Usage from outside
User user = new User("John", 25);
user.printAddress();  // This executes the method containing local record
```

### How to Use Local Records
```java
public class Example {
    public static void main(String[] args) {
        User user = new User("John", 25);
        user.printAddress();
    }
}

public record User(String name, int age) {
    
    public void printAddress() {
        // Local record definition
        record Address(String city, String country) {
            public void display() {
                System.out.println("Address: " + city + ", " + country);
            }
        }
        
        // Creating and using local record
        Address addr = new Address("Kolkata", "India");
        addr.display();
    }
}
```

**Execution flow:**
1. Create `User` object outside
2. Call `printAddress()` method
3. Inside method, local record `Address` is defined
4. Create instance of `Address` within the method
5. Use the instance
6. Method ends, `Address` scope ends

### Comparison: Local Records vs Local Classes

| Feature | Local Records | Local Classes |
|---------|--------------|---------------|
| Defined in blocks | ✅ Yes | ✅ Yes |
| Access modifiers | ❌ Not allowed | ❌ Not allowed |
| Scope | Limited to block | Limited to block |
| Can be static | ❌ No | ❌ No |
| Instantiation | Within block only | Within block only |
| Reason for restrictions | Block-scoped, not class-scoped | Block-scoped, not class-scoped |

### Key Principles Summary

1. **Scope is everything**: Local records exist only within their defining block
2. **No access modifiers**: Meaningless due to limited scope
3. **No static**: Static implies class-level; local records are block-level
4. **Instantiation restriction**: Can only create objects within the same block
5. **Similar to local classes**: Follow the same rules and principles

### Important Note

The instructor emphasizes:
- If you understand local classes, local records are straightforward
- The concepts are parallel between local classes and local records
- Review the nested classes and local classes topics if you face difficulty understanding this section

---

**Next Topic:** Records vs Lombok - Final Comparison - Ready when you are!