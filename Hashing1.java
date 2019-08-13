/*Convert an array to reduced form | Hashing
Given an array with n distinct elements, convert the given array to a form where all elements are in range from 0 to n-1. 
The order of elements is same, i.e., 0 is placed in place of smallest element, 1 is placed for second smallest element,
… n-1 is placed for largest element.
Overall time complexity of this solution is O(n Log n).*/

package hashing;

import java.util.Arrays;
import java.util.HashMap;

public class Hashing1 {
	
	static void reducedByHash(int arr[], int n) {
		
		int temp[] = arr.clone(); 
		
		Arrays.sort(temp); 
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		for(int i=0; i<n;i++) {
			hmap.put(temp[i], i);
		}
		
		for(int i=0; i<n;i++) {
			arr[i] = hmap.get(arr[i]);
		}	
	}
	
	static void print(int arr[], int n) {
		
		for(int i=0; i<n;i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		
	}

	public static void main(String[] args) {
	
		int arr[] = {10,50,20,30,5 };
		int size  = arr.length;
		
		System.out.println("Original Array is ");
		print(arr, size);
		
		reducedByHash(arr, size);
		
		System.out.println("Reduced Array is ");
		print(arr, size);

	}

}
