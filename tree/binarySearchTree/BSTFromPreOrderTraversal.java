package binarySearchTree;

//Create a BST using an array which represent a pre-order traversal of it.
//Once created , do a inoreder traversal on tree.This should give a sorted array.
public class BSTFromPreOrderTraversal {

    static Node root;
    public static void main(String[] args) {

        int[] nodeData = { 10, 5, 1, 7, 40, 50 };

        for(int i: nodeData){
            root = insert(root,i);
        }
        TraversalBST.inorder(root);
    }

    private static Node insert(Node root, int i) {
        if(root == null){
            root =  new Node(i);
        }else if(i<root.data){
            root.left = insert(root.left,i);
        }else{
            root.right = insert(root.right,i);
        }
        return root;
    }
}
