package lab5;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class DLinkTesterTest {

	public DList setup(List<String> elements){
		DList l = new DList();
		for(String element : elements){
			l.addLast(new DNode(element, null, null));
		}
		return l;
	}
	
	@Test
	public void testswap() {
		// setup test
		DList l1 = setup(Arrays.asList("A", "B", "C", "D" ));
		DNode node1 = l1.getFirst().getNext();
		DNode node2 = l1.getFirst().getNext().getNext();
		DLinkTester.swap(node1, node2);
		DList l2 = setup(Arrays.asList("A", "C", "B", "D" ));
		DNode cur1 = l1.getFirst();
		DNode cur2 = l2.getFirst();
		while(cur1 != null){
			Assert.assertEquals(cur1.getElement(), cur2.getElement());
			cur1 = cur1.getNext();
			cur2 = cur2.getNext();
		}
	}

}
