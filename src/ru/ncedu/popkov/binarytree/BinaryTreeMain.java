package ru.ncedu.popkov.binarytree;

/**
 * Execute program
 *
 * @author Anton Popkov
 */
public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new BinaryTree.Node(1);
        binaryTree.root.left = new BinaryTree.Node(2);
        binaryTree.root.right = new BinaryTree.Node(5);
        binaryTree.root.right.left = new BinaryTree.Node(3);
        binaryTree.root.right.right = new BinaryTree.Node(6);

        System.out.println("Preorder: ");
        binaryTree.preOrderTraversal();
        System.out.println("\n");

        System.out.print("Inorder: ");
        binaryTree.inOrderTraversal(binaryTree.root);
        System.out.println("\n");

        System.out.print("Postorder: ");
        BinaryTree.postOrderTraversal(binaryTree.root);
        System.out.println("\n");

        System.out.print("Height of a Binary Tree: ");
        System.out.println(binaryTree.height(binaryTree.root));
    }
}