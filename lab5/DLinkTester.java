package lab5;

public class DLinkTester {

	public static boolean swap(DNode x, DNode y) {
		DNode prevX = x.getPrev();
		DNode nextX = x.getNext();

		DNode prevY = y.getPrev();
		DNode nextY = y.getNext();

		if (x.getElement() == null && y.getElement() == null
				&& prevX.getElement() == null && nextX.getElement() == null
				&& prevY.getElement() == null && nextY.getElement() == null) {
			return false;
		} else if (nextX == y) {
			y.setPrev(prevX);
			y.setNext(x);
			prevX.setNext(y);
			x.setPrev(y);
			x.setNext(nextY);
			nextY.setPrev(x);
			return true;
		} else if (nextY == x) {
			x.setPrev(prevY);
			x.setNext(y);
			prevY.setNext(x);
			y.setPrev(x);
			y.setNext(nextX);
			nextX.setPrev(y);
			return true;
		} else if (x == y) {
			System.out.println("x and y refer to the same node");
			return true;
		} else {
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
			DNode headL = L.getFirst();
			DNode cursor = headL;
			while (cursor != null) {
				cursor = cursor.getNext();
			}
			N.addFirst(headL);

			DNode headM = M.getFirst();
			DNode cursor2 = headM;
			while (cursor2 != null) {
				cursor2 = cursor2.getNext();
			}
			cursor.setNext(headM);
			headM.setPrev(cursor);

			return N;
		}
	}

	/**
	 * Reverse the order of elements in a given doubly linked list
	 * 
	 * @param list
	 *            - list which elements are to be reversed
	 */
	public static void reverse(DList list) {

		DNode head = list.getFirst();
		DNode last = list.getLast();

		DNode left = head;
		DNode right = last;

		for (int i = 0; i < list.size() / 2; i++) {
			swap(left, right);
			left = left.getNext();
			right = right.getPrev();
		}
	}

	/**
	 * Create a new doubly linked list N that contains elements alternately from
	 * two given doubly linked lists L and M. If you run out of elements in one
	 * of the lists, then append the remaining elements of the other list to N.
	 * If any one of the two lists is empty, then the method should return a
	 * copy of the second list
	 * 
	 * @param L
	 *            - list to be merged
	 * @param M
	 *            - list to be merged
	 */
	public static DList merge(DList L, DList M) {
		DList N = new DList();
		DNode head1 = L.getFirst();
		DNode cursor1 = head1;
		DNode head2 = M.getFirst();
		DNode cursor2 = head2;

		while (cursor1 != null && cursor2 != null && cursor1.getNext() != null
				&& cursor2.getNext() == null) {
			DNode next1 = cursor1.getNext();
			DNode next2 = cursor2.getNext();

			cursor1.setNext(cursor2);
			cursor2.setPrev(cursor1);
			cursor2.setNext(next1);
			next1.setPrev(cursor2);

			cursor1 = next1;
			cursor2 = next2;
		}

		if (cursor1.getNext() == null) {
			cursor1.setNext(cursor2);
			cursor2.setPrev(cursor1);
		}

		if (cursor2.getNext() == null) {
			cursor1.setNext(cursor2);
			cursor2.setPrev(cursor1);
		}

		DNode headN = head1;
		N.addAfter(headN, head1.getNext());
		return N;
	}

	public static void main(String[] args) {
		// Create a doubly linked list named list
		DList list = new DList();
		list.addFirst(new DNode("A", null, null));
		DNode head = list.getFirst();
		DNode node1 = new DNode("B", null, null);
		list.addAfter(head, node1);
		DNode node2 = new DNode("C", null, null);
		list.addAfter(node1, node2);
		DNode node3 = new DNode("D", null, null);
		list.addAfter(node2, node3);
		DNode node4 = new DNode("E", null, null);
		list.addAfter(node3, node4);

		DList list2 = new DList();
		list2.addFirst(new DNode("G", null, null));
		DNode head2 = list2.getFirst();
		DNode node5 = new DNode("A", null, null);
		list2.addAfter(head2, node5);
		DNode node6 = new DNode("C", null, null);
		list2.addAfter(node5, node6);
		DNode node7 = new DNode("D", null, null);
		list2.addAfter(node6, node7);
		DNode node8 = new DNode("E", null, null);
		list2.addAfter(node7, node8);

		// swap(head, node4);
		System.out.println("list is " + list.toString());
		//reverse(list);
		//System.out.println(list.toString());
		System.out.println("list2 is " + list2.toString());
		System.out.println(merge(list, list2).toString());
		//DList newList = concat(list, list2);
		//System.out.println(newList.toString());
	}
}
