package graph;

public class Node {

	private String entity;
	private String left;
	private String right;
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	
	@Override
	public boolean equals(Object node) {
		if (!(node instanceof Node)) {
			return false;
		}
		return this.entity.equals(((Node)node).getEntity());
	}
}
