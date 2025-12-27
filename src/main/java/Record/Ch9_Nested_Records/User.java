package Record.Ch9_Nested_Records;

public record User(String name, int age) {

    public void display() {
        System.out.println("hello inside record User record");
    }

    // always static, even when not specified
    record NestedAddressRecord() {

        public void display() {
            // we can only access Static data of parent user, but can not access non-static fields like name
            System.out.println("hello inside nested static record");
        }
    }

    static class NestedAddressStaticClass {
        public void display() {
            System.out.println("hello inside nested static class");
        }
    }

    class NestedAddressNonStaticClass {
        public void display() {
            System.out.println("hello inside non-static nested class and can access parent non static fields like, name: ");
        }
    }
}
