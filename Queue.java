package StackQueuee;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor to initialize the queue with a maximum size
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0; // Queue is initially empty
    }

    // Method to add an element to the rear of the queue (enqueue)
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element.");
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        currentSize++;
    }

    // Method to remove and return the element from the front of the queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Cannot dequeue element.");
        }
        int removedValue = queueArray[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return removedValue;
    }

    // Method to peek the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Cannot peek element.");
        }
        return queueArray[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return currentSize == 0;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return currentSize == maxSize;
    }

    // Method to display all elements currently in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        for (int count = 0; count < currentSize; count++) {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % maxSize;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();

        Queue queue = new Queue(size); // Creating a queue with the user-defined maximum size

        System.out.println("Enter elements to enqueue into the queue (enter -1 to stop):");
        int data;
        while (true) {
            data = scanner.nextInt();
            if (data == -1) {
                break;
            }
            queue.enqueue(data);
        }

        // Display all elements in the queue
        queue.display();

        // Dequeue and print all elements from the queue
        System.out.println("Elements dequeued from the queue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        scanner.close();
    }
}
