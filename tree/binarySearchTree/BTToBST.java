package binarySearchTree;

import java.util.*;

//Given a Binary Tree, convert it to a Binary Search Tree. The conversion must be done in such a way that keeps the original structure of Binary Tree.
/*
        Input:
        10
        /  \
      30   15
      /      \
    20       5

      Output:
       15
      /  \
    10    20
   /      \
   5        30
 */
public class BTToBST {

    static Node root;
    static List<Integer> list  = new ArrayList<>();
    static int i=0;
    public static void main(String[] args) {

        //Create a Binary Tree.
        root = getBinaryTree();

        //Get the inorder traversal of tree and save it to a list.
        doInorder(root);

        //Sort the list
        Collections.sort(list);

        //Traverse Inorder and count elements from list.
        doInorderAndCopyElements(root);

        //Traverse tree (converted to BST) again in inorder, this should give sorted data.
        //We will be using same list and then fed data to it and print it.
        list.clear();;
        doInorder(root);
        System.out.println(list);
    }

    public static Node getBinaryTree(){

        root = new Node(10);
        root.left = new Node(30);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.right.right = new Node(5);

        return root;
    }

    public static void doInorder(Node root){

        if(root == null){
            return;
        }else{

            doInorder(root.left);
            list.add(root.data);
            doInorder(root.right);
        }
    }

    public static void doInorderAndCopyElements(Node root){

        if(root == null){
            return;
        }else{

            doInorderAndCopyElements(root.left);
            root.data = list.get(i++);
            doInorderAndCopyElements(root.right);
        }
    }
}