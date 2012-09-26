import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int count = 1, longest = 0, length = str.length();
		if(length == 0) return 0;
		char curr = str.charAt(0);
		for(int i = 1; i < length; i++) {
			char next = str.charAt(i);
			if(next == curr) count++;
			else {
				if(longest < count) longest = count;
				count = 1;
				curr = next;
			}
		}
		return (longest > count) ? longest : count;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		if(str.length() == 0) return "";
		char ch;
		for(int i = 0; i < str.length() - 1; i++) {
			if(Character.isDigit(ch = str.charAt(i))) {
				int reps = Character.getNumericValue(ch);
				char next = str.charAt(i + 1);
				str = str.substring(0,i) + copy(reps, next) + str.substring(i + 1, str.length());
				i += reps - 1;				
			}
		}
		if(Character.isDigit(ch = str.charAt(str.length() - 1))) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	private static String copy(int reps, char ch) {
		String s = "";
		for(int i = 0; i < reps; i++) {
			s += ch;
		}
		return s;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		if(len <= 0) return false;
		int alen = a.length(), blen = b.length();
		Set<String> s = new HashSet<String>();
		for(int i = 0; i < alen - len + 1; i++) {
			s.add(a.substring(i, i + len));
		}
		for(int i = 0; i < blen - len + 1; i++) {
			if(s.contains(b.substring(i, i + len))) return true;
		}
		return false;
	}
}
