package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.real.JavaMap;

public class JavaMapTest {
	
	// You might want this; if you're using Map<String, Integer> anywhere...
	// JUnit has an assertEquals(Object, Object) and an assertEquals(int, int).
	// When you give it assertEquals(Integer, int) it doesn't know which to use (but both would be OK!)
	// This method gets around that by forcing the (int, int) version.
	void assertIntEq(int x, int y) {
		assertEquals(x, y);
	}

	@Test
	public void testEmpty() {
		MapADT<String, String> empty = new JavaMap<>();
		assertEquals(empty.size(), 0);

	}
	
	@Test
	public void testEmptyStringPut() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("", "");
		assertEquals(abc.size(), 1);
		
	}
	
	@Test
	public void testPutOnce() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		assertEquals(abc.size(), 1);
		
	}
	
	@Test
	public void testPutNullValue() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", null);
		assertEquals(abc.size(), 1);
		
	}
	
	@Test
	public void testPutNullBoth() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put(null, null);
		assertEquals(abc.size(), 1);
		
	}
	
	@Test
	public void testRepeatedPut() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("tabby", "cat");
		assertEquals(abc.size(), 2);
		
	}
	
	@Test
	public void testRepeatedIdenticalPut() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("husky", "dog");
		assertEquals(abc.size(), 1);
		
	}
	
	@Test
	public void testDifferentValuePut() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("husky", "cat");
		assertEquals(abc.size(), 1);
		assertEquals(abc.get("husky"), "cat");
		
	}
	
	@Test
	public void testDifferentKeyPut() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("PWD", "dog");
		assertEquals(abc.size(), 2);
		
	}
	
	@Test
	public void testGet() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("PWD", "dog");
		assertEquals(abc.get("husky"), "dog");
		
	}
	
	@Test
	public void testGetNotThere() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("PWD", "dog");
		assertEquals(abc.get("GSD"), null);
		
	}
	
	@Test
	public void testGetEmpty() {
		MapADT<String, String> abc = new JavaMap<>();
		assertEquals(abc.get("husky"), null);
		
	}
	
	@Test
	public void testRemoveOnce() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.remove("husky");
		assertEquals(abc.size(), 0);
		
	}
	
	@Test
	public void testRemoveAll() {
		MapADT<String, String> abc = new JavaMap<>();
		abc.put("husky", "dog");
		abc.put("PWD", "dog");
		abc.put("GSD", "dog");
		abc.remove("husky");
		abc.remove("PWD");
		abc.remove("GSD");
		assertEquals(abc.size(), 0);
		
	}
	
	
}
