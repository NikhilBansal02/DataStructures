package binarySearchTree;

public class MinimumNode {

    static Node root;
    public static void main(String[] args) {

        root = GetTree.getTree();
        findMinimum(root);

    }

    private static void findMinimum(Node root) {

        if(root.left == null){
            System.out.println(root.data);
            return;
        }else{
            findMinimum(root.left);

        }
    }
}
