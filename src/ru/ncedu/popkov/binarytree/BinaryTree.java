package ru.ncedu.popkov.binarytree;

import java.util.Stack;

/**
 * Binary Tree class
 *
 * @author Anton Popkov
 */
public class BinaryTree {
    Node root;
    static Stack<Node> stack1, stack2;

    /**
     * Method that implements inorder traversal
     *
     * @param root root node
     */
    public void inOrderTraversal(Node root) {
        Node current, p;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {

                p = current.left;
                while (p.right != null
                        && p.right != current)
                    p = p.right;


                if (p.right == null) {
                    p.right = current;
                    current = current.left;
                } else {
                    p.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    /**
     * Method that implements postorder traversal
     *
     * @param root - tree root node
     */
    static void postOrderTraversal(Node root) {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

        if (root == null)
            return;

        // Push root to first stack
        stack1.push(root);

        // Run while first stack is not empty
        while (!stack1.isEmpty()) {
            // Pop an item from stack1 and push it to stack2
            Node temp = stack1.pop();
            stack2.push(temp);

            // Push left and right children to stack1
            if (temp.left != null)
                stack1.push(temp.left);
            if (temp.right != null)
                stack1.push(temp.right);
        }

        // Print elements of stack2
        while (!stack2.isEmpty()) {
            Node temp = stack2.pop();
            System.out.print(temp.data + " ");
        }
    }

    /**
     * Method that implements preorder traversal
     */
    public void preOrderTraversal() {

        if (root == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        /* Pop all items one by one
         a) print it
         b) push its right child
         c) push its left child */
        while (!nodeStack.empty()) {

            // Pop the top item from stack and print it
            Node newNode = nodeStack.peek();
            System.out.print(newNode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (newNode.right != null) {
                nodeStack.push(newNode.right);
            }
            if (newNode.left != null) {
                nodeStack.push(newNode.left);
            }
        }
    }

    /**
     * Compute the height of a tree
     *
     * @param node tree node
     * @return the height of the tree
     */
    public int height(Node node) {
        if (node == null)
            return 0;
        else {
            /* the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    static class Node {
        int data;
        Node left, right;

        /**
         * Constructor
         *
         * @param item - node value
         */
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
