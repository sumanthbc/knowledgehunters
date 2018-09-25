package graph;

import graph.bfs.BFS;
import graph.dfs.DFS;

public class TestGraph {

	public static void main(String[] args) {
		Graph graph = new GraphUtil().generateGraphTree();
		System.out.println("Preorder");
		graph.traversePreOrder();
		System.out.println("Inorder");
		graph.traverseInOrder();
		System.out.println("Postorder");
		graph.traversePostOrder();
		System.out.println("BFS");
		BFS bfs = new BFS();
		bfs.main(null);
		System.out.println("DFS");
		DFS dfs = new DFS();
		dfs.main(null);
	}
}
