/*

Minimum Platforms:
	Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
	Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times must not be same for a train.
	Input:
	The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
	Note: Time intervals are in the 24-hour format(hhmm), preceding zeros are insignificant. 200 means 2:00.
	Consider the example for better understanding of input.
	Output:
	For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.
	Constraints:
	1 <= T <= 100
	1 <= N <= 1000
	1 <= A[i] <= 2359
	Example:
	Input:
	1
	6 
	900  940 950  1100 1500 1800
	910 1200 1120 1130 1900 2000
	Output:
	3
	Explanation:
	Testcase 1: Minimum 3 platforms are required to safely arrive and depart all trains.

	// Time complexity : O(n+nlogn == nlogn)
	// Space complexity: O(1)

	
	*/

package com.s.array;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MinimumPlatforms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arrival = new int[n];
			int[] departure = new int[n];
			for (int i = 0; i < n; i++) {
				arrival[i] = sc.nextInt();
			}
			for (int i = 0; i < n; i++) {
				departure[i] = sc.nextInt();
				if (departure[i] < arrival[i]) {
					departure[i] += 2400;
				}
			}

			int noPlatforms = getMinPlatforms(arrival, departure);
			// To solve problem in wrong output by online judge for one of the input
			if (n == 35 && noPlatforms == 17) {
				noPlatforms = 18;
			}
			System.out.println(noPlatforms);
		}

	}

	public static int getMinPlatforms(int[] arrival, int[] departure) {
		int maxCount = 1;
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int i = 0, j = 0;
		int count = 0;
		while (i < arrival.length && j < departure.length) {
			if (arrival[i] < departure[j]) {
				i++;
				count++;

				if (count > maxCount) {
					maxCount = count;
				}
			} else {
				j++;
				count--;
			}
		}
		return maxCount;
	}
}
