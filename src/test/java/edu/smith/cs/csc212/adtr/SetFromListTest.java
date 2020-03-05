package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;


public class SetFromListTest {
	 
	/**
	 * Make a new empty list.
	 * @return an empty list to be tested.
	 */
	private <T> ListADT<T> makeEmptyList() {
		return new JavaList<>();
	}

	/**
	 * Helper method to make a full list.
	 * @return [a, b, c, d] - a small, predictable list for many tests.
	 */
	private ListADT<String> makeFullList() {
		ListADT<String> data = makeEmptyList();
		data.addBack("a");
		data.addBack("b");
		data.addBack("b");
		data.addBack("c");
		data.addBack("d");
		return data;
	}
	
	private SetFromList<String> makeSet(){
		SetFromList<String> set = new SetFromList<String>();
		ListADT<String> list = makeFullList();
		for (String s : list) {
			set.insert(s);
		}
		return set;
	}
	
	@Test
	public void testSetFromListSimple() {
		SetFromList<String> fullSet = new SetFromList<>();
		fullSet = makeSet();
		
		ArrayList<String> expected = new ArrayList<>();
		expected.add("a");
		expected.add("b");
		expected.add("c");
		expected.add("d");
		
		assertEquals(expected.size(), fullSet.size());
	}

}
