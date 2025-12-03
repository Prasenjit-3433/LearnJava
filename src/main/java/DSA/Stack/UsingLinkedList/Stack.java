package DSA.Stack.UsingLinkedList;

public class Stack {
    Node top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int el) {
        Node newNode = new Node(el);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (size == 0) {
            System.out.println("Stack is empty!");
            throw new RuntimeException();
        }

        Node temp = top;
        top = top.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    public int top() {
        if (size == 0) {
            System.out.println("Stack is empty!");
            throw new RuntimeException();
        }

        return top.data;
    }

    public int size() {
        return size;
    }
}
