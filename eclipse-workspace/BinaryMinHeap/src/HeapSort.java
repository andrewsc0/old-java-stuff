
public class HeapSort <Key extends Comparable<Key>, K>{

	Comparable[] list;
	  public void sort(Object[] list) {
		  this.list = (Comparable[]) list;
	        heapify(0);
	        int last = list.length-1;
	        while (last > 0){
	            swap(0,last);
	            last --;
	            percDown(0, last);
	        }
	    }

	    //n calls to percDown
	    //heapify O(nlog(n))
	    private void heapify(int root){
	        int max = list.length-1;
	        if (root >= max)
	            return;
	        heapify(2*root+1); //left
	        heapify(2*root+2); //right
	        percDown(root, max);
	    }

	    // O(log(n))
	    public void percDown(int root, int max){
	        int bc = biggerChild(root, max);
	        while(2*root+1 <= max && greater(bc,root)){
	            swap(root,bc);
	            root = bc;
	            bc = biggerChild(root, max);
	        }

	    }
	    private int biggerChild(int root, int max){
	        int left = 2*root+1;
	        int right = 2*root+2;
	        if ((right > max) || (greater(left,right))){
	            return left;
	        } else
	            return right;
	    }
	    private boolean greater(int greater, int lesser){
	        return (list[greater].compareTo( list[lesser]) < 0);
	    }

	    private void swap(int i, int j)
	    {
	        Comparable temp = (Comparable) list[i];
	        list[i] = list[j];
	        list[j] = temp;
	    }
}
