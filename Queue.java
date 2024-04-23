package StackQueuee;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1; // or throw an exception
        }
        int dequeuedValue = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Queue is now empty
        }
        return dequeuedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1; // or throw an exception
        }
        return front.data;
    }

    public boolean isEmpty() {
        return (front == null && rear == null);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek()); // Should print 10

        System.out.println("Dequeue: " + queue.dequeue()); // Should print 10
        System.out.println("Dequeue: " + queue.dequeue()); // Should print 20

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Peek: " + queue.peek()); // Should print 30
    }
}
