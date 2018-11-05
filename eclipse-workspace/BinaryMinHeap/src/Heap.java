
public interface Heap <Key extends Comparable<Key>> {
	
	public void insert(Comparable key);
	public Comparable deleteMin();
	public boolean remove(Comparable key);
	public Comparable[] heapSort();
	public void union(Heap heap);

}
