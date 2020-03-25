/*A tree is Continuous tree if in each root to leaf path, absolute difference between keys of two adjacent is 1. 
 * We are given a binary tree, we need to check if tree is continuous or not.
 * Input :           3
                    / \
                   2   4
                  / \   \
                 1   3   5
Output: "Yes"
 * 
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ContinuousTree {
	
	Node root;
	
	public boolean isTreeContinuous(Node root) {
		
		if(root ==null) {
			return true;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Node temp = null;
		
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.left!=null && temp.right!=null) {
				if((Math.abs(temp.data - temp.left.data) ==1) &&(Math.abs(temp.data - temp.right.data) ==1)) {
					q.add(temp.left);
					q.add(temp.right);
				}else {
					return false;
				}
			}else if(temp.left!= null) {
					if(Math.abs(temp.data - temp.left.data) ==1) {
						q.add(temp.left);
					}else {
						return false;
					}
			}else if(temp.right!= null) {
				if(Math.abs(temp.data - temp.right.data) ==1) {
					q.add(temp.right);
				}else {
					return false;
				}
			}else {
				continue;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		ContinuousTree ct = new ContinuousTree();
		ct.root = new Node(3);
		ct.root.left = new Node(2);
		ct.root.right = new Node(4);
		ct.root.left.left = new Node(1);
		ct.root.left.right = new Node(3);
		ct.root.right.right = new Node(5);
		if(ct.isTreeContinuous(ct.root)) {
			System.out.println("Given Tree is Continuous");
		}
		else {
			System.out.println("Given Tree is not Continuous");
		}
	}
}
