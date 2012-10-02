
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	
	private final HashMap<T, HashSet<T>> m;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		m = new HashMap<T, HashSet<T>>();
		T t;
		for(int i = 0; i < rules.size() - 1; i++) {
			if((t = rules.get(i)) != null) {
				if(!m.containsKey(t)) {
					m.put(t,  new HashSet<T>());
				}
				if(rules.get(i + 1) != null) {
					m.get(t).add(rules.get(i + 1));
				}
			}
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		 return (elem != null && m.containsKey(elem)) ? m.get(elem) : new HashSet<T>();
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			if(m.containsKey(list.get(i - 1)) &&
					m.get(list.get(i - 1)).contains(list.get(i))) {
				list.remove(i);
				i--;
			}
		}
	}
}
