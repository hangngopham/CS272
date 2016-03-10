package lab5;

public class DLinkTester {

	/**
	 * Swap two nodes x and y (not just their content). Change links in nodes x,
	 * y, and their neighbors. Data elements x and y do not change
	 * 
	 * Precondition: x and y are not null; previous of x, next of x, previous of
	 * y, next of y are not null
	 * 
	 * Postcondition: swap two nodes x and y. Return false if x and y are null,
	 * previous of x, next of x, previous of y, next of y are null. Otherwise
	 * (if any of these nodes are null), the method should not change anything
	 * and return false (the nodes are not swapped)
	 * 
	 * @param x-
	 *            node x
	 * @param y
	 *            - node y
	 * @return false if x and y are null, previous of x, next of x, previous of
	 *         y, next of y are null. Otherwise (if any of these nodes are
	 *         null), the method should not change anything and return false
	 *         (the nodes are not swapped)
	 * @return true if x and y are not null; previous of x, next of x, previous
	 *         of y, next of y are not null
	 */
	public static boolean swap(DNode x, DNode y) {
		DNode prevX = x.getPrev();
		DNode nextX = x.getNext();

		DNode prevY = y.getPrev();
		DNode nextY = y.getNext();

		if (x.getElement() == null || y.getElement() == null || prevX.getElement() == null || nextX.getElement() == null
				|| prevY.getElement() == null || nextY.getElement() == null) {
			return false;
		} else if (nextX == y) { // if node x is previous node of node y
			y.setPrev(prevX);
			y.setNext(x);
			prevX.setNext(y);
			x.setPrev(y);
			x.setNext(nextY);
			nextY.setPrev(x);
			return true;
		} else if (nextY == x) { // if node x is the next node after node y
			x.setPrev(prevY);
			x.setNext(y);
			prevY.setNext(x);
			y.setPrev(x);
			y.setNext(nextX);
			nextX.setPrev(y);
			return true;
		} else if (x == y) { // x and y refer to the same node
			System.out.println("x and y refer to the same node");
			return true;
		} else { // node x and y are not next to each other
			prevX.setNext(y);
			y.setPrev(prevX);
			y.setNext(nextX);
			nextX.setPrev(y);

			prevY.setNext(x);
			x.setPrev(prevY);
			x.setNext(nextY);
			nextY.setPrev(x);
			return true;
		}
	}

	/**
	 * Concatenate two doubly linked list L and M, with head and tail dummy
	 * nodes, into a single doubly linked list N
	 * 
	 * Precondition: L or M is not empty Postcondition: Return list N, which is
	 * the concatenation of L and M
	 * 
	 * @param L
	 *            - a doubly linked list
	 * @param M
	 *            - a doubly linked list
	 * @return N - a single doubly linked list concatenated by L and M
	 */
	public static DList concat(DList L, DList M) {
		DList N = new DList();

		if (L.isEmpty() || M.isEmpty()) {
			return null;
		} else {
			DNode p1;
			DNode p2;

			while (!L.isEmpty()) {
				p1 = L.getFirst();
				L.remove(p1);
				N.addLast(p1);
			}

			while (!M.isEmpty()) {
				p2 = M.getFirst();
				M.remove(p2);
				N.addLast(p2);
			}
		}
		return N;
	}

	/**
	 * Reverse the order of elements in a given doubly linked list
	 * 
	 * Precondition: Do not create a new list, reverse the elements in the
	 * existing list. Do not allocate any new nodes. The method should not
	 * return anything. Postcondition: Reverse the order of the elements
	 * 
	 * @param list
	 *            - list which elements are to be reversed
	 */
	public static void reverse(DList list) {
		DNode head = list.getFirst();
		DNode last = list.getLast();

		DNode left = head;
		DNode right = last;
		DNode oldLast = list.getLast();
		DNode curr;
		int i = 0;
		while(i < list.size() - 1){
			curr = list.getFirst();
			list.remove(curr);
			list.addAfter(oldLast, curr);
			i += 1;
		}
	}

