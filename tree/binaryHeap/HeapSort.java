package binaryHeap;

import java.util.*;

/**
 * @author Nikhil Bansal
 * TC - O(nlogn)
 * Heap Sort is an in-place algorithm
 */
public class HeapSort {

    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        //Create Max-Heap from input.
        generateMaxHeap(arr,n);

        //Sort Elements or Heap-Sort.
        //i =n-1; as n-1 is last index of array.
        //i>0; first node not included as at the end of loop this will hold the smallest element.
        //We will simply replace first element with last and max heapify first or zeroth element
        //to again bring next largest element on top.
        for(int i=n-1;i>0;i--){

            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            maxHeapify(arr, i,0);
        }

        //print arry.
        System.out.println(Arrays.toString(arr));

    }

    public static void generateMaxHeap(int[] arr, int n){

        //Loop will run for each internal node and max heapify will be called on it
        // and on its sub-tree to maintain max heap property of this internal node and its sub-tree.
        for(int i = n/2 -1;i>=0;i--){

            maxHeapify(arr,n,i);
        }

    }

    public static void maxHeapify(int[] arr, int n, int i){

        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        //Means this index i.e. left lies in array and its value is greater than this current internal node
        if(left < n && arr[left] > arr[i]){
            largest = left;
        }

        //Means this index i.e. right lies in array and its value is greater than this left child of this internal node
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest!=i){

            swap(arr, i, largest);
            maxHeapify(arr,n,largest);
        }
    }

    public static void swap(int arr[], int parent, int child){

        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }
}
