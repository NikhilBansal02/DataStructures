package binarySearchTree;

import java.util.*;

public class Printing {

    public static void printLevelOrderBST(Node root){

        if(root == null){
            System.out.println("Empty Tree!!");
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node temp;

        while(q.size()>0){

            temp = q.poll();
            System.out.print(temp.data+" ");

            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        System.out.println();
    }
}
