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

public class SinglyLinkedList {
    private Node head;

    // Constructor to initialize an empty linked list
    public SinglyLinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Method to delete a node at a specific position in the linked list
    public void deleteAtPosition(int position) {
        if (head == null)
            return;

        Node temp = head;

        // If position is 0, then delete the head node
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find the node at the position-1
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of the node to be deleted
        Node next = temp.next.next;

        // Unlink the deleted node from the linked list
        temp.next = next;
    }

    // Method to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.print("Enter the number of elements you want to add: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insertAtEnd(data);
        }

        System.out.print("Linked list after adding elements: ");
        list.printList();

        System.out.print("Enter the position of the node you want to delete: ");
        int position = scanner.nextInt();
        list.deleteAtPosition(position);

        System.out.print("Linked list after deleting node at position " + position + ": ");
        list.printList();

        scanner.close();
    }
}
