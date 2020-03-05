package edu.smith.cs.csc212.adtr;

import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

// Wow, this class really needs some comments...
public class Challenges {

	/**
	 * Creates a new set that is the union of two sets.
	 * @param left  - a set of Strings
	 * @param right - a set of Strings
	 * @return - the set of all Strings in left and all in right
	 */
	public static SetADT<String> union(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String e : left) {
			output.insert(e);
		}
		for (String e : right) {
			output.insert(e);
		}
		return output;
	}
	
	/**
	 * Creates a new set that is the intersection of two sets.
	 * @param left - a set of Strings
	 * @param right - a set of Strings
	 * @return - the set of all Strings that left and right have in common
	 */
	public static SetADT<String> intersection(SetADT<String> left, SetADT<String> right) {
		SetADT<String> output = new JavaSet<>();
		for (String e : left) {
			if (right.contains(e)) {
				output.insert(e);
			}
		}
		
		return output;
	}
	
	/**
	 * Returns a map of the words in a list with how many times 
	 * each word occurs as the value for each word/key
	 * @param words - a list of strings
	 * @return - a map: the keys are each word from the list; 
	 * values are how many times that word occurs
	 */
	public static MapADT<String, Integer> wordCount(ListADT<String> words) {
		MapADT<String, Integer> output = new JavaMap<>();
		for (String e : words) {
			Integer value = output.get(e);
			if (value == null) {
				output.put(e, 1);
			}
			else {
				output.put(e, value + 1);
			}
		}
		
		return output;
	}
}
