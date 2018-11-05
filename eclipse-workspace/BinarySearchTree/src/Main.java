import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		BSTree t = new BSTree();
		Node root = new Node(9);
		t.Insert(8);
		t.Insert(10);
		t.Insert(9);
		
		for(int i = 0 ; i < 15 ; i++)
		{
			t.Insert(ran.nextInt(300));
		}
		
		t.Insert(90);
		t.Insert(5);
		System.out.println(t.contains(10));
		System.out.println(t.search(65));
		System.out.println("in order");
		t.inOrder(t.root);
		System.out.println();
		System.out.println("pre order");
		t.preOrder(t.root);
		System.out.println();
		System.out.println("post order");
		t.postOrder(t.root);
	}

}
