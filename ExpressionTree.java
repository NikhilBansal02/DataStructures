/*Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node corresponds to operand
 * so for example expression tree for 3 + ((5+9)*2) would be:
 * 		+
 * 	   / \	
 * 	  3   *
 *       / \
 * 		+   2
 *     / \
 *    5   9
 *    Inorder traversal of expression tree produces infix version of given postfix expression 
 *    (same with preorder traversal it gives prefix expression)
 */

/* The below program parses the POSTFIX notation and create the expression tree for it.
 * When tree is traversed with INORDER manner it produces corresponding infix notation.
 * 
 */
package tree;

import java.util.Stack;

class Node1{
	
	char value;
	Node1 left;
	Node1 right;
	Node1(char value){
		this.value = value;
			  left = null;
			 right = null;
	}
}

public class ExpressionTree {
	Node1 root;
	
	public void inOrder(Node1 root) {
		
		if(root == null)
			return;
		
		inOrder(root.left);
		System.out.print(root.value+" ");
		inOrder(root.right);
		
	}
	public boolean isOperator(char ch) {
		
		return(ch=='+'|| ch=='-'||ch=='*'||ch=='/'||ch=='^');
	}
	
	public Node1 constructExpressionTree(char ch[]) {
		
		Node1 t = null;
		Node1 t1,t2;
		
		Stack<Node1> st = new Stack<Node1>();
		
		for(int i=0;i<ch.length;i++) {
			if(!isOperator(ch[i])) {
				
				t = new Node1(ch[i]);
				st.push(t);
				
			}else { // in case of operator
				
				t = new Node1(ch[i]);
				t1 = st.pop();
				t2 = st.pop();
				
				t.right= t1;
				t.left = t2;
				
				st.push(t);
			}
		}
		return t;
	}
	
	public static void main(String[] args) {
		ExpressionTree et = new ExpressionTree();

		String postfix = "ab+ef*g*-";
		char ch[] = postfix.toCharArray();
		et.root = et.constructExpressionTree(ch);
		System.out.println("Infix Notation is: ");
		et.inOrder(et.root);
		System.out.println();
	}

}
