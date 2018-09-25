package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	
	private Map<String, Node> nodes;
	private Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Map<String, Node> getNodes() {
		return nodes;
	}

	public void setNodes(Map<String, Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode(Node node) {
		if (nodes == null) {
			nodes = new HashMap<String, Node>();
		}
		nodes.put(node.getEntity(), node);
	}
	
	public void traversePreOrder() {
		if (nodes != null && root != null) {
			System.out.println("Graph traversal Begin");
			System.out.println("=====================");
			System.out.print(root.getEntity() + " ");
			traversePreOrderLeft(root);
			traversePreOrderRight(root);
			System.out.println("\n=====================");
			System.out.println("Graph traversal end");
		}
	}
	
	private void traversePreOrderLeft(Node node) {
		if (nodes.containsKey(node.getLeft())) {
			Node left = nodes.get(node.getLeft());
			System.out.print(left.getEntity() + " ");
			if (left.getLeft() != null) {
				traversePreOrderLeft(left);
			}
			if (left.getRight() != null) {
				traversePreOrderRight(left);
			}
		}
	}
	
	private void traversePreOrderRight(Node node) {
		if (nodes.containsKey(node.getRight())) {
			Node right = nodes.get(node.getRight());
			System.out.print(right.getEntity() + " ");
			if (right.getLeft() != null) {
				traversePreOrderLeft(right);
			}
			if (right.getRight() != null) {
				traversePreOrderRight(right);
			}
		}
	}
	
	public void traverseInOrder() {
		if (nodes != null && root != null) {
			System.out.println("Graph traversal Begin");
			System.out.println("=====================");
			if (root.getLeft() != null) 
				traverseInOrderLeft(root);
			System.out.print(root.getEntity() + " ");
			if (root.getRight() != null)
				traverseInOrderRight(root);
			System.out.println("\n=====================");
			System.out.println("Graph traversal end");
		}
	}

	private void traverseInOrderLeft(Node node) {
		if (nodes.containsKey(node.getLeft())) {
			Node left = nodes.get(node.getLeft());
			if (left.getLeft() != null) {
				traverseInOrderLeft(left);
			}
			System.out.print(left.getEntity() + " ");
			if (left.getRight() != null) {
				traverseInOrderRight(left);
			}
		}
	}
	
	private void traverseInOrderRight(Node node) {
		if (nodes.containsKey(node.getRight())) {
			Node right = nodes.get(node.getRight());
			if (right.getLeft() != null) {
				traverseInOrderLeft(right);
			}
			System.out.print(right.getEntity() + " ");
			if (right.getRight() != null) {
				traverseInOrderRight(right);
			}
		}
	}
	
	public void traversePostOrder() {
		if (nodes != null && root != null) {
			System.out.println("Graph traversal Begin");
			System.out.println("=====================");
			if (root.getLeft() != null) 
				traversePostOrderLeft(root);
			if (root.getRight() != null)
				traversePostOrderRight(root);
			System.out.print(root.getEntity() + " ");
			System.out.println("\n=====================");
			System.out.println("Graph traversal end");
		}
	}

	private void traversePostOrderLeft(Node node) {
		if (nodes.containsKey(node.getLeft())) {
			Node left = nodes.get(node.getLeft());
			if (left.getLeft() != null) {
				traversePostOrderLeft(left);
			}
			if (left.getRight() != null) {
				traversePostOrderRight(left);
			}
			System.out.print(left.getEntity() + " ");			
		}
	}
	
	private void traversePostOrderRight(Node node) {
		if (nodes.containsKey(node.getRight())) {
			Node right = nodes.get(node.getRight());
			if (right.getLeft() != null) {
				traversePostOrderLeft(right);
			}
			if (right.getRight() != null) {
				traversePostOrderRight(right);
			}
			System.out.print(right.getEntity() + " ");
		}
	}
}
