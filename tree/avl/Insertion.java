package avl;

/**
 * @author Nikhil Bansal
 * @implNote The program provides the insertion functionality to Binary Search Tree.
 * The tree on every insertion self-balances itself to make sure height of tree remains O(logn).
 */
public class Insertion {

    static Node root;
    public static void main(String[] args) {

        root= insert(root, 10);
        root= insert(root, 20);
        root= insert(root, 30);
        root= insert(root, 40);
        root= insert(root, 50);
        root= insert(root, 25);

        Traversal.inorder(root);
        Traversal.preorder(root);
    }
    public static Node insert(Node root, int key){

        //Step-1 : Insert Node in AVL Tree using standard process of inserting node in BST.
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.data){
            root.left = insert(root.left,key);
        }else if(key > root.data){
            root.right = insert(root.right, key);
        }else{
            return root;
        }

        //Step-2: Once inserted, update the height of Node on which sub-tree is rooted.This will run recursively for every node on path where insertion is done.
        updateHeight(root);

        //Step-3: Check the balance factor, which is difference of height between left and right sub-tree.
        int balanceFactor = getBalanceFactor(root);

        //Step-4: Validate Balance factor and do Rotation if needed.

        return balanceTree(balanceFactor, root, key);

    }

    public static void updateHeight(Node root){

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) +1;
    }

    public static int getHeight(Node root){

        return (root == null) ? 0 : root.height;
    }

    public static int getBalanceFactor(Node root){

        return getHeight(root.left) - getHeight(root.right);
    }

    public static Node balanceTree(int balanceFactor, Node root, int key){

        //Left-Left Case
        if(balanceFactor > 1 && key < root.left.data) {
            return rotateRight(root);
        }

        //Left-Right Case
        if(balanceFactor > 1 && key > root.left.data){
            root.left = rotateleft(root.left);
            return rotateRight(root);
        }

        //Right-left Case
        if(balanceFactor < -1 && key < root.right.data) {
            root.right=  rotateRight(root.right);
            return rotateleft(root);
        }

        //Right-Right Case
        if(balanceFactor < -1 && key > root.right.data) {
            return rotateleft(root);
        }

        return root;

    }

    public static Node rotateRight(Node x){

        Node y = x.left;
        Node T1 = y.right;

        y.right = x;
        x.left = T1;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    public static Node rotateleft(Node x){

        Node y = x.right;
        Node T1 = y.left;

        y.left = x;
        x.right = T1;

        updateHeight(x);
        updateHeight(y);

        return y;
    }
}
