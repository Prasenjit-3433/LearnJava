package DSA.Stack.UsingLinkedList;

public class Queue {
    Node start;
    Node end;
    int size;

    public Queue() {
        this.start = null;
        this.end = null;
        this.size = 0;
    }

    public void push(int el) {
        Node newNode = new Node(el);

        if (size == 0) {
            start = newNode;
        } else {
            end.next = newNode;
        }

        end = newNode;
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        Node temp = start;

        if (size == 1) {
            start = null;
            end = null;
        } else {
            start = start.next;
            temp.next = null;
        }
        size--;
        return temp.data;
    }

    public int top() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty!");
        }

        return start.data;
    }

    public int size() {
        return size;
    }
}
