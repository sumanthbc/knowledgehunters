package graph;

public class GraphUtil {
	
	/**
	 *          A
	 *        /   \
	 *       Z     B
	 *     /     /   \
	 *    X     D     C
	 *      \
	 *       W
	 * @return
	 */

	public Graph generateGraphTree () {
		Graph graph = new Graph();
		Node a = new Node();
		a.setEntity("A");
		a.setLeft("Z");
		a.setRight("B");
		graph.addNode(a);
		Node b = new Node();
		b.setEntity("B");
		b.setLeft("D");
		b.setRight("C");
		graph.addNode(b);
		Node z = new Node();
		z.setEntity("Z");
		z.setLeft("X");
		graph.addNode(z);
		Node d = new Node();
		d.setEntity("D");
		graph.addNode(d);
		Node c = new Node();
		c.setEntity("C");
		graph.addNode(c);
		Node x = new Node();
		x.setEntity("X");
		x.setRight("W");
		graph.addNode(x);
		Node w = new Node();
		w.setEntity("W");
		graph.addNode(w);
		
		graph.setRoot(a);
		
		return graph;
	}
}
