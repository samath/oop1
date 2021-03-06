import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, b));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
		assertEquals(0, Appearances.sameCount(a,  Arrays.asList(5, 5)));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(6)));
	}
	
	@Test
	public void testEmpty() {
		List<Character> a = new ArrayList<Character>();
		assertEquals(0, Appearances.sameCount(a, new ArrayList<Character>()));
		assertEquals(0, Appearances.sameCount(a, Arrays.asList('a')));
		assertEquals(0, Appearances.sameCount(Arrays.asList('a'), a));
	}
	
	@Test
	public void testCollections() {
		List<Integer> a = Arrays.asList(1,2,3,4,1,3);
		Set<Integer> b = new HashSet<Integer>();
		b.addAll(Arrays.asList(1,1,2,3,5));
		assertEquals(1, Appearances.sameCount(a,b));
		assertEquals(1, Appearances.sameCount(b,a));
	}
	
	// Add more tests
}
