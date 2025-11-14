package ds;

public class BST<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    /**
     * Create a new, empty, BST.
     */
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

    /**
     * Inserts data into the BST, maintaining the BST property.
     * @param data the data to insert.
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

    /**
     * Find target in the BST. If target is found, return true. Otherwise, return false.
     * @param target The item to find in the BST
     * @return true if target is present, false otherwise.
     */
    public boolean find(E target) {
        return find (root, target);
    }

    private boolean find(Node<E> currentNode, E target) {
        // Base case 1: currentNode is null
        if (currentNode == null) {
            return false;
        }

        // Base case 2: target is equal to currentNode's data.
        if (currentNode.data.equals(target)) {
            return true;
        }
        // Recursive cases:
        // target < currentNode's data - repeat find process on left subtree.
        if (target.compareTo(currentNode.data) < 0) {
            return find(currentNode.left, target);
        }

        // target > currentNode's data - repeat find process on right subtree.
        return find(currentNode.right, target);
    }

    public String toString() {
        return root.toString();
    }

    /*
        Remove Method (you implement!)
    1) if the node is null,
        The item is not in tree – return null.
    2) Compare the value to the data at the current node.
        a) if the value is less than the data at the current node,
            Return the result of removing from the left subtree.
        b) else if the value is greater than the current node
            Return the result of removing from the right subtree.
        c) else The value is current node's data
            i) if the current node has no children
                Set the parent of the current node to null.
            ii) else if the current node has one child
                Set the parent of the current node to reference that child.
            iii) else
                Find the in-order predecessor, p.
                Set current node's value to be p's value.
                Remove p.
     */

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
