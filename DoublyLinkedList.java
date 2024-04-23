package Linkedlist;



import java.util.Scanner;

public class DoublyLinkedList {
    class Node {
        int data;
        Node prev;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Constructor to initialize an empty doubly linked list
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to insert a new node at the end of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to delete a node with a given key from the linked list
    public void delete(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // Method to delete a node at a specific position in the linked list
    public void deleteAtPosition(int position) {
        if (position < 1)
            return;

        Node current = head;
        for (int i = 1; current != null && i < position; i++) {
            current = current.next;
        }

        if (current == null)
            return;

        if (current == head && current == tail) {
            head = null;
            tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
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
        DoublyLinkedList list = new DoublyLinkedList();

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



