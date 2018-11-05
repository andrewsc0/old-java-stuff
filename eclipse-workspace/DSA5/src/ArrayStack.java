
public class ArrayStack implements Stack {

  ABL stack;
  int range;
  int position;

  public ArrayStack() {

	stack = new ABL();
	range = stack.size();
	position = -1;

	}

	@Override
  public void push(Object o) {
		// TODO Auto-generated method stub
	stack.add(o);
	position++;
  }

	@Override
  public Object pop() {
		// TODO Auto-generated method stub
	Object o = null;
	if (!stack.isEmpty()) {
	  o = stack.get(position);
	  stack.remove(position);
	  position--;
	  range--;
	} else {
			// System.out.println("Stack is empty");
	}
	  return o;
  }

	@Override
  public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (range == 0){
		  return true;
		}
		else{
		  return false;
		}
  }

  public Object peek() {

	return stack.get(position);

  }

	/*
	 * private void alloc() { int nSize = 2*range; Object[] temp = (Object[])
	 * new Object[nSize]; for (int i = 0; i < stack.length; i++) temp[i] =
	 * stack[i]; stack = temp; range = nSize; }
	 */
  public int size() {

	return stack.size();

  }

	@Override
  public String toString() {
	StringBuilder build = new StringBuilder();
	build.append("[");
	for (int i = 0; i < range; i++) {
	  build.append(stack.get(i));
		if (i == range - 1) {
				;
		 } else {
			build.append(", ");
		 }
    }
	  build.append("]");

		return build.toString();

  }
}