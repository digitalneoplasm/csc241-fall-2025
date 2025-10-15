/**
 * Goal: Implement a linked data structure.
 * - To start, we'll have it hold strings. Later, use generic types.
 *
 * Two classes:
 * - SinglyLinkedList - manage the state of the list. The user sees this.
 * - Node - a single data / next object. Hidden from the user.
 *
 * SinglyLinkedList
 * ----------------
 * State:
 * - Head of the list.
 * - Size of the list.
 *
 * Constructor:
 * - null head, size is 0.
 *
 * Functionality:
 * - public String get(int i) - Return element at index i
 * - public void addFirst(String s) - Add a string at the beginning of the list
 * - public int size() - Return size of the list
 * - public String toString() - Return a string representation of the list
 *
 * Node
 * ----
 * State:
 * - Next node
 * - String for data
 *
 * Constructor:
 * - next node, current node data.
 *
 */


package ds;

public class SinglyLinkedList {
    private Node head;
    private int size = 0;

    public SinglyLinkedList() {
        // No need for setting fields.
    }

    public void addFirst(String s) {
        // Two cases:
        // 1) Our list is empty.
        // Initial state: head -> null
        // New state: head -> [ data = s | next = null ]
//        if (size == 0) {
//            Node newNode = new Node(s, head); // head is null.
//            head = newNode;
//        }
//
//        // 2) Our list is not empty.
//        // Initial state: head -> [ Node n ] -> ....
//        // New state: head -> [ data = s | next = ] -> [ Node n ]
//        else {
//            Node newNode = new Node(s, head);
//            head = newNode;
//        }
        // Right side gets evaluated
        // Then assignment happens.
        head = new Node(s, head);

        size++;

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
//        Node temp = head;
//        for (int i = 0; i < size; i++) {
//            result += temp.data + " ";
//            temp = temp.next;
//        }
        for (Node temp = head; temp != null; temp = temp.next) {
            result.append(temp.data).append(" ");
        }
        return result.toString();
    }

 // Find the elt at index i, return it's data. Remember error checking!
    public String get(int i) {
        if ( i < 0 || i >= size ) {
            throw new IndexOutOfBoundsException();
        }
        int currIndex = 0;
        Node currNode = head;
        while (currIndex < i) {
            currIndex++;
            currNode = currNode.next;
        }
        return currNode.data;
    }

    // 2 kinds of nested classes:
    // 1) static nested class - can only access static members of the outer class.
    // 2) inner class - relies on the state of the 'this' instance of the outer class.
    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
