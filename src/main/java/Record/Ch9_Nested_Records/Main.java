package Record.Ch9_Nested_Records;

public class Main {

    public static void main(String[] args) {
        // accessing static nested record
        User.NestedAddressRecord addressRecordObj = new User.NestedAddressRecord();
        addressRecordObj.display();

        // accessing static nested class
        User.NestedAddressStaticClass nestedAddressStaticClassObj = new User.NestedAddressStaticClass();
        nestedAddressStaticClassObj.display();

        // accessing non-static class
        User userObj = new User("myName", 26);
        User.NestedAddressNonStaticClass nestedAddressNonStaticClassObj = userObj.new NestedAddressNonStaticClass();
        nestedAddressNonStaticClassObj.display();
    }
}
