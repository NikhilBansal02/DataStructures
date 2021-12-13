package binarySearchTree;

/*Time Complexity: The worst-case time complexity of search and insert operations is O(h) where h is the height of the Binary Search Tree.
In the worst case, we may have to travel from root to the deepest leaf node.
The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).*/

public class Insertion {
    static Node root;

    public static void main(String[] args) {

        root = GetTree.getTree();
        //root =null;
        Printing.printLevelOrderBST(root);

        int key = 5;
        root =insert(root,key);
        Printing.printLevelOrderBST(root);
        TraversalBST.inorder(root);
    }
                    /*20
                     / \
                    8   22
                   / \
                  4  12
                     /\
                   10 14*/
    public static Node insert(Node root, int key) {

        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.data){
            root.left = insert(root.left,key);
        }else{
            root.right= insert(root.right,key);
        }
        return root;
    }
}
