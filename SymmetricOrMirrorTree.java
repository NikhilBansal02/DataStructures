/*Given a binary tree, check whether it is a mirror of itself.

For example, this binary tree is symmetric:

     1
   /   \
  2     2
 / \   / \
3   4 4   3

But the following is not:
	1
   / \
  2   2
   \   \
   3    3
   
*/

package tree;

public class SymmetricOrMirrorTree {
	Node root;
	
	boolean isMirror(Node node1, Node node2) {
		
		if(node1 == null && node2 == null) 
			return true;
		
		if(node1!=null && node2!=null && node1.data == node2.data) {
			return (isMirror(node1.left,node2.right) && isMirror(node1.right , node2.left));
		}
		
		return false;
	}
	
	boolean isSymmetric(Node root) {
		
		return isMirror(root,root);
	}
	public static void main(String[] args) {
		SymmetricOrMirrorTree tree  = new SymmetricOrMirrorTree();
		
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(3);
        
        if(tree.isSymmetric(tree.root))
        	System.out.println("Tree is Mirror of Itself");
        else
        	System.out.println("Tree is Not Mirror of Itself");
	}

}
