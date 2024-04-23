package Linkedlist;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;

    // Constructor to initialize an empty circular linked list
    public CircularLinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // Point to itself
            head = newNode;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            newNode.next = head;
            last.next = newNode;
            head = newNode;
        }
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode; // Point to itself
            head = newNode;
        } else {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
        }
    }

    // Method to delete a node with a given key from the linked list
    public void delete(int key) {
        if (head == null) return;

        Node current = head;
        Node prev = null;

        // If head is the node to be deleted
        if (current.data == key) {
            while (current.next != head) {
                current = current.next;
            }
            if (head == head.next) { // If only one node is present
                head = null;
            } else {
                current.next = head.next;
                head = head.next;
            }
        } else {
            while (current.next != head && current.data != key) {
                prev = current;
                current = current.next;
            }
            if (current.data == key) {
                prev.next = current.next;
            }
        }
    }

    // Method to delete a node at a specific position in the linked list
    public void deleteAtPosition(int position) {
        if (head == null) return;

        Node current = head;
        Node prev = null;
        int count = 0;

        // If position is 0, delete the head node
        if (position == 0) {
            while (current.next != head) {
                current = current.next;
            }
            if (head == head.next) { // If only one node is present
                head = null;
            } else {
                current.next = head.next;
                head = head.next;
            }
            return;
        }

        // Traverse the list until the position or the end of the list is reached
        while (count < position && current.next != head) {
            prev = current;
            current = current.next;
            count++;
        }

        // If position is greater than the number of nodes in the list
        if (count < position) {
            System.out.println("Position is out of range");
            return;
        }

        // Delete the node at the given position
        prev.next = current.next;
    }

    // Method to print the linked list
    public void printList() {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularLinkedList list = new CircularLinkedList();

        System.out.print("Enter the number of elements you want to add: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insertAtEnd(data);
        }

        System.out.print("Circular linked list after adding elements: ");
        list.printList();

        System.out.print("Enter the position of the element you want to delete: ");
        int position = scanner.nextInt();
        list.deleteAtPosition(position);

        System.out.print("Circular linked list after deleting element at position " + position + ": ");
        list.printList();

        scanner.close();
    }
}


