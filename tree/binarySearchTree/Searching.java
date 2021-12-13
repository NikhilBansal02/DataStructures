/*Time Complexity: The worst-case time complexity of search and insert operations is O(h) where h is the height of the Binary Search Tree.
In the worst case, we may have to travel from root to the deepest leaf node.
The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).*/

package binarySearchTree;

public class Searching {

    static Node root;

    public static void main(String[] args) {

        root = GetTree.getTree();
        int key =20;

        String str = search(root,key) !=null ? key+" is present in Tree" :key+" is not present in Tree";
        System.out.println(str);
    }

    public static Node search(Node root,int key) {

        if(root ==null || root.data == key){
            return root;
        }else if(key<root.data)
            return search(root.left,key);
        else
            return search(root.right,key);

        }
    }
