import java.util.HashMap;

public class FirstNonRepeatingCharacter {

	/*
	 * Given a string consisting of small English letters, find and return the first
	 * instance of a non-repeating character in it. If there is no such character,
	 * return ‘-’
	 *
	 * E.g
	 * For s = ‘aaabcccdeeef’ the output should be FirstNon Repeat Character(s) = ‘b’ 
	 * Input type should be string 
	 * Input String contains only lower case English letters only
	 * Input String length -1 <= N <= 100000
	 */
	public static void main(String[] args) {
		System.out.println("Solution 1: " + solution1("aaabbcccdeeef"));
		System.out.println("Solution 2: " + solution2("aaabbcccdeeef"));
		System.out.println("Solution 3: " + solution3("aaabbcccdeeef"));
		System.out.println("Solution 4: " + solution4("aaabbcccdeeef"));
		
	}
	
	/*
	 * Time Complexity O(N^2) Exponential
	 * Imagine we have a two pointers (i,j) i pointer look into 0th index of the given string. 
	 * j pointer look into 1st index of the string, we moved j one by one. j pointer travels to the rest of the index
	 * If you find any duplicate move i into j (index 0 to index 1). And move j into j+1 (2nd index)
	 * Two index are same value, just break the loop. we see the duplicate, move to the next index
	 * i is a outer loop. j is a inner loop
	 */
	private static char solution1(String s) {
		for (int i = 0; i < s.length(); i++) {
			boolean seenDuplicate = false;
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && j != i) {
					seenDuplicate = true;
					break;
				}
			}
			if (!seenDuplicate) {
				return s.charAt(i);
			}
		}
		return '-';
	}
	
	/*
	 * Time Complexity O(N) + O(N) Linear
	 * Hashmap char store into key and number of counts store into value
	 * finally we chack the value = 1, that one is the first non repeated element.
	 */
	private static char solution2(String s) {
		HashMap<Character, Integer> charandcount = new HashMap();
		for (int i = 0; i < s.length(); i++) {
			if (charandcount.containsKey(s.charAt(i))) {
				charandcount.put(s.charAt(i), charandcount.get(s.charAt(i)) + 1);
			} else {
				charandcount.put(s.charAt(i), 1);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (charandcount.get(s.charAt(i)) == 1) {
				return s.charAt(i);
			}
		}
		return '-';
	}
	
	/*
	 * Time Complexity O(N) + O(N) Linear
	 * This operation based on ASCII code base. 
	 * First we create a int array[1 to 26] represent a to z.
	 * Second we iterate a string using toCharArray. And we modify the array value based on the char c. 
	 * That means ASCII value of a is 97 and ASCII value of b is 98 
	 * So, first iteration char_arr[97 - 97]++ its going to increase 0th index value is 1 (0th index means a)
	 * Again if a comes means, [92 - 92]++ its going to increase 0th index value is 2
	 * And finally we find out the first least value in this array. That is the first non repeated element.
	 */

	private static char solution3(String s) {
		int[] char_arr = new int[26];
		for (char c : s.toCharArray()) {
			char_arr[c - 'a']++;
		}
		for (char c : s.toCharArray()) {
			if (char_arr[c - 'a'] == 1) {
				return c;
			}
		}
		return '-';
	}
	
	/*
	 * Time Complexity O(N) Linear
	 * Index base iteration 
	 * For e.g. a first index is 0 and 'a' last index is 2 
	 * but 'd' first index is 8 and last index is also 8. So 'd' is the first non repeating element.
	 */
	private static char solution4(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
				return s.charAt(i);
			}
		}
		return '-';
	}


}