	/**
	 * Create a new doubly linked list N that contains elements alternately from
	 * two given doubly linked lists L and M. If you run out of elements in one
	 * of the lists, then append the remaining elements of the other list to N.
	 * If any one of the two lists is empty, then the method should return a
	 * copy of the second list
	 * 
	 * Precondition: L and M is not empty Postcondition: Return the list merged
	 * alternately by L and M
	 * 
	 * @param L
	 *            - list to be merged
	 * @param M
	 *            - list to be merged
	 */
	public static DList merge(DList L, DList M) {
		DList N = new DList();
		DNode cursor1;
		DNode cursor2;
		boolean isList1 = true;
		while (!L.isEmpty() && !M.isEmpty()) {
			if (isList1) {
				cursor1 = L.getFirst();
				L.remove(cursor1);
				N.addLast(cursor1);
			} else {
				cursor2 = M.getFirst();
				M.remove(cursor2);
				N.addLast(cursor2);
			}
			isList1 = !isList1;
		}

		while (!L.isEmpty()) {
			cursor1 = L.getFirst();
			L.remove(cursor1);
			N.addLast(cursor1);
		}

		while (!M.isEmpty()) {
			cursor2 = M.getFirst();
			M.remove(cursor2);
			N.addLast(cursor2);
		}
		return N;
	}

	public static void main(String[] args) {
		// Create a doubly linked list named list
		DList list = new DList();
		list.addFirst(new DNode("f", null, null));
		DNode head = list.getFirst();
		DNode node1 = new DNode("g", null, null);
		list.addAfter(head, node1);
		DNode node2 = new DNode("h", null, null);
		list.addAfter(node1, node2);
		DNode node3 = new DNode("i", null, null);
		list.addAfter(node2, node3);
		DNode node4 = new DNode("k", null, null);
		list.addAfter(node3, node4);
		DNode node05 = new DNode("1", null, null);
		list.addAfter(node4, node05);
		System.out.println("Before swap, list is: " + list.toString());
		// Test swap method
		System.out.println(swap(node1, node3));
		System.out.println("After swap (node1 and node3 are not next to each other), list is: " + list.toString());

		System.out.println(swap(node4, node05));
		System.out.println("After swap (node4 and node5 are next to each other), list is " + list.toString());

		System.out.println(swap(head, head));
		System.out.println("After swap (refer to the same node), list is " + list.toString());

		// Create a doubly linked list named list1
		DList list1 = new DList();
		list1.addFirst(new DNode("A", null, null));
		DNode head1 = list1.getFirst();
		DNode node11 = new DNode("B", null, null);
		list1.addAfter(head1, node11);
		DNode node12 = new DNode("C", null, null);
		list1.addAfter(node11, node12);

		// Create a doubly linked list named list2
		DList list2 = new DList();
		list2.addFirst(new DNode("1", null, null));
		DNode head2 = list2.getFirst();
		DNode node5 = new DNode("2", null, null);
		list2.addAfter(head2, node5);
		DNode node6 = new DNode("3", null, null);
		list2.addAfter(node5, node6);
		DNode node7 = new DNode("4", null, null);
		list2.addAfter(node6, node7);
		DNode node8 = new DNode("5", null, null);
		list2.addAfter(node7, node8);
		DNode node9 = new DNode("6", null, null);
		list2.addAfter(node8, node9);
		System.out.println("list1 is " + list1.toString());
		System.out.println("list2 is " + list2.toString());
		// Test concat method
		System.out.println("Concatenation of list1 and list2 is " + concat(list1, list2).toString());

		// Create a doubly linked list named list3
		DList list3 = new DList();
		list3.addFirst(new DNode("a", null, null));
		DNode head3 = list3.getFirst();
		DNode node13 = new DNode("b", null, null);
		list3.addAfter(head3, node13);
		DNode node23 = new DNode("c", null, null);
		list3.addAfter(node13, node23);

		// Create a doubly linked list named list4
		DList list4 = new DList();
		list4.addFirst(new DNode("11", null, null));
		DNode head4 = list4.getFirst();
		DNode node14 = new DNode("21", null, null);
		list4.addAfter(head4, node14);
		DNode node24 = new DNode("31", null, null);
		list4.addAfter(node14, node24);

		System.out.println("list3 is " + list3.toString());
		System.out.println("list4 is " + list4.toString());
		// Test merge method
		System.out.println("Merge of list3 and list4 is " + merge(list3, list4).toString());

		// Create a doubly linked list named list5
		DList list5 = new DList();
		list5.addFirst(new DNode("10", null, null));
		DNode head5 = list5.getFirst();
		DNode node15 = new DNode("20", null, null);
		list5.addAfter(head5, node15);
		DNode node25 = new DNode("30", null, null);
		list5.addAfter(node15, node25);
		DNode node35 = new DNode("40", null, null);
		list5.addAfter(node25, node35);
		DNode node45 = new DNode("50", null, null);
		list5.addAfter(node35, node45);
		DNode node55 = new DNode("60", null, null);
		list5.addAfter(node45, node55);
		
		System.out.println("Before reverse, list5 is " + list5.toString());
		reverse(list5);
		System.out.println("Reverse of list5 is " + list5.toString());

	}
}
