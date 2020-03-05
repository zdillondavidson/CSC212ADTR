package edu.smith.cs.csc212.adtr;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaList;
import edu.smith.cs.csc212.adtr.real.JavaMap;
import edu.smith.cs.csc212.adtr.real.JavaSet;

public class ChallengesTest {

	@Test
	public void testUnionSimple() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		right.insert("B");
		right.insert("C");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("A");
		expected.insert("B");
		expected.insert("C");
		Assert.assertEquals(expected, Challenges.union(left, right));
	}
	
	@Test
	public void testUnionOneEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		left.insert("B");
		
		
		SetADT<String> expected = new JavaSet<>();
		
		expected.insert("A");
		expected.insert("B");
		
		
		Assert.assertEquals(expected, Challenges.union(left, right));
		
	}
	
	@Test
	public void testUnionBothEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		SetADT<String> expected = new JavaSet<>();
		
		
		Assert.assertEquals(expected, Challenges.union(left, right));
		
	}
	
	@Test
	public void testUnionSingle() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("B");
		left.insert("B");
		
		right.insert("B");
		
		SetADT<String> expected = new JavaSet<>();
		
		expected.insert("B");
		
		Assert.assertEquals(expected, Challenges.union(left, right));
	}
	
	@Test
	public void testIntersectionSimple() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		right.insert("B");
		right.insert("C");
		
		SetADT<String> expected = new JavaSet<>();
		expected.insert("B");
		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}
	
	@Test
	public void testIntersectionOneEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		left.insert("B");
		left.insert("B");
		
		
		SetADT<String> expected = new JavaSet<>();
		
		
		Assert.assertEquals(expected, Challenges.intersection(left, right));
		
	}
	
	@Test
	public void testIntersectionBothEmpty() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		SetADT<String> expected = new JavaSet<>();
		
		
		Assert.assertEquals(expected, Challenges.intersection(left, right));
		
	}
	
	@Test
	public void testIntersectionSingle() {
		SetADT<String> left = new JavaSet<>();
		SetADT<String> right = new JavaSet<>();
		
		left.insert("A");
		right.insert("A");
		
		SetADT<String> expected = new JavaSet<>();
		
		expected.insert("A");
		
		Assert.assertEquals(expected, Challenges.intersection(left, right));
	}

	
	//FOR ALL TEST WRITING:
	//think about the input and output of each method:
	//try to think about all possible types of values you could put
	//in the input and what you would want to happen for all those.
	//And think about the return/output of the method, all possible
	//types, and how to get each (make sure you can get each)
	//(example for a boolean method, make sure you can get both
	//true and false).
	
	@Test
	public void testWordCountSimple() {
		ListADT<String> example = new JavaList<>();
		for (String word : new String[] {"a", "b", "a", "b", "c", "d"}) {
			example.addBack(word);
		}
		Assert.assertEquals(6, example.size());
		
		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 2);
		expected.put("b", 2);
		expected.put("c", 1);
		expected.put("d", 1);
		
		Assert.assertEquals(expected, Challenges.wordCount(example));
	}
	
	@Test
	public void testWordCountEmpty() {
		ListADT<String> example = new JavaList<>();
		for (String word : new String[] {}) {
			example.addBack(word);
		}
		Assert.assertEquals(0, example.size());
		
		MapADT<String, Integer> expected = new JavaMap<>();
		
		Assert.assertEquals(expected, Challenges.wordCount(example));
	}
	
	@Test
	public void testWordCountOne() {
		ListADT<String> example = new JavaList<>();
		for (String word : new String[] {"a"}) {
			example.addBack(word);
		}
		Assert.assertEquals(1, example.size());
		
		MapADT<String, Integer> expected = new JavaMap<>();
		expected.put("a", 1);
		
		Assert.assertEquals(expected, Challenges.wordCount(example));
	}
	

}
