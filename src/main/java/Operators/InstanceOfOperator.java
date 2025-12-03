package Operators;

class ParentClass {

}

class ChildClass1 extends ParentClass {

}

class ChildClass2 extends ParentClass {

}

public class InstanceOfOperator {
    public static void main(String[] args) {

        ParentClass obj = new ChildClass2();
        System.out.println(obj instanceof ChildClass2);
        System.out.println(obj instanceof ChildClass1);

        ChildClass1 childObj = new ChildClass1();
        System.out.println(childObj instanceof ParentClass);

        String val = "hello";
        System.out.println(val instanceof String);
    }
}
