//Check if the given array can represent Level Order Traversal of Binary Search Tree
//https://www.geeksforgeeks.org/check-given-array-can-represent-level-order-traversal-binary-search-tree/

package binarySearchTree;

import java.util.*;

class NodeDetails{

    int data;
    int min, max;
}

public class IsArrayABST {

    public static void main(String[] args) {
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};

        System.out.println(checkIfBST(arr));
    }

    private static boolean checkIfBST(int[] arr) {

        int n = arr.length;
        Queue<NodeDetails> q = new LinkedList<>();
        NodeDetails node = new NodeDetails();
        int i=0;

        node.data = arr[i++];
        node.min = Integer.MIN_VALUE;
        node.max = Integer.MAX_VALUE;

        q.add(node);

        while(i!=n && q.size()>0){

            NodeDetails temp = q.poll();

            if(arr[i] <= temp.data && arr[i] > temp.min){

                NodeDetails new_node =  new NodeDetails();
                new_node.data = arr[i++];
                new_node.min = temp.min;
                new_node.max = temp.data;
                q.add(new_node);
            }
            if(arr[i] > temp.data && arr[i] < temp.max){

                NodeDetails new_node =  new NodeDetails();
                new_node.data = arr[i++];
                new_node.min = temp.data;
                new_node.max = temp.max;
                q.add(new_node);
            }
        }

        if(i==n)
            return true;

        return false;

    }
}


