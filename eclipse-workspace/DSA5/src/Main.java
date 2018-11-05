
import java.util.Random;
public class Main {
  public static void main(String[] args) {
	ABL list = new ABL();
	ABL l1,l2,l3,l4,l5,l6,l7,l8, l9;
	l1=list;
	l2=list;
	l3=list;
	l4=list;
	l5=list;
	l6=list;
	l7=list;
	l8=list;
	l9=list;
	Random ran = new Random();
	for(int i = 0; i < 5000; i++) {
	  Integer n = ran.nextInt(1000);
	  list.add(n);
	}

		
    final long tl1s = System.currentTimeMillis();
	bubbleSortTest(l1);
	final long tl1f = System.currentTimeMillis();
	System.out.println("BubbleSort: " + (tl1f-tl1s));
		
	final long tl2s = System.currentTimeMillis();
	bucketSortTest(list);
	final long tl2f = System.currentTimeMillis();
	System.out.println("BucketSort: "+(tl2f-tl2s));
	
	final long tl3s = System.currentTimeMillis();
	insertionSortTest(list);
	final long tl3f = System.currentTimeMillis();
	System.out.println("InsertionSort: "+(tl3f-tl3s));
	
	final long tl4s = System.currentTimeMillis();
	iterativeQuickSortTest(list);
	final long tl4f = System.currentTimeMillis();
	System.out.println("IterativeQuickSort: "+(tl4f-tl4s));
	
	final long tl5s = System.currentTimeMillis();
	mergeSortTest(list);
	final long tl5f = System.currentTimeMillis();
	System.out.println("MergeSort: "+(tl5f-tl5s));
		
	final long tl6s = System.currentTimeMillis();
	recursiveQuickSortTest(list);
	final long tl6f = System.currentTimeMillis();
	System.out.println("RecursiveQuickSort: "+(tl6f-tl6s));
	
	final long tl7s = System.currentTimeMillis();
	heapSortTest(list);
	final long tl7f = System.currentTimeMillis();
	System.out.println("HeapSort: "+(tl7f-tl7s));
		
	final long tl8s = System.currentTimeMillis();
	radixSortTest(list);
	final long tl8f = System.currentTimeMillis();
	System.out.println("RadixSort: "+(tl8f-tl8s));
	
	final long tl9s = System.currentTimeMillis();
	treeSortTest(list);
	final long tl9f = System.currentTimeMillis();
	System.out.println("TreeSort: " + (tl9f-tl9s));
	/*	for(int k= 0; k <list.size();k++) {
			
			System.out.println(k + " " + list.get(k));
		}
		*/
	System.out.println();
	System.out.println("String");
  }
  public static void bubbleSortTest(ABL list) {		
	list.bubbleSort();	
  }	
  public static void bucketSortTest(ABL list) {	
	list.BucketSort(list.size()-1);	
  }	
  public static void insertionSortTest(ABL list) { 	
    list.InsertionSort();	
  }	
  public static void iterativeQuickSortTest(ABL list) {	
	list.quicksortI(0, list.size()-1);	
  }	
  public static void mergeSortTest(ABL list) {		
	list.mergeSort(0, list.size()-1);	
  }	
  public static void recursiveQuickSortTest(ABL list) {		
	list.quicksort(0, list.size()-1);
  }	
  public static void heapSortTest(ABL list) {		
    list.HeapSort();		
  }	
  public static void radixSortTest(ABL list) {		
	list.radixsort();
  }
  public static void treeSortTest(ABL list) {
	list.treeSort();
  }
}
