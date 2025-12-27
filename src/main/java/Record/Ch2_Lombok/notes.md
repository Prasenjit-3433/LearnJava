# Java 16 Records - Comparison with Lombok

### What you'll learn
- How Lombok reduces boilerplate
- Limitations of Lombok approach

---
## Comparison with Lombok

### What is Lombok?

Lombok is a library that also helps reduce boilerplate code in Java classes through annotations.

### Lombok Annotations for Reducing Boilerplate
```java
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class User {
    private final String name;
    private final int age;
}
```

Or even simpler:
```java
@Value
public class User {
    String name;
    int age;
}
```

### What Each Lombok Annotation Does

- **`@Getter`** - Automatically generates getter methods
- **`@EqualsAndHashCode`** - Automatically generates equals() and hashCode() methods
- **`@AllArgsConstructor`** - Automatically generates constructor with all fields
- **`@ToString`** - Automatically generates toString() method
- **`@Value`** - Single annotation that generates an immutable class with all of the above

### The Question Arises

**"Why do we need Records in Java 16 when we already have Lombok?"**

This is a valid question since Lombok already solves the boilerplate problem. However, there are important differences that make Records preferable.

### Preview of Key Differences (Detailed Later)

The instructor mentions that the key differences will be explained after understanding how Records work:
- Native Java support vs external library dependency
- Enforcement capabilities
- Integration with other Java features

---

**Next Topic:** Records Basics - Ready when you are!