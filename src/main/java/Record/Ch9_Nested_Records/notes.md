# Java 16 Records - Nested Records

### What you'll learn
- Similarities with nested classes
- Key difference: Only static nested records allowed
- Why non-static nested records are not permitted
- Accessing nested records

---

## Nested Records

### What are Nested Records?

Nested records are records defined inside another record or class, similar to nested classes in Java.
```java
public record User(String name, int age) {
    // This is a nested record
    record Address(String city, String country) { }
}
```

### Similarity with Nested Classes

Nested records behave very similarly to nested classes, with **one important difference**.

**Nested Classes (Review):**
- Can be static or non-static
- Can have access modifiers: private, protected, public
- Different rules for accessing outer class members

**Nested Records:**
- Follow similar access modifier rules as nested classes
- Can be private, protected, or public
- **KEY DIFFERENCE: Can ONLY be static** (no non-static nested records)

### Access Modifiers for Nested Records

Like nested classes, nested records can have different access modifiers:
```java
public record User(String name, int age) {
    // Private nested record
    private record Address(String city) { }
    
    // Protected nested record
    protected record Contact(String email) { }
    
    // Public nested record
    public record Job(String title) { }
}
```

Access modifier rules are the same as for nested classes - no special differences.

### Static-Only Nested Records

**CRITICAL RULE: Nested records can ONLY be static.**

There is **no concept of non-static nested records**.
```java
public record User(String name, int age) {
    // ✅ This is valid (static by default)
    record Address(String city, String country) { }
    
    // ✅ Explicitly declaring static is also valid (but redundant)
    static record Contact(String email) { }
}
```

### Implicit Static Nature

**By default, nested records are static even if you don't write the `static` keyword.**
```java
public record User(String name, int age) {
    // No 'static' keyword written, but it's static by default!
    record Address(String city) { }
}
```

This is different from nested classes, where:
- No keyword = non-static (inner class)
- Must explicitly write `static` for static nested class

But for nested records:
- No keyword = static (by default)
- Writing `static` is optional/redundant

### Accessing Nested Records

Access nested records the same way you access static nested classes - through the outer class name.
```java
public record User(String name, int age) {
    record Address(String city, String country) {
        public void display() {
            System.out.println(city + ", " + country);
        }
    }
}

// Creating instance of nested record
User.Address address = new User.Address("Mumbai", "India");
address.display();
```

**Syntax:** `OuterRecord.NestedRecord`

Since nested records are static, they belong to the outer class/record, not to instances.

### Complete Example with Different Nested Types
```java
public record User(String name, int age) {
    
    // 1. Nested record (static by default)
    record Address(String city) {
        public void display() {
            System.out.println("City: " + city);
        }
    }
    
    // 2. Static nested class (explicitly static)
    static class AddressStaticClass {
        public void display() {
            System.out.println("Static class");
        }
    }
    
    // 3. Non-static nested class (inner class)
    class AddressInnerClass {
        public void display() {
            System.out.println("Inner class");
        }
    }
}
```

### Creating Instances of Each Type
```java
// 1. Nested record (static) - access via class name
User.Address address = new User.Address("Mumbai");
address.display();

// 2. Static nested class - access via class name
User.AddressStaticClass staticClass = new User.AddressStaticClass();
staticClass.display();

// 3. Non-static nested class (inner class) - needs outer instance
User userObject = new User("John", 25);
User.AddressInnerClass innerClass = userObject.new AddressInnerClass();
innerClass.display();
```

### Key Differences in Access Pattern

| Type | How to Create Instance | Needs Outer Instance? |
|------|----------------------|---------------------|
| Nested Record (static) | `User.Address address = new User.Address(...)` | ❌ No |
| Static Nested Class | `User.AddressStaticClass obj = new User.AddressStaticClass()` | ❌ No |
| Inner Class (non-static) | `User user = new User(...);`<br>`User.AddressInnerClass obj = user.new AddressInnerClass()` | ✅ Yes |

### Why Only Static Nested Records?

The instructor shares his perspective on why non-static nested records are not allowed:

**The Transparent Data Carrier Principle:**

Records are "transparent data carriers" - you should be able to see all the data they carry just by looking at the record components.
```java
public record User(String a) {
    // Hypothetically, if this were non-static (it's not allowed!)
    record Address(String b) { }
}
```

**Problem with non-static (hypothetical scenario):**

If `Address` were non-static:
1. It would be able to access instance fields of the parent record (`String a`)
2. To access parent instance fields, it needs a reference to the parent object
3. This means `Address` would internally store a reference to `User`
4. But this reference is NOT visible in the record components of `Address`
```java
// What Address would look like internally if non-static:
record Address(String b) {
    // Hidden reference to User (not in record components!)
    private final User parentReference;  
}
```

**This violates transparency:**
- Looking at `Address(String b)`, you'd think it only carries `String b`
- But internally it also carries a `User` reference
- This hidden data contradicts the transparent data carrier principle

**With static nested records:**
```java
public record User(String a) {
    // Static nested record
    static record Address(String b) { }
}
```

- `Address` belongs to the class, not instances
- It cannot access instance variables of `User`
- It doesn't need a reference to `User` object
- It truly only carries what's declared: `String b`
- **Transparency is maintained!**

### Static Fields Access

Static nested records CAN access static fields of the parent record (not instance fields).
```java
public record User(String name, int age) {
    static String companyName = "TechCorp";
    
    static record Address(String city) {
        public void display() {
            // ✅ Can access static field
            System.out.println("Company: " + companyName);
            
            // ❌ Cannot access instance fields (name, age)
            // System.out.println(name);  // Compilation error!
        }
    }
}
```

### Summary of Nested Records

| Feature | Details |
|---------|---------|
| Access modifiers | private, protected, public (same as nested classes) |
| Static by default | ✅ Yes (even without `static` keyword) |
| Non-static allowed | ❌ No (not permitted) |
| Access parent instance fields | ❌ No (because they're static) |
| Access parent static fields | ✅ Yes |
| Reason for static-only | Maintains transparent data carrier principle |

---

**Next Topic:** Local Records - Ready when you are!