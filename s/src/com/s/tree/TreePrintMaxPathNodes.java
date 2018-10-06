/**
 * Print the deepest path from root to leaf node in a binary tree. 
 * If there are multiple paths with same height, then print all
 * 
 * Time Complexity: TBD
 * Space Complexity: TBD
 */

package com.s.tree;

import java.util.Comparator;
import java.util.HashMap;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class TreePrintMaxPathNodes {

	public static void main(String[] args) {

		// Input the number of test cases you want to run
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// Node root=null;
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			TreePrintMaxPathNodes treePrintMaxPathNodes = new TreePrintMaxPathNodes();
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);

				Node parent = m.get(n1);
				if (parent == null) {
					parent = treePrintMaxPathNodes.new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = treePrintMaxPathNodes.new Node(n2);
				if (lr == 'L') {
					parent.left = child;
					child.parent = parent;
				} else {
					parent.right = child;
					child.parent = parent;
				}
				m.put(n2, child);
				n--;
			}

			int maxHeight = treePrintMaxPathNodes.height(root, 0);
			System.out.println("Maximum Path Length is: " + maxHeight);

			while (!treePrintMaxPathNodes.maxQueue.isEmpty()) {
				Node node = treePrintMaxPathNodes.maxQueue.poll();
				if (node.height < maxHeight) {
					break;
				}

				Stack<Integer> st = new Stack<>();
				while (node != null) {
					st.push(node.data);
					node = node.parent;
				}

				while (!st.isEmpty()) {
					System.out.print(st.pop() + " ");
					if (!st.isEmpty()) {
						System.out.print("->");
					}
				}

				System.out.println();

			}

			t--;

		}
	}

	class Node {
		int data;
		Node left, right, parent;
		int height;

		Node(int item) {
			data = item;
			left = right = parent = null;
		}

	}

	PriorityQueue<Node> maxQueue = new PriorityQueue<>(new Comparator<Node>() {
		@Override
		public int compare(Node n1, Node n2) {
			return n1.height < n2.height ? 1 : (n1.height == n2.height ? 0 : -1);
		}
	});

	int height(Node node, int height) {
		if (node == null) {
			return 0;
		}

		int leftHeight = height(node.left, height + 1);

		int rightHeight = height(node.right, height + 1);

		int heightL = Math.max(leftHeight, rightHeight) + 1;
		node.height = height + 1;

		maxQueue.add(node);

		return heightL;
	}

}
