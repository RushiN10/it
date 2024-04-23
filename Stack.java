package StackQueuee;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack with a maximum size
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow. Cannot push element onto a full stack.");
            return;
        }
        top++;
        stackArray[top] = value;
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = stackArray[top];
        top--;
        return value;
    }

    // Method to peek the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        Stack stack = new Stack(size); // Creating a stack with the user-defined maximum size

        System.out.println("Enter elements to push onto the stack (enter -1 to stop):");
        int data;
        while (true) {
            data = scanner.nextInt();
            if (data == -1) {
                break;
            }
            stack.push(data);
        }

        // Pop and print all elements from the stack
        System.out.println("Elements popped from the stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        scanner.close();
    }
}

