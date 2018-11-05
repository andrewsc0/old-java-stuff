import java.util.ArrayList;

public class BSTree {
	
	Node root;
	
	BSTree()
	{
		
	}
	
	BSTree(Node root)
	{
		this.root = root;
	}
	
	void Insert(Comparable value)
	{
		if(root == null)
			this.root = new Node(value);
		else
			this.root = insert(this.root, value);
	}

	 private Node insert(Node node, Comparable value) 
	 {
		 if(node == null) {
		        return new Node(value);
		    } else if(node.data.compareTo(value) < 0) {
		        node.right = insert(node.right, value);
		    } else if(node.data.compareTo(value) > 0) {
		        node.left = insert(node.left, value);
		    }
		    return node;
	 }
	 
	 public void delete(Comparable value)
	 {
		this.root = delete(this.root, value);
	 }
	 
	 public Node delete(Node node, Comparable value) {
		    if(node.data.compareTo(value) < 0) {
		        node.right = delete(node.right, value);
		    } else if(node.data.compareTo(value) > 0) {
		        node.left = delete(node.left, value);
		    } else {
		        if(node.right == null) {
		            return node.left;
		        }
		        if(node.left == null) {
		            return node.right;
		        }
		        Node temp = node;
		        node = min(temp.right);
		        node.right = deleteMin(temp.right);
		        node.left = temp.left;
		    }
		    return node;
		}
	 Boolean contains(Comparable k)
	 {
		 Node currNode = root;
		 Node toFind = new Node(k);
		 Boolean found = false;
		 while(currNode!=null && found!=true)
		 {
			 if(currNode.data.compareTo(toFind.data)== 0)
			 {
				 found = true;
				 break;
			 }
			 else if (currNode.data.compareTo(toFind.data) > 0)
			 {
				 currNode = currNode.right;
			 }
			 else
			 {
				 currNode = currNode.left;
			 }
		 }
			 
		 
		 return found;
	 }
	 
	 public boolean search(Comparable val) 
	    {
	        return search(root, val);
	    }
	 
	    /* Function to search for an element recursively */
	    private boolean search(Node r, Comparable val) 
	    {
	        boolean found = false;
	        while ((r != null) && !found) 
	        {
	            Comparable rval = r.data;
	            if (val.compareTo(rval) < 0)
	                r = r.left;
	            else if (val.compareTo(rval) > 0)
	                r = r.right;
	            else 
	            {
	                found = true;
	                break;
	            }
	            found = search(r, val);
	        }
	        return found;
	    }

	      public void inOrder(Node node) {

	        ArrayList<Node> list = new ArrayList<Node>();

	        list.add(node);

	        if (node != null) {

	          inOrder(node.left);

	          System.out.print(node.data +" ");

	          inOrder(node.getRight());

	         }

	   //     return list;

	      }
	      
	      public void postOrder(Node node)
	      {
	    	  ArrayList<Node> polist = new ArrayList<Node>();
	    	  polist.add(node);
	    	  if(node!=null) {
	    		  postOrder(node.left);
	    	  	  postOrder(node.right);
	    	  	  System.out.print(node.data + " ");
	    	  } else {
	    		  return;
	    	  }
	    	/*  
	    	  for(int i = 0; i < polist.size(); i++)
	    	  {
	    		  System.out.println(polist.get(i) + " ");
	    	  }
	    	  
	    	  */
	      }
	      
	      public void preOrder(Node node)
	      {
	    	  if (node!=null)
	    	  {
	    		  System.out.print(node.data + " ");
	    		  preOrder(node.left);
	    		  preOrder(node.right);
	    	  }
	      }
	      
	      private Node min(Node node)
	      {
	    	  if(node.left != null)
	    	  {
	    		  return min(node.left);
	    	  } else
	    	  {
	    		  return node;
	    	  }
	      }
	      
	      private Node deleteMin(Node node)
	      {
	    	  if(node.left == null)
	    	  {
	    		  return node.right;
	    	  }
	    	  node.left = deleteMin(node.left);
	    	  return node;
	      }
}


