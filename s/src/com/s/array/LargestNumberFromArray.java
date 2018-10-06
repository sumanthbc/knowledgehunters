/*
 *Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.

The result is going to be very large, hence return the result in the form of a string.

Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.


Output:

In each separate line print the largest number formed by arranging the elements of the array in the form of a string.


Constraints:

1 ≤ T ≤ 70
1 ≤ N ≤ 100
0 ≤ A[i] ≤ 1000


Example:

Input:

2
5
3 30 34 5 9
4
54 546 548 60

Output:

9534330
6054854654 
 */

package com.s.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumberFromArray {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-- > 0) {
		    int n = sc.nextInt();
		    Integer []arr = new Integer[n];
		    
		    for(int i=0; i<n; i++) {
		        arr[i] = sc.nextInt();
		    }
		    
		    System.out.println(getMaxNumber(arr));
		}
	}
	
	static String getMaxNumber(Integer []arr) {
	    
	    Arrays.sort(arr, new Comparator<Integer>() {
	      
	      @Override
	      public int compare(Integer i, Integer j) {
	          int ij = Integer.parseInt(i + "" + j);
	          int ji = Integer.parseInt(j + "" + i);
	          return ij<ji? 1:(ij==ji ? 0: -1);
	      }
	    });
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i:arr) {
	        sb.append(i);
	    }
	    
	    return sb.toString();
	}

}
