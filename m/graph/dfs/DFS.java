package graph.dfs;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import graph.Graph;
import graph.GraphUtil;
import graph.Node;

public class DFS {
	
	Map<Integer, List<String[]>> depthGraph = new HashMap<Integer, List<String[]>>();
	
	public static void main(String[] args) {
		Graph graph = new GraphUtil().generateGraphTree();
		DFS dfs = new DFS();
		dfs.printBeginStatement();
		Stack<String> dfsStack = new Stack<String>();
		dfs.traverse(graph, graph.getRoot(), dfsStack, 0);
		dfs.printEndStatement();
		dfs.printDepthGraph();
	}
	
	public void printDepthGraph() {
		if (depthGraph != null && depthGraph.size() > 0) {
			for(Integer data : depthGraph.keySet()) {
				System.out.println("Depth "+data);
				for (String[] paths : depthGraph.get(data)) {
					System.out.print("Path - ");
					for (String node : paths) {
						System.out.print(node + ", ");
					}
					System.out.println("");
				}
			}
		}
	}
	
	public void traverse(Graph graph, Node root, Stack<String> dfsStack, int depth) {
		dfsStack.push(root.getEntity());
		printStack(dfsStack);
		printNode(root);
		depthTree(dfsStack);
		if (dfsStack.contains(root.getLeft()) && dfsStack.contains(root.getRight())) {
			return;
		}
		if (root.getLeft() != null || root.getRight() != null) {
			depth = depth+1;
			
			if (root.getLeft() != null) {
				traverse(graph, graph.getNodes().get(root.getLeft()), dfsStack, depth);
			}
			if (root.getRight() != null) {
				traverse(graph, graph.getNodes().get(root.getRight()), dfsStack, depth);
			}
		}
		dfsStack.pop();
	}
	
	private void depthTree(Stack<String> dfsStack) {
		if(dfsStack != null && !dfsStack.isEmpty()) {
			Enumeration<String> stackData = dfsStack.elements();
			int count = dfsStack.size();
			String[] depthPath = new String[count];
			int counter = 0;
			while (stackData.hasMoreElements()) {
				depthPath[counter] = stackData.nextElement();
				counter = counter + 1;
			}
			List<String[]> depthPaths = null;
			count = count - 1;
			if (depthGraph.containsKey(count)) {
				depthPaths = depthGraph.get(count);
				depthPaths.add(depthPath);
			} else {
				depthPaths = new ArrayList<String[]>();
				depthPaths.add(depthPath);
				depthGraph.put(count, depthPaths);
			}
		}
	}

	private void printStack(Stack<String> dfsStack) {
		if(dfsStack != null && !dfsStack.isEmpty()) {
			System.out.println("Stack element -- ");
			Enumeration<String> stackData = dfsStack.elements();
			while (stackData.hasMoreElements()) {
				System.out.print(stackData.nextElement()+", ");
			}
			System.out.println("");
		}
	}

	public void addDepthPath(Graph graph, Node node) {
		
	}
	
	public void printBeginStatement() {
		System.out.println("DFS Graph traversal begin");
		System.out.println("=====================");
	}
	
	public void printEndStatement() {
		System.out.println("\n=====================");
		System.out.println("DFS Graph traversal end");
	}
	
	public void printNode(Node node) {
		System.out.print(node.getEntity() + " ");
	}
	
}
