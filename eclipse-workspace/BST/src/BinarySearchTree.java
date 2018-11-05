
public class BinarySearchTree<Key extends Comparable<Key>> {

	Node root;
	BinarySearchTree tree = this;
	
	BinarySearchTree(Node root){

		this.root = root;
		
	}
	
	BinarySearchTree(){
		
		root = null;
		
	}
	
	public boolean contains(Key key) {
		
		return false;
		
	}
	
}