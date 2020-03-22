package tree;

class BinaryTreeWithTraversal {
		Node root;
		
		public void preOrderTraversal(Node node) {
			
			if(node == null)
				return;
			
			System.out.print(node.data + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
		public void postOrderTraversal(Node node) {
			
			if(node == null)
				return;
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " ");
		}
		public void inOrderTraversal(Node node) {
			
			if(node == null)
				return;
			inOrderTraversal(node.left);
			System.out.print(node.data + " ");
			inOrderTraversal(node.right);
		}
		
	public static void main(String[] args) {
		
		BinaryTreeWithTraversal bt = new BinaryTreeWithTraversal();
		bt.root = new Node(1);
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		System.out.println("PreOrder");
		bt.preOrderTraversal(bt.root);
		System.out.println();
		
		System.out.println("InOrder");
		bt.inOrderTraversal(bt.root);
		System.out.println();
		
		System.out.println("PostOrder");
		bt.postOrderTraversal(bt.root);
	}

}
