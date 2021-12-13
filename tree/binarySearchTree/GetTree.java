package binarySearchTree;

public class GetTree {

    public static Node getTree(){

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        return root;

                        /*20
                        /   \
                       8     22
                      / \
                     4  12
                        /\
                       10 14*/

    }
}
