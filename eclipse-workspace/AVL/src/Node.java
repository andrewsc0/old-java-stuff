

/**
 * 
 * @author andrewsc0
 *
 * 
 * 
/**
 * 
 * @author andrewsc0
 *
 * 
 * 
 */
public class Node

{

	// reference to the next node in the chain,

	// or null if there isn't one.

  Node parent;

  Node right;

  Node left;
	
  int height;

	// data carried by this node.

	// could be of any type you need.

  Comparable data;

	// Node constructor

  public Node(Comparable _data, Node parent){

    this.parent = parent;

	right = null;

	left = null;

	data = _data;
		
	height = 0;

	}

	// another Node constructor if we want to

	// specify the node to point to.

  public Node(Comparable _data, Node parent, Node _right, Node _left) {

	this.parent = parent;

	right = _right;

	left = _left;

	data = _data;

	height = 0;
		
	}

	// these methods should be self-explanatory

  public Comparable getData(){

	return data;

  }

  public void setData(Comparable _data){

	data = _data;

  }
	
  public void getsetData(Node n){
		
	data = n.getData();
		
	}

  public Node getRight(){

	return right;

	}

  public void setRight(Node _next){

	right = _next;

	}

  public Node getLeft(){

	return left;

  }

  public void setleft(Node _next){

	left = _next;

  }

  public Node getParent(){

	return parent;

  }

  public void setParent(Node parent) {

	this.parent = parent;

  }
	
  public int getHeight1(){
		
	return height;
		
  }
	
  public void setHeight(int height){
		
	height = height + this.height;
		
   }
	
  public int balance(){
		
	int balance;
		
	  if(this.getLeft()!=null && this.getRight()!=null){
			
		balance = this.getLeft().getHeight1() + this.getRight().getHeight1();
			
		} else if((this.getLeft()==null && this.getRight()!=null)||(this.getLeft()!=null && this.getRight()==null)){
			
		balance = 1;
			
		} else{
			
		balance = 0;
			
		}
		
		return balance;
  }

  public int getHeight() {
		// TODO Auto-generated method stub
	return 0;
  }

}