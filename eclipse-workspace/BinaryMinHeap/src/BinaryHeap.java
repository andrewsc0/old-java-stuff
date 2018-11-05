/*
 * used an ABL class I made in DSA that implements a MyList interface 
 * with the rules of the ABL class
 */
public class BinaryHeap<Key extends Comparable<Key>, K> {

	Comparable[] heap, list;
	int pos, size;
	
	public BinaryHeap()
	{
		heap = new Comparable[15];
		pos = 0;
		size = 0;
	}
		
	public void insert(Comparable key) 
	{
		if(size == heap.length) {
			;;
		} else {
			size++;
			heap[size-1] = key;
			shiftUp(size-1);
		}
	}
	/*
	 * http://www.algolist.net/Data_structures/Binary_heap/Insertion
	 */
	private void shiftUp(int index)
	{
		int parIndex = 0;
		Comparable	temp;
		if(index != 0)
			parIndex = parIndex(index);
			if((((Comparable<Key>) heap[parIndex]).compareTo((Key) heap[index]))>0) {
				temp = (Comparable) heap[parIndex];
				heap[parIndex] = heap[index];
				heap[index] = temp;
				shiftUp(parIndex);
			}
	}
	
	private void shiftDown(int index)
	{
		int leftChildIndex, rightChildIndex, minIndex;
		Comparable temp;
		leftChildIndex = leftChildIndex(index);
		rightChildIndex = rightChildIndex(index);
		if(rightChildIndex >= size)
		{
			if(leftChildIndex >= size) 
				return;
			else
				minIndex = leftChildIndex;
		} else {
			if( ((Comparable<Key>) heap[leftChildIndex]).compareTo( (Key) heap[rightChildIndex]) <= 0)
				minIndex = leftChildIndex;
			else
				minIndex = rightChildIndex;
		}
		if( ((Comparable<Key>) heap[index]).compareTo( (Key) heap[minIndex]) > 0)
		{
			temp = (Comparable) heap[minIndex];
			heap[minIndex] = heap[index];
			heap[index] = temp;
			shiftDown(minIndex);
		}
	}

	public Key deleteMin() 
	{
		Key k = (Key) heap[0];
			if(heap.length!=0)
			{
			heap[0] = heap[size-1];
			size--;
				if(size > 0)
				{
					shiftDown(0);
				}
			}
		return k;
	}
	/*
	public Comparable[] heapSort()
	{
		Comparable[] k = new Comparable[size];
		int i = 0;
		while(heap.length!=0)
		{
			k[i] = deleteMin();
			i++;
		}
		return k;
	}
*/
	
	
	public boolean remove(Object key) {
				return false;
	}

	public void union(BinaryHeap heap2) {
				
	}
	
	public Comparable leftChild(int currIndex)
	{
		return (Comparable) heap[2*currIndex+1];
	}
	
	public Comparable rightChild(int currIndex)
	{
		return (Comparable) heap[2*currIndex+2];
	}
	
	public Comparable parent(int currIndex)
	{
		return (Comparable) heap[(currIndex-1)/2];
	}
	
	private int leftChildIndex(int currIndex)
	{
		return ((2*currIndex) + 1);
	}
	
	private int rightChildIndex(int currIndex)
	{
		return ((2*currIndex) + 2);
	}
	
	private int parIndex(int currIndex)
	{
		return ((currIndex - 1)/2);
	}
	
	public void getData()
	{
		for(int i = 0 ; i < size ; i++)
		{
			if(heap[i]==null) {
				return;
			} else {
				System.out.print("{" + i +"}" + " " + heap[i] + " ");
			}
		}
	}

}
