package avl;

public class Traversal {

    public static void inorder(Node root) {

        System.out.println("Inorder Traversal of Given Tree");
        inorderTraversal(root);
        System.out.println();
    }

    //Inorder Traversal of BST always provide sorted values.
    private static void inorderTraversal(Node root) {

        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void preorder(Node root) {

        System.out.println("Preorder Traversal of Given Tree");
        preorderTraversal(root);
        System.out.println();
    }

    //Inorder Traversal of BST always provide sorted values.
    private static void preorderTraversal(Node root) {

        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
