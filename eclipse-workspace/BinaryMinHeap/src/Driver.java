import java.util.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		BinaryHeap heap = new BinaryHeap();
		Comparable[] arr = new Comparable[15];
		heap.insert(9);
		int i = 0;
		
		while(i < 15)
		{
			heap.insert(r.nextInt(100));
			arr[i] = r.nextInt(100);
			i++;
		}
		
		HeapSort sorter = new HeapSort();
		
		System.out.println("UnSorted: ");
		for(int k = 0; k < arr.length ; k++)
		{
			System.out.print( arr[k] + " ");
		}
		System.out.println();
		System.out.println();
//		heap.sort();
		sorter.sort(arr);
		System.out.println("Sorted: ");
		for(int k = 0; k < arr.length ; k++)
		{
			System.out.print( arr[k] + " ");
		}
		
		System.out.println();
		System.out.println();
		
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		heap.getData();
		heap.deleteMin();
		System.out.println("heap size: " + heap.size);
		
		System.out.println();
		
		
			
		
	}
	

}
