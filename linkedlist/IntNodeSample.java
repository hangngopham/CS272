package linkedlist;

public class IntNodeSample {
	private int data;
	private IntNodeSample link;

	public IntNodeSample(int initialData, IntNodeSample initialLink) {
		data = initialData;
		link = initialLink;
	}

	public int getData() {
		return data;
	}

	public IntNodeSample getLink() {
		return link;
	}

	public void setData(int newdata) {
		data = newdata;
	}

	public void setLink(IntNodeSample newLink) {
		link = newLink;
	}

	public void addNodeAfter(int element) {
		link = new IntNodeSample(element, link);
	}

	public void removeNodeAfter() {
		link = link.link;
	}

	public static int listLength(IntNodeSample head) {
		IntNodeSample cursor;
		int answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link) {
			answer++;
		}
		return answer;
	}

	/**
	 * Search for a particular piece of data in a linked list
	 * 
	 * @return a reference to the first node that contains the specified target.
	 *         If there is no such reference, the null reference is returned.
	 * @param head
	 * @param target
	 * @return
	 */
	public static IntNodeSample listSearch(IntNodeSample head, int target) {
		IntNodeSample cursor;
		for(cursor = head; cursor != null; cursor= cursor.link) {
			if(cursor.data == target) {
				return cursor;
			}
		}
		return null;
	}
	
	/**
	 * Finding a node at a specified position in a linked list
	 * @return 
	 * 
	 * @return the node at the specified position
	 */
	public static IntNodeSample listPosition(IntNodeSample head, int position) {
		IntNodeSample cursor;
		
		if(position <= 0) {
			throw new IllegalArgumentException("postiton is not positive");
		}
		
		cursor = head;
		for(int i = 1; (i <= position) && (cursor != null); i++) {
			cursor = cursor.link;
		}
		return cursor;
	}
	
	/**
	 * Copy a list
	 * 
	 * @return head reference for the copy
	 */
	public static IntNodeSample listCopy(IntNodeSample source) {
		IntNodeSample copyHead;
		IntNodeSample copyTail;
		
		if(source == null) {
			return null;
		}
		
		copyHead = new IntNodeSample(source.data, null);
		copyTail = copyHead;
		
		while(source.link != null) {
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		
		return copyHead;
	}
	
	/**
	 * Copy a list, returning both a head and tail reference for the copy
	 * 
	 * @return an array with ehad and tail reference
	 */
	public static IntNodeSample[] listCopyWithTail(IntNodeSample source) {
		IntNodeSample[] answer = new IntNodeSample[2];
		
		IntNodeSample copyHead;
		IntNodeSample copyTail;
		
		if(source == null) {
			return answer;
		}
		
		copyHead = new IntNodeSample(source.data, null);
		copyTail = copyHead;
		
		while(source.link != null) {
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		
		return answer;
		
	}
	
	/**
	 * Copy part of a list, providing a head and tail reference for the new copy
	 *
	 *@return an array for head and tail reference
	 */
	public static IntNodeSample[] listPart(IntNodeSample start, IntNodeSample end) {
		IntNodeSample[] answer = new IntNodeSample[2];
		
		IntNodeSample copyHead;
		IntNodeSample copyTail;
		
		if (start == null) {
			throw new IllegalArgumentException("start is null");
		} 
		if(end == null) {
			throw new IllegalArgumentException("end is nul");
		}
		
		copyHead = new IntNodeSample(start.data, null);
		copyTail = copyHead;
		
		while(start != end) {
			start = start.link;
			if(start == null) {
				throw new IllegalArgumentException("start is null");
			}
			copyTail.addNodeAfter(start.data);
			copyTail = copyTail.link;
		}
		
		answer[0] = copyHead;
		answer[1] = copyTail;
		
		return answer;
	}
	
}
