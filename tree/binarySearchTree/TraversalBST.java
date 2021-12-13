package binarySearchTree;

public class TraversalBST {

    public static void inorder(Node root){

        System.out.println("Inorder Traversal of Given Tree");
        inorderTraversal(root);
        System.out.println();
    }
    //Inorder Traversal of BST always provide sorted values.
    private static void inorderTraversal(Node root){

        if(root ==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+" ");
        inorderTraversal(root.right);
    }
}
