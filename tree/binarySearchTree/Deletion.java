package binarySearchTree;

public class Deletion {

    static Node root;
    public static void main(String[] args) {

        root = Insertion.insert(root,50);
        root = Insertion.insert(root,30);
        root = Insertion.insert(root,70);
        root = Insertion.insert(root,20);
        root = Insertion.insert(root,40);
        root = Insertion.insert(root,60);
        root = Insertion.insert(root,80);

        TraversalBST.inorder(root);

        /*System.out.println("Delete = 1000");
        deleteNode(root,1000);
        TraversalBST.inorder(root);

        //Deleting Leaf Node
        System.out.println("Delete = 40");
        deleteNode(root,40);
        TraversalBST.inorder(root);

        //Deleting Node with One child
        System.out.println("Delete = 30");
        deleteNode(root,30);
        TraversalBST.inorder(root);

        //Deleting Leaf Node
        System.out.println("Delete = 60");
        deleteNode(root,60);
        TraversalBST.inorder(root);

        //Deleting Node with One child
        System.out.println("Delete = 70");
        deleteNode(root,70);
        TraversalBST.inorder(root);

        //Deleting Node with two child
        System.out.println("Delete = 50");
        deleteNode(root,50);
        TraversalBST.inorder(root);*/

        //Deleting Node with Two child
        System.out.println("Delete = 30");
        deleteNode(root,30);
        TraversalBST.inorder(root);

        //Deleting Node with Two child
        System.out.println("Delete = 70");
        deleteNode(root,70);
        TraversalBST.inorder(root);

        //Deleting Node with Zero child
        System.out.println("Delete = 20");
        deleteNode(root,20);
        TraversalBST.inorder(root);

        //Deleting Node with One child
        System.out.println("Delete = 80");
        deleteNode(root,80);
        TraversalBST.inorder(root);

        //Deleting Node with Both child
        System.out.println("Delete = 50");
        deleteNode(root,50);
        TraversalBST.inorder(root);

        System.out.println("Roots Data : "+root.data);
    }

    public static void deleteNode(Node root, int key){

        if(root == null){
            System.out.println("Tree is Empty");
            return;

        }
        Node searchedNode= Searching.search(root,key);
        if(searchedNode==null){
            System.out.println(key +" key is not present in Tree");
            return;
        }else if(searchedNode.left==null && searchedNode.right==null){
                deleteNodeWithNoChild(root,searchedNode);

        }else if((searchedNode.left!=null && searchedNode.right==null) ||
                (searchedNode.left==null && searchedNode.right!=null)){
            deleteNodeWithSingleChild(root,searchedNode);

        }else {
                deleteNodeWithBothChild(root,searchedNode);
        }

    }

    public static void deleteNodeWithNoChild(Node root, Node NodeToBeDeleted){

        if(root.left == NodeToBeDeleted){
             root.left =null;
               return;
            }else if(root.right == NodeToBeDeleted){
                root.right =null;
                return;
            }
            if(NodeToBeDeleted.data <root.data){
                deleteNodeWithNoChild(root.left,NodeToBeDeleted);
            }else{
                deleteNodeWithNoChild(root.right,NodeToBeDeleted);
            }


    }

    public static void deleteNodeWithSingleChild(Node root,Node NodeToBeDeleted){

        if(root == NodeToBeDeleted){

            if(root.left!=null){

                int temp = root.left.data;
                root.left.data = NodeToBeDeleted.data;
                NodeToBeDeleted.data = temp;
                root.left =null;
                return;
            }else if(root.right !=null){

                int temp = root.right.data;
                root.right.data = NodeToBeDeleted.data;
                NodeToBeDeleted.data = temp;
                root.right =null;
                return;
            }

        }

        if(NodeToBeDeleted.data <root.data){
            deleteNodeWithSingleChild(root.left,NodeToBeDeleted);
        }else{
            deleteNodeWithSingleChild(root.right,NodeToBeDeleted);
        }
    }
    public static void deleteNodeWithBothChild(Node root, Node NodeToBeDeleted){
            NodeToBeDeleted.data = findMinimumNode(root,NodeToBeDeleted.right);
    }

    public static int findMinimumNode(Node root,Node node){

        Node MinNode= callInorder(node);
        int data = MinNode.data;
        deleteNodeWithNoChild(root,MinNode);
        return data;
    }

    public static Node callInorder(Node root){

        if(root.left ==null && root.right ==null ){
            return root;
        }

        if(root.left!=null){
            return callInorder(root.left);
        }else {
           return  callInorder(root.right);
        }
    }

    }
