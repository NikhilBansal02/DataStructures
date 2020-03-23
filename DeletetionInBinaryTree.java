/*Deletion in a Binary Tree
Given a binary tree, delete a node from it by making sure that tree shrinks from the bottom 
(i.e. the deleted node is replaced by bottom most and rightmost node). 
This different from BST deletion. Here we do not have any order among elements, so we replace with last element.
Examples :

Delete 10 in below tree
       10
     /    \         
    20     30
Output :    
       30
     /             
    20   
*/
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletetionInBinaryTree {
	Node root;
	
	public void deleteRightMostNode(Node root, Node dNode) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		Node temp = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			
			if(temp == dNode) {
				temp =null;
				return;
			}
			if(temp.right!=null) {
				if(temp.right == dNode) {
					temp.right =null;
					return;
				}else {
				q.add(temp.right);
				}
			}
			if(temp.left!=null) {
				if(temp.left==dNode) {
					temp.left = null;
					return;
				}else {
				q.add(temp.left);
				}
			}
		}
	}
	
	public Node deleteNode(Node node, int key) {
		
		if(node == null) return null;
		
		if(node.left == null  && node.right==null) {
			if(node.data == key)
				return null;
			else
				return node;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		
		Node temp=null;
		Node key_node = null; // this will hold the node of key if present.
		// Doing the level order search to find the key_node and the deepest and rightmost key.
		
		while(!q.isEmpty()) {
			temp = q.poll();
			
			if(temp.data == key) {
				key_node = temp;
			}
			if(temp.left!=null) {
				q.add(temp.left);
			}
			if(temp.right!=null) {
				q.add(temp.right);
			}
		}
		if(key_node!=null) {
			int x = temp.data;
			deleteRightMostNode(root,temp);
			key_node.data = x;
		}
		
		return node ;
	}
	
	public static void main(String[] args) {
		
		DeletetionInBinaryTree d1 = new DeletetionInBinaryTree();
		BinaryTreeWithTraversal bt = new BinaryTreeWithTraversal();
		
		d1.root = new Node(10);
		
		d1.root.left = new Node(11);
		d1.root.left.left = new Node(7);
		d1.root.left.right = new Node(12);
		
		d1.root.right = new Node(9);
		d1.root.right.left = new Node(15);
		d1.root.right.right = new Node(8);
		System.out.println("Inorder Traversal Before Deletion");
		bt.inOrderTraversal(d1.root);
		System.out.println();
		
		d1.root = d1.deleteNode(d1.root, 7);
		System.out.println("Inorder Traversal After Deletion");
		bt.inOrderTraversal(d1.root);
	}
}
