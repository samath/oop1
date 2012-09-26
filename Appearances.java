import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		Map<T, Integer> valueMap1 = getCounts(a);
		Map<T, Integer> valueMap2 = getCounts(b);
		int count = 0;
		for(T key : valueMap1.keySet()) { 
			if(valueMap1.get(key) == valueMap2.get(key)) { 
				count++;
			}
		}
		return count;
	}
	
	private static <T> Map<T, Integer> getCounts(Collection<T> c) {
		Map<T, Integer> valueMap = new HashMap<T, Integer>();
		for(T elem : c) {
			Integer count = valueMap.get(elem);
			if(count == null) count = 0;
			valueMap.put(elem, count + 1);
		}
		return valueMap;
	}
	
}
