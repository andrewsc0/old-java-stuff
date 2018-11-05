

import java.util.*;

public class ABL implements MyList {

	Object[] abl;
	Object[] mergeHelp;
	int range;

	/*
	 * Creates a new Object of type ABL
	 * sets the range = 0 because it is empty
	 * creates a new Object array to store the elements
	 * 
	 */
	public ABL() {

		range = 0;
		abl = new Object[range];

	}
	
	public ABL(Object[] arr) {
		range = arr.length;
		abl = helper(arr);
		
		
	}
	
	private Object[] helper(Object[] arr) {
		
		ABL list = new ABL();
		
		for(int i = 0; i<range; i++) {
			
			list.add(i, arr[i]);
			
		}
		
		return list.toArray();
		
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#add(int, java.lang.Object)
	 * this function takes
	 * @param of the index wanted to add the object two
	 * @param takes the object being stored
	 * @return boolean based on if it was added or not
	 */
	@Override
	public boolean add(int index, Object value) {
		if (range == abl.length){
			alloc();
		}
		for (int i = range; i > index; i--) {
			abl[i] = abl[i - 1];
		}
		abl[index] = value;
		range++;
		return true;
	}

	/*
	 * this function makes room in the array
	 */
	private void alloc() {
		Object[] temp = (Object[]) new Object[2 * abl.length];
		for (int i = 0; i < abl.length; i++)
			temp[i] = abl[i];
		abl = temp;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		build.append("[");
		for (int i = 0; i < range; i++) {
			build.append(abl[i]);
			if (i == range - 1){
				;
			}else{
				build.append(", ");
			}
		}
		build.append("]");

		return build.toString();

	}

	/*
	 * (non-Javadoc)
	 * @see MyList#add(java.lang.Object)
	 * @param of an object, the one that is being added
	 * @return boolean if added or not
	 */
	
	@Override
	public boolean add(Object o) {
		// TODO Auto-generated method stub
		int tempR = range;
		range++;
		Object[] temp = new Object[range];
		for (int index = 0; index < (range - 1); index++) {

			temp[index] = abl[index];

		}
		temp[tempR] = o;
		abl = temp;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#clear()
	 * empties the array
	 */
	@Override
	public boolean clear() {
		range = 0;
		abl = new Object[range];
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#contains(java.lang.Object)
	 * @param is an object which is being searched for
	 * uses sequential search to find the specified object
	 * @return a boolean based on whether the object was found or not
	 */
	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < range; i++) {

			if (abl[i].equals(o)) {
				return true;

			}

		}
		return false;
	}
 
	/*
	 * (non-Javadoc)
	 * @see MyList#get(int)
	 * @param the index where we are getting the element
	 * @return the object that is being 'got'
	 */
	@Override
	public Object get(int index) {
		if (index > range) {

			return abl[index];
		}
		return abl[index];

	}

	/*
	 * (non-Javadoc)
	 * @see MyList#indexOf(java.lang.Object)
	 * loops through the array to find the object
	 * @param the object
	 * @return the objects position on the list
	 */
	@Override
	public int indexOf(Object o) {
		for (int i = 0; i < range; i++) {

			if (abl[i].equals(o)) {
				return i;

			}

		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#isEmpty()
	 * checks to see if the array is empty
	 * @return a boolean based on what is found
	 */
	@Override
	public boolean isEmpty() {

		if (range == 0) {

			return true;

		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#remove(int)
	 * @param the index from which we are removing the element
	 * @return the list with a new range where it is equal to the previous range - 1
	 */
	@Override
	public Object remove(int index) {
		range--;
		Object[] temp = new Object[range];
		if (index > 1 && index < temp.length + 1) {
			for (int i = 0; range > i; i++) {

				if (i == index) {

				} else {

					temp[i] = abl[i];

				}

			}
			abl = new Object[range];
			abl = temp;
			return abl;

		} else {

			System.out.println("exception");
			return abl;

		}
	}
	/*
	 * (non-Javadoc)
	 * @see MyList#remove(java.lang.Object)
	 * similar to the previous method, except that it 
	 * compares the object, rather the index
	 * @return the new array
	 */
	@Override
	public Object remove(Object o) {
		range--;
		Object[] temp = new Object[range];
		for (int i = 0; range > i; i++) {

			if (o.equals(abl[i])) {

			} else {

				temp[i] = abl[i];

			}

		}
		abl = new Object[range];
		abl = temp;
		return abl;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#set(int, java.lang.Object)
	 * @param the index where we are setting
	 * @param the object that is being set
	 * @returns true if that is a valid index, false if not
	 */
	@Override
	public boolean set(int index, Object o) {
		if (index > 1 && index < range) {

			abl[index] = o;
			return true;

		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#size()
	 * @return how many elements are in the array
	 */
	@Override
	public int size() {

		return range;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#subList(int, int)
	 * @param the lower bound
	 * @param the upper bound
	 * @return the new sublist from with the size of toindex-fromIndex
	 */
	@Override
	public Object[] subList(int fromIndex, int toIndex) {
		int tempsize = fromIndex - toIndex;
		int start = fromIndex;
		Object[] temp = new Object[tempsize];

		for (int i = 0; i < tempsize; i++) {

			temp[i] = abl[start];
			start++;

		}
		return temp;
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#toArray()
	 * @returns an array of the elements from the list
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] rtrnArr = new Object[range];
		for (int i = 0; i < range; i++) {
			rtrnArr[i] = abl[i];
		}

		return rtrnArr;

	}

	/*
	 * (non-Javadoc)
	 * @see MyList#swap(int, int)
	 * swaps two elements in the list
	 * @param the index of one of the elements
	 * @param the index of the other element
	 * @return true or false based on if it succeeded or not
	 */
	@Override
	public boolean swap(int position1, int position2) {
		if (position1 < range && position1 > 0) {
			if (position2 < range && position2 > 0) {

				Object pos1 = abl[position1];
				Object pos2 = abl[position2];
				abl[position1] = pos2;
				abl[position2] = pos1;
				return true;
			} else {

				return false;

			}

		}
		return false;
	}
	

	private void swap(Object[] arr, int i, int j) {
		
		int temp = (int)arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
				
	}

	/*
	 * (non-Javadoc)
	 * @see MyList#shift(int)
	 * @param the number of spaces we are shifting 
	 * @return true or false based on success
	 */
	@Override
	public boolean shift(int positions) {
		int pos = Math.abs(positions);
		int newRange;
		if (positions > 0) {
			newRange = range + positions;
			Object[] newArr = new Object[newRange];
			for (int i = positions - 1; i < newRange; i++) {
				int count = 0;

				newArr[count + i] = abl[count];
				count++;

			}
			if (positions < 0) {

				newRange = range + Math.abs(positions);
				for (int i = pos - 1; i < newRange; i++) {
					int count = 0;

					newArr[count - i] = abl[count];
					count++;
				}

			}

		}
		return true;
	}
	
	public void InsertionSort(){
		for(int i = 1; i < range; i++){
			boolean done = false;
			Comparable x = (Comparable) abl[i]; 
			int p = i-1; 
			while(p >= 0 && !done){
				if(x.compareTo(abl[p]) >= 0){
					done = true;
				}else{
					p = p-1;
				}
			}
			p = p + 1;
			for(int j = i-1; j >= p;j--){
				abl[j+1] = abl[j];
			}
			abl[p] = x;
		}
				
	}

	public void BucketSort(int  n){
		Object[] array = abl;
		int bucketSize = array.length/n;
	        // Determine minimum and maximum values
	        Integer minValue = (Integer) array[0];
	        Integer maxValue = (Integer) array[0];
	        for (int i = 1; i < array.length; i++) {
	            if ((Integer) array[i] < minValue) {
	                minValue = (Integer) array[i];
	            } else if ((Integer) array[i] > maxValue) {
	                maxValue = (Integer) array[i];
	            }
	        }

	        // Initialise buckets
	        int bucketCount = (maxValue - minValue) / bucketSize + 1;
	        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
	        for (int i = 0; i < bucketCount; i++) {
	            buckets.add(new ArrayList<Integer>());
	        }

	        // Distribute input array values into buckets
	        for (int i = 0; i < array.length; i++) {
	            buckets.get(((Integer) array[i] - minValue) / bucketSize).add((Integer) array[i]);
	        }

	        // Sort buckets and place back into input array
	        int currentIndex = 0;
	        for (int i = 0; i < buckets.size(); i++) {
	            Integer[] bucketArray = new Integer[buckets.get(i).size()];
	            bucketArray = buckets.get(i).toArray(bucketArray);
	    		for(int k = 1; k < bucketArray.length; k++){
	    			boolean done = false;
	    			Comparable x = (Comparable) bucketArray[k]; 
	    			int p = k-1; 
	    			while(p >= 0 && !done){
	    				if(x.compareTo(bucketArray[p]) >= 0){
	    					done = true;
	    				}else{
	    					p = p-1;
	    				}
	    			}
	    			p = p + 1;
	    			for(int j = k-1; j >= p;j--){
	    				bucketArray[j+1] = bucketArray[j];
	    			}
	    			bucketArray[p] = (Integer) x;
	    		}
	    				
	            for (int j = 0; j < bucketArray.length; j++) {
	                array[currentIndex++] = bucketArray[j];
	            }
	        }
	    }
	
	public void bubbleSort() {
		Object[] array = abl;
		int j;
		boolean flag= true;
		int temp;
		while(flag) {
			flag=false;
			for(j=0;j<array.length-1;j++) {
				if((int)array[j]>(int)array[j+1]) {
					temp=(int)array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
					flag=true;
				}
			}
		}
		
	}
	

	
	public void quicksort(int low, int hi) {
		Object[] a = abl;
		{
		    if(low>=hi)
		    {
		        return;
		    }
		    int split = partition(a, low, hi);
		    quicksort(low, split-1);
		    quicksort(split+1, hi);
		}
	}
	private int findNextR(Object[] arr, final int l, final int size) {
		
		for(int i = 0;i <size; ++i) {
			
			if((int)arr[i]<0) {
				return i;
				
			}
		
		}
		
		return size-1;
		
	}
	
	/*
	 * http://kosbie.net/cmu/summer-08/15-100/handouts/IterativeQuickSort.java
	 */
	
	   public void iterativeQuicksort() {
		   Object[] a = abl;
		      int[] range = new int[a.length+1]; // if (range[i]<0) then skip[i] = |range[i]|
		      range[0] = a.length-1;
		      int i, j, sortedCount = 0;
		      while (sortedCount < a.length) {
		        for (i=0; i<a.length; i++)
		          if (range[i] >= i) {
		            j = range[i];
		            if (j-i < 7) {
		              // selectionsort the elements from a[i] to a[j] inclusive
		              // and set all their ranges to -((j+1)-k)
		              for (int m=i; m<=j; m++) {
		                for (int n=m; n>i && (int) a[n-1]> (int) a[n]; n--)
		                  swap(n, n-1);
		                range[m] = -((j+1)-m);
		                sortedCount++;
		              }
		              i = j;
		            }
		            else {
		              for ( ; i<=j; i++) {
		                int p = partition(a,i,j);
		                sortedCount++;
		                if (p > i) range[i] = p-1;
		                if (p < j) range[p+1] = j;
		                range[i = p] = -1; // sorted
		              }
		            }
		          }
		          else {
		            // skip[i] += skip[i + skip[i]];
		            while ((j = range[i-range[i]]) < 0) range[i] += j;
		            i += -range[i]-1;
		          }
		      }
		   }
	
	private int randomPivot(int left, int right) {
		
		return left+ (int) Math.floor(Math.random()*(right-left+1));
		
	}
	
	private int partition(Object a[], int low, int hi) {
		
		  int pivot = hi;
		    int i =low;
		    int j = hi;
		    while(i<j)
		    {
		        if((int)a[i]<=(int)a[pivot])
		        {
		            i++;
		        }
		        if((int)a[i]>(int)a[pivot])
		        {   
		        if(((int)a[i]>(int)a[pivot]) && ((int)a[j]<=(int)a[pivot]))
		        {
		            int temp= (int) a[i];
		            a[i]=a[j];
		            a[j]=temp;
		            i++;    
		        }
		        if((int)a[j]>(int)a[pivot])
		        {
		            j--;
		        }
		        }
		    }
		    int temp= (int) a[i];
		    a[i]=a[pivot];
		    a[pivot]=temp;
		    return i;
	}
	
	
	public void mergeSort(int low, int high) {
		
		mergeHelp = new Object[range];
		if(low<high) {
			
			int middle = low + (high-low)/2;
			mergeSort(low, middle);
			mergeSort(middle+1,high);
			merge(low, middle, high);
		}
		
	}
	
	private void merge(int low, int middle, int high) {
	
		Object[] array = abl;
		
		for(int i = low; i<=high; i++) {
			
			mergeHelp[i]= array[i];
			
		}
		
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i<=middle&j<=high) {
			
			if((int) mergeHelp[i]<= (int) mergeHelp[j]) {
				
				array[k]= mergeHelp[i];
				
				i++;
			} else {
				
				array[k]= mergeHelp[j];
				j++;
				
			}
			k++;
			
		}
		
		while(i<=middle) {
			
			array[k]=mergeHelp[i];
			k++;
			i++;
		}
	}
	
	/*public void treeSort() {
		
		Object[] array = abl;
		AVL tree = new AVL();
		AVLOperator oper = new AVLOperator();
		Node node = new Node((Comparable) array[0], null);
		tree.setRoot(node);
		for(int i = 1; i < array.length; i++) {
			
			oper.insert(tree, (Comparable) array[i]);
			
		}
		
		Object[] newL = new Object[range];
		
		int k = 0;
		while(k<range) {
			
			Comparable compare = tree.minInTree().getData();
			newL[k] = compare;
			k++;
			
		}
		
		abl = newL;
		
	}
	
	
	public void treeSort() {
		
		Object[] array = abl;
		
		AVL tree = new AVL();
		
		AVLOperator oper = new AVLOperator();
		
		for(int i = 0; i < array.length; i++) {
			
			oper.insert(tree, (Comparable) array[i]);
			
		}
		
		Node node = tree.getRoot();
	   array[0]=tree.getRoot().getData();

	    if (node != null) {

	      oper.printTree(node.getLeft());

	      System.out.print(node.data +" ");

	      oper.printTree(node.getRight());

	        }

			
			
			
		}
		*/
	}












