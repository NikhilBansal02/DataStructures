package tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInBinaryTreeInLevelOrder {
	
	Node root;
	
	public void inOrderTraversal(Node node) {
		
		if(node == null) 
			return;
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
	}
	public void insert(Node node, int key) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		
		while(!q.isEmpty()) {
			node = q.poll();
			
			if(node.left == null) {
				node.left = new Node(key);
				break;
			}else {
				q.add(node.left);
			}
			
			if(node.right == null) {
				node.right = new Node(key);
				break;
			}else {
				q.add(node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		
		InsertInBinaryTreeInLevelOrder bt1 = new InsertInBinaryTreeInLevelOrder();
		bt1.root = new Node(10);
		bt1.root.left  = new Node(11);
		bt1.root.left.left  = new Node(7);
		bt1.root.right  = new Node(9);
		bt1.root.right.left  = new Node(15);
		bt1.root.right.right  = new Node(8);
		
		System.out.println("InOrder Traversal Before Insertion");
		bt1.inOrderTraversal(bt1.root);
		System.out.println();
		bt1.insert(bt1.root, 12);
		System.out.println("InOrder Traversal After Insertion");
		bt1.inOrderTraversal(bt1.root);
	}

}
