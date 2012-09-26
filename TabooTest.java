// TabooTest.java
// Taboo class tests -- nothing provided.

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TabooTest {
	
	
	@Test
	public void tabooTest1() {
		Taboo<Integer> taboo = new Taboo<Integer>(new ArrayList<Integer>(
				Arrays.asList(1,2,3,1,3,4,2)));
		
		assertSetsEqual(taboo.noFollow(1), createSet(2,3));
		assertSetsEqual(taboo.noFollow(2), createSet(3));
		assertSetsEqual(taboo.noFollow(5), new HashSet<Integer>());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		taboo.reduce(list);
		assertListsEqual(list, new ArrayList<Integer>());
		
		assertListsEqual(reducedList(taboo, 1, 2), 
				new ArrayList<Integer>(Arrays.asList(1)));
		assertListsEqual(reducedList(taboo, 1,2,3,4,2,5,1,3,4,2),
				new ArrayList<Integer>(Arrays.asList(1,4,5,1,4)));
		
	
	}
	
	private <T> ArrayList<T> reducedList(Taboo<T> taboo, T... objs) {
		ArrayList<T> list = new ArrayList<T>(Arrays.asList(objs));
		taboo.reduce(list);
		return list;
	}
	
	private <T> void assertSetsEqual(Set<T> s1, Set<T> s2) {
		assertEquals(s1.size(), s2.size());
		for(T t : s1) {
			assert(s2.contains(t));
		}
	}
	
	private <T> void assertListsEqual(List<T> l1, List<T> l2) {
		assertEquals(l1.size(), l2.size());
		for(int i = 0; i < l1.size(); i++) {
			assertEquals("Index " + i, l1.get(i), l2.get(i));
		}
	}	
	
	private <T> Set<T> createSet(T... objs) {
		Set<T> set = new HashSet<T>();
		set.addAll(Arrays.asList(objs));
		return set;
	}
		
}