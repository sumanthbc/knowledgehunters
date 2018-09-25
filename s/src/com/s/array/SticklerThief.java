
/*Stickler Thief
Stickler is a thief and wants to loot money from a society of n houses placed in a line. He is a weird person and follows a rule while looting the houses and according to the rule he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to find the maximum amount he can end up with. He asks for your help to find the maximum money he can get if he strictly follows the rule. Each house has a[i] amount of money present in it.
Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains an integer n which denotes the number of elements in the array a[]. Next line contains space separated n elements in the array a[].
 
Output:
Print an integer which denotes the maximum amount he can take home.
 
Constraints:
1<=T<=200
1<=n<=1000
1<=a[i]<=10000
 
Example:
Input:
2
6
5 5 10 100 10 5
3
1 2 3
 
Output:
110
4


Time Complexity O(n), Space complexity O(1) */

package com.s.array;

import java.util.*;
import java.lang.*;
import java.io.*;

class SticklerThief {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int[] moneyInHouse = new int[n];
			for (int i = 0; i < n; i++) {
				moneyInHouse[i] = sc.nextInt();
			}

			System.out.println(findMaxMoneyLoot(moneyInHouse, n));
		}
	}

	static int findMaxMoneyLoot(int[] moneyInHouse, int n) {
		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return moneyInHouse[0];
		}

		if (n == 2) {
			return Math.max(moneyInHouse[0], moneyInHouse[1]);
		}

		int value1 = moneyInHouse[0];
		int value2 = Math.max(value1, moneyInHouse[1]);

		for (int i = 2; i < n; i++) {
			int maxValue = Math.max(value2, value1 + moneyInHouse[i]);
			value1 = value2;
			value2 = maxValue;
		}

		return value2;
	}
}
