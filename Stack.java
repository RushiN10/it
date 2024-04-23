package StackQueuee;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1; // or throw an exception
        }
        int poppedValue = top.data;
        top = top.next;
        return poppedValue;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek element.");
            return -1; // or throw an exception
        }
        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter elements to push onto the stack (enter -1 to stop):");

        int userInput;
        while ((userInput = scanner.nextInt()) != -1) {
            stack.push(userInput);
        }

        System.out.println("Elements in the stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        scanner.close();
    }
}
