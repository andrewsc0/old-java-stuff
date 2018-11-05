public class ABL implements MyList {

  Object[] abl;
  int range;

	/*
	 * Creates a new Object of type ABL sets the range = 0 because it is empty
	 * creates a new Object array to store the elements
	 * 
	 */
  public ABL() {

	range = 0;
	abl = new Object[range];

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see MyList#add(int, java.lang.Object) this function takes
	 * 
	 * @param of the index wanted to add the object two
	 * 
	 * @param takes the object being stored
	 * 
	 * @return boolean based on if it was added or not
	 */
	@Override
  public boolean add(int index, Object value) {
		
    if (range == abl.length) {
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
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
  public String toString() {
	StringBuilder build = new StringBuilder();
	
	build.append("[");
	
	for (int i = 0; i < range; i++) {
			
	  build.append(abl[i]);
	  
		if (i == range - 1) {
			
				;
				
		} else {
			
				build.append(", ");
		}
	 
	}
	
		build.append("]");

		return build.toString();

  }

	/*
	 * (non-Javadoc)
	 * 
	 * @see MyList#add(java.lang.Object)
	 * 
	 * @param of an object, the one that is being added
	 * 
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
	 * 
	 * @see MyList#clear() empties the array
	 */
	@Override
  public boolean clear() {
		
	range = 0;
	
	abl = new Object[range];
		
	return true;
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see MyList#contains(java.lang.Object)
	 * 
	 * @param is an object which is being searched for uses sequential search to
	 * find the specified object
	 * 
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
	 * 
	 * @see MyList#get(int)
	 * 
	 * @param the index where we are getting the element
	 * 
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
	 * 
	 * @see MyList#indexOf(java.lang.Object) loops through the array to find the
	 * object
	 * 
	 * @param the object
	 * 
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
	 * 
	 * @see MyList#isEmpty() checks to see if the array is empty
	 * 
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
	 * 
	 * @see MyList#remove(int)
	 * 
	 * @param the index from which we are removing the element
	 * 
	 * @return the list with a new range where it is equal to the previous range
	 * - 1
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
	 * 
	 * @see MyList#remove(java.lang.Object) similar to the previous method,
	 * except that it compares the object, rather the index
	 * 
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
	 * 
	 * @see MyList#set(int, java.lang.Object)
	 * 
	 * @param the index where we are setting
	 * 
	 * @param the object that is being set
	 * 
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
	 * 
	 * @see MyList#size()
	 * 
	 * @return how many elements are in the array
	 */
	@Override
  public int size() {

	return range;
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see MyList#subList(int, int)
	 * 
	 * @param the lower bound
	 * 
	 * @param the upper bound
	 * 
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
	 * 
	 * @see MyList#toArray()
	 * 
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
	 * 
	 * @see MyList#swap(int, int) swaps two elements in the list
	 * 
	 * @param the index of one of the elements
	 * 
	 * @param the index of the other element
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see MyList#shift(int)
	 * 
	 * @param the number of spaces we are shifting
	 * 
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

}