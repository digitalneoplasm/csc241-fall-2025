package ds;

public class BST<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public BST() {
        size = 0;
    }

    /*
    Insert:
    Base cases
    ----------
    1) currentNode's data is equal to the data being inserted.
    ---> Don't do anything. Return the current node.
    2) currentNode is null. (We walked off the end of the tree)
    ---> Create a new node where currentNode should be. Return
         the new node.
    Recursive cases
    ---------------
    1) currentNode's data is greater than data being inserted.
    ---> Go left.
    2) currentNode's data is less than data being inserted.
    ---> Go right.
     */

    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> currentNode, E data) {
        // Base case 2: currentNode is null.
        if (currentNode == null) {
            size++;
            return new Node<>(data);
        }

        // Base case 1: currentNode.data equals data
        if (currentNode.data.equals(data)) {
            return currentNode;
        }

        // data < currentNode
        if (data.compareTo(currentNode.data) < 0) {
            currentNode.left = insert(currentNode.left, data);
            return currentNode;
        }

        // data > currentNode
        currentNode.right = insert(currentNode.right, data);
        return currentNode;
    }

    public String toString() {
        return root.toString();
    }

    private static class Node<E extends Comparable<E>> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
        }

        public String toString() {
            String result = "";
            // Left things are < data.
            if (left != null) {
                result += left.toString();
            }
            // Data is next.
            result += data + " ";
            // Right things are > data
            if (right != null) {
                result += right.toString();
            }
            return result;
        }
    }
}
