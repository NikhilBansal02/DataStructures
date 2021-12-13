package avl;

/**
 * @author Nikhil Bansal
 * @implNote This program provides the deletion operation on Binary Search Tree.
 * Post deletion, the tree self-balances itself to ensure operations performance will always cost O(logn).
 */

public class Deletion {

    static Node root;
    static boolean deleted = false;
    public static void main(String[] args) {

        root = Insertion.insert(root,9);
        root = Insertion.insert(root,5);
        root = Insertion.insert(root,10);
        root = Insertion.insert(root,0);
        root = Insertion.insert(root,6);
        root = Insertion.insert(root,11);
        root = Insertion.insert(root,-1);
        root = Insertion.insert(root,1);
        root = Insertion.insert(root,2);

       // Traversal.preorder(root);
        Traversal.inorder(root);
        root = deleteNode(root,11);
        root = deleteNode(root,6);
        //Traversal.preorder(root);
        Traversal.inorder(root);
    }

    public static Node deleteNode(Node root, int key){

        if(root == null){
            return root;
        }

        if(key < root.data){
            root.left = deleteNode(root.left,key);
        }else if(key> root.data){
            root.right = deleteNode(root.right,key);
        }else{ // This is where we found the matching node with key.

            //Now, we have located the node with key.
            //We have to delete it on the basis if it is a leaf, or having one child or two child.

            //Means if Node has no children or either of one child.
            if(root.left == null || root.right == null){

                Node temp =null;
                if(temp == root.left){
                    temp = root.right;
                }else
                    temp = root.left;

                //If temp is still null, means this node has no child and is a leaf.
                if(temp == null){
                    root =null;
                }else{//if not, meaning node has one child then place this node to its child place there by indirectly deleting this node.
                    root = temp;
                }
            }else{//Node has both children

                Node minNode = findMinNode(root.right);
                root.data = minNode.data;
                root.right = deleteNode(root.right,minNode.data);

            }
            deleted = true;
        }

        //if block should only be executed if something is deleted.
        if(deleted) {
            //This can be null in case we have deleted a leaf node;
            if (root == null) {
                return root;
            }

            //Update the height of current node.Using Height method from insertion.
            Insertion.updateHeight(root);

            //Check the balance factor of this node to check if there is any un-balance of height.
            int balanceFactor = Insertion.getBalanceFactor(root);

            return checkAndBalanceTree(root, balanceFactor);
        }else{
            return root;
        }
    }

    public static Node findMinNode(Node root){

        if(root.left == null && root.right == null){
            return root;
        }else{
            if(root.left!=null){
                return findMinNode(root.left);
            }else
                return findMinNode(root.right);

        }
    }

    public static Node checkAndBalanceTree(Node root, int balanceFactor){

        //Right-Right case.
        if(balanceFactor < -1 && Insertion.getBalanceFactor(root.right) <=0){

            return Insertion.rotateleft(root);
        }

        //Right-Left
        if(balanceFactor < -1 && Insertion.getBalanceFactor(root.right)  > 0){
            root.right = Insertion.rotateRight(root.right);
            return Insertion.rotateleft(root);
        }

        //Left-Left case.
        if(balanceFactor > 1 && Insertion.getBalanceFactor(root.left) >=0){

            return Insertion.rotateRight(root);
        }

        //Left-Right case
        if(balanceFactor > 1 && Insertion.getBalanceFactor(root.left)  < 0){
            root.left = Insertion.rotateleft(root.left);
            return Insertion.rotateRight(root);
        }

        //This will return the same node in case no un-balance is present on this node and
        return root;
    }
}
