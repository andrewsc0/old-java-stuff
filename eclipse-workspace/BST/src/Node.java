
public class Node {
	
	Node parent, right, left;
	Comparable data;
	
	public Node(Comparable data, Node parent) {
		
		this.parent = parent;
		right = null;
		left = null;
		this.data = data;
		
	}
	
	public Node(Comparable data, Node parent, Node right, Node left) {
		
		this.parent=parent;
		this.right = right;
		this.left = left;
		this.data = data;
		
	}
	
	public void setData(Comparable data) {
		
		this.data = data;
		
	}
	
	

}