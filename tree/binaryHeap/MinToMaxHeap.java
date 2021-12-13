package binaryHeap;

import java.util.*;

/**
 * The idea is to simply create max heap with whatever is given in input.
 * We will iterate over every internal node and call max heapify on it to make it and its sub-tree max heap.
 * Once loop completes, we have max heap in place.
 * TC - o(n)
 */
public class MinToMaxHeap {

    public static void main(String[] args) {
        int arr[] = {3,5,9,6,8,20,10,12,18,9};

        int n = arr.length;

        for(int i=n/2-1; i>=0;i--){
            HeapSort.maxHeapify(arr,n,i);
        }
        System.out.println(Arrays.toString(arr));
        print(arr);
    }

    public static void print(int a[]){
        int n = a.length;
        int l=0;
        int r;

        for(int i=0;i<n/2;i++){

            l = 2*i+1;
            r = 2*i+2;

            System.out.print("Root : "+a[i]+" ");
            if(l<=(n-1))
                System.out.print("Left Child : "+a[l]+" ");
            if(r<=(n-1))
                System.out.println("Right Child : " + a[r]);

        }
    }
}
