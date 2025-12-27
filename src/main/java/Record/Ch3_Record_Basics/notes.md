# Java 16 Records - Records Basics

### What you'll learn
- Syntax and structure
- What gets generated automatically
- How to create and use records

---
## 3. Records Basics

### What are Records?

Records help create immutable classes in a short and concise way. They are designed specifically to reduce boilerplate code for data carrying classes like POJOs.

### When to Use Records

Records are ideal for:
- Very simple, immutable classes only
- Data carrying classes (POJOs)
- Classes that primarily hold data without complex behavior

### Record Syntax
```java
record RecordName(field1, field2, field3, ...) {
    // optional: additional methods or custom logic
}
```

**Key components:**
- `record` - The keyword
- `RecordName` - Name of your record
- `(field1, field2, ...)` - All fields, comma-separated
- `{ }` - Curly braces (can be empty or contain additional methods)

### Example: User Record

**Traditional class (from earlier):**
```java
public final class User {
    private final String name;
    private final int age;
    // constructor, getters, equals, hashCode, toString...
}
```

**Using Records:**
```java
public record User(String name, int age) {
}
```

That's it! Just this single line replaces all the boilerplate code.

### What Gets Generated Automatically

When you create a record, Java automatically generates:

1. **Constructor** - Takes all fields as parameters
2. **Getter methods** - For each field
3. **equals() method**
4. **hashCode() method**
5. **toString() method**
6. **Final class** - The record is implicitly final
7. **Private final fields** - All fields become private final automatically

### Creating and Using Record Instances
```java
// Creating an object
User user = new User("John", 25);

// Using getter methods (available automatically)
String name = user.name();
int age = user.age();

// toString() method (available automatically)
System.out.println(user.toString());
```

**Note:** Even though no constructor is explicitly defined in the record, it's automatically created and accepts all fields in order (String first, then int).

### Examining the Compiled .class File

When you compile the record and examine the `.class` file, you'll see:
- The `record` keyword is preserved (not changed to `final class`)
- All getter methods are present
- Constructor is generated
- The record keyword itself is equivalent to a final class

### Key Takeaway

The `record` keyword is equivalent to declaring a `final class`, but with automatic generation of all necessary boilerplate code for immutable data carriers.

---

**Next Topic:** Record Keyword & Internal Mechanics - Ready when you are!