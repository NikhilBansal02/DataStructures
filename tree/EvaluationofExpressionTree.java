package tree;

class Node2{
	
	String data;
	Node2 left;
	Node2 right;
	
	Node2(String data){
		this.data = data;
		left = null;
		right= null;
	}
}

public class EvaluationofExpressionTree {
	Node2 root;
	
	public int getIntValue(String data) {
		int num = 0;
		int temp = 0;
		
		if('-'!= data.charAt(0)) {
			for(int i=0;i<data.length();i++) {
				temp = data.charAt(i)-48;//to get the actual integer value.
				num = num*10 + temp;
			}
		}else {
				for(int i=1;i<data.length();i++) {
					temp = data.charAt(i)-48;//to get the actual integer value.
					num = num*10 + temp;
			}
				num = num*-1;
		}
		return num;
	}
	
	public int eval(Node2 root) {
		
		if(root == null) {
			return 0;
		}
		
		if(root.left==null && root.right == null)
			return getIntValue(root.data);
		
		int l_val = eval(root.left);
		int r_val = eval(root.right);
		
		if(root.data == "*")
			return l_val * r_val;
		
		if(root.data == "+")
			return l_val + r_val;
		
		if(root.data == "-")
			return l_val - r_val;
		
		return l_val / r_val;
	}
	
	public static void main(String[] args) {
		EvaluationofExpressionTree eet = new EvaluationofExpressionTree();
		eet.root = new Node2("+");
		eet.root.left = new Node2("*");
		eet.root.right = new Node2("-");
		eet.root.left.left = new Node2("5");
		eet.root.left.right = new Node2("4");
		eet.root.right.left = new Node2("100");
		eet.root.right.right = new Node2("20");
		System.out.println("Given Expression Tree evaluated to : "+eet.eval(eet.root));
		
	}

}
