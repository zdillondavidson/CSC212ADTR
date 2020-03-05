package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaSet;

public class JavaSetTest {
	
	@Test
	public void testSizeEmpty() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.size(), 0);
	}
	
	@Test
	public void testSizeInsert() {
		SetADT<String> one = new JavaSet<>();
		one.insert("A");
		assertEquals(one.size(), 1);
	}
	
	@Test
	public void testSetUniqueness() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		abc.insert("B");
		abc.insert("C");
		abc.insert("A");
		assertEquals(abc.size(), 3);
	}
	
	@Test
	public void testSizeInsertNull() {
		SetADT<String> one = new JavaSet<>();
		one.insert(null);
		assertEquals(one.size(), 1);
	}
	
	@Test
	public void testEmptyContains() {
		SetADT<String> empty = new JavaSet<>();
		assertEquals(empty.contains("A"), false);
	}
	
	@Test
	public void testContainsTrue() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		assertEquals(abc.contains("A"), true);
	}
	
	@Test
	public void testContainsFalse() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		assertEquals(abc.contains("B"), false);
	}
	
	@Test
	public void testRemoveOnce() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		abc.insert("B");
		abc.remove("B");
		assertEquals(abc.contains("B"), false);
	}
	
	@Test
	public void testRemoveAll() {
		SetADT<String> abc = new JavaSet<>();
		abc.insert("A");
		abc.insert("B");
		abc.remove("A");
		abc.remove("B");
		assertEquals(abc.size(), 0);
	}
	
}
