package linkedlist;

public class LinkedListExample {
	public static void main(String[] args) {
		IntNodeSample small; 
		small = new IntNodeSample(42, null);
		small.addNodeAfter(17);
		System.out.println(IntNodeSample.listLength(small)); // prints 2
		
		//Use static in listLength method because static can be used for empty list
		IntNodeSample empty = null;
		System.out.println(IntNodeSample.listLength(empty)); // prints 0
		
		IntNodeSample shortlist;
		IntNodeSample copy;
		
		shortlist = new IntNodeSample(1, null);
		shortlist.addNodeAfter(2);
		shortlist.addNodeAfter(3);
		copy = IntNodeSample.listCopy(shortlist);
		
		IntNodeSample[] copyInfo;
		
		copyInfo = IntNodeSample.listCopyWithTail(shortlist);
		
	}
}
