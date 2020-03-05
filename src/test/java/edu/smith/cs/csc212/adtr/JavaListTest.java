package edu.smith.cs.csc212.adtr;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.adtr.errors.BadIndexError;
import edu.smith.cs.csc212.adtr.errors.EmptyListError;
import edu.smith.cs.csc212.adtr.real.JavaList;


public class JavaListTest {
	
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
		data.addBack("c");
		data.addBack("d");
		return data;
	}
		
	@Test
	public void testEmpty() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(0, data.size());
		Assert.assertEquals(true, data.isEmpty());
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeBack();
	}
	
	@Test(expected=EmptyListError.class)
	public void testRemoveIndexCrash() {
		ListADT<String> data = makeEmptyList();
		data.removeIndex(3);
	}

	@Test
	public void testAddToFront() {
		ListADT<String> data = makeEmptyList();
		Assert.assertEquals(true, data.isEmpty());
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		Assert.assertEquals(false, data.isEmpty());
		data.addFront("-2");
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));
		Assert.assertEquals(false, data.isEmpty());
	}

	//Test addBack
	@Test
	public void testAddBackSimple() {
		ListADT<String> data = makeFullList();
		data.addBack("Z");
		assertEquals("Z", data.getBack());
	}
	
	@Test
	public void testAddBackListOfOne() {
		ListADT<String> data = makeEmptyList();
		data.addBack("Z");
		data.addBack("Q");
		assertEquals("Q", data.getBack());
		assertEquals(data.size(), 2);
	}
	
	@Test
	public void testAddBackTwice() {
		ListADT<String> data = makeFullList();
		data.addBack("Y");
		data.addBack("Z");
		assertEquals("Z", data.getBack());
		assertEquals(data.size(), 6);
	}
	
	@Test
	public void testAddBackEmpty() {
		ListADT<String> data = makeEmptyList();
		data.addBack("Z");
		assertEquals("Z", data.getBack());
		assertEquals("Z", data.getFront());
		assertEquals(data.size(), 1);
	}
	
	
	
	//Test removeBack
	@Test
	public void testRemoveBackSimple() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		assertEquals(data.size(), 3);
		assertEquals(data.getBack(), "c");
	}
	
	@Test
	public void testRemoveBackListOfOne() {
		ListADT<String> data = makeEmptyList();
		data.addIndex(0, "A");
		data.removeBack();
		assertEquals(data.size(), 0);
	}
	
	@Test
	public void testRemoveBackTwice() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		data.removeBack();
		assertEquals(data.size(), 2);
		assertEquals(data.getBack(), "b");
	}
	
	//Test removeIndex
	@Test
	public void testRemoveIndexFirst() {
		ListADT<String> data = makeFullList();
		data.removeIndex(0);
		assertEquals(data.getIndex(0), "b");
	}
	
	@Test
	public void testRemoveIndexMiddle() {
		ListADT<String> data = makeFullList();
		data.removeIndex(2);
		assertEquals(data.getIndex(2), "d");
	}
	
	@Test
	public void testRemoveIndexBack() {
		ListADT<String> data = makeFullList();
		data.removeIndex(3);
		assertEquals(data.size(), 3);
		assertEquals(data.getBack(), "c");
	}
	
	@Test
	public void testRemoveIndexListOfOne() {
		ListADT<String> data = makeEmptyList();
		data.addBack("A");
		data.removeIndex(0);
		assertEquals(data.size(), 0);
	}
	
	@Test
	public void testRemoveBackAll() {
		ListADT<String> data = makeFullList();
		data.removeBack();
		data.removeBack();
		data.removeBack();
		data.removeBack();
		assertEquals(data.size(), 0);
		
	}
	
	//Test removeFront
	@Test
	public void testRemoveFrontOnce() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		assertEquals(data.getFront(), "b");
	}
	
	@Test
	public void testRemoveFrontTwice() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		data.removeFront();
		assertEquals(data.getFront(), "c");
	}
	
	@Test
	public void testRemoveFrontAll() {
		ListADT<String> data = makeFullList();
		data.removeFront();
		data.removeFront();
		data.removeFront();
		data.removeFront();
		assertEquals(data.size(), 0);
	}
	
	
	
	//Test addIndex
	@Test
	public void testAddIndexMiddle() {
		ListADT<String> data = makeFullList();
		data.addIndex(1, "X");
		assertEquals(data.getIndex(1), "X");
		assertEquals(data.getIndex(2), "b");
		assertEquals(data.size(), 5);
	}
	
	@Test
	public void testAddIndexEmpty() {
		ListADT<String> data = makeEmptyList();
		data.addIndex(0, "X");
		assertEquals(data.size(), 1);
	}
	
	@Test
	public void testAddIndexFront() {
		ListADT<String> data = makeFullList();
		data.addIndex(0, "X");
		assertEquals(data.getIndex(0), "X");
		assertEquals(data.size(), 5);
	}
	
	@Test
	public void testAddIndexBack() {
		ListADT<String> data = makeFullList();
		data.addIndex(4, "X");
		assertEquals(data.getIndex(4), "X");
		assertEquals(data.size(), 5);
	}
	
	@Test
	public void testAddIndexBackTwice() {
		ListADT<String> data = makeFullList();
		data.addIndex(4, "X");
		data.addIndex(5, "Y");
		assertEquals(data.getIndex(4), "X");
		assertEquals(data.getIndex(5), "Y");
		assertEquals(data.size(), 6);
	}
	
	@Test
	public void testAddIndexEmptyString() {
		ListADT<String> data = makeFullList();
		data.addIndex(0, "");
		assertEquals(data.getIndex(0), "");
		assertEquals(data.size(), 5);
		
	}
	
	@Test
	public void testGetFront() {
		ListADT<String> data = makeFullList();
		assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		ListADT<String> data = makeFullList();
		assertEquals("d", data.getBack());
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetFrontCrash() {
		ListADT<String> data = makeEmptyList();
		data.getFront();
	}
	
	@Test(expected=EmptyListError.class)
	public void testGetBackCrash() {
		ListADT<String> data = makeEmptyList();
		data.getBack();
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexLow() {
		ListADT<String> data = makeFullList();
		data.getIndex(-2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHigh() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size());
	}
	
	@Test(expected=BadIndexError.class)
	public void testGetIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.getIndex(data.size()*2);
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHighEasy() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()*2, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexHigh() {
		ListADT<String> data = makeFullList();
		data.addIndex(data.size()+1, "the");
	}
	
	@Test(expected=BadIndexError.class)
	public void testAddIndexLow() {
		ListADT<String> data = makeFullList();
		data.addIndex(-1, "the");
	}
	
	
	//Test setIndex
	@Test
	public void testSetIndex0() {
		ListADT<String> data = makeFullList();
		data.setIndex(0, "Z");
		assertEquals(data.getIndex(0), "Z");
	}
	
	@Test
	public void testSetIndexBack() {
		ListADT<String> data = makeFullList();
		data.setIndex(3, "Z");
		assertEquals(data.getBack(), "Z");
	}
	
	@Test
	public void testSetIndexMiddle() {
		ListADT<String> data = makeFullList();
		data.setIndex(2, "B");
		assertEquals(data.getIndex(2), "B");
	}
	
	@Test
	public void testToJava() {
		assertEquals(makeFullList().toJava(), Arrays.asList("a", "b", "c", "d"));
	}
	
	@Test
	public void testEquals() {
		assertEquals(makeFullList(), new JavaList<>(Arrays.asList("a", "b", "c", "d")));
	}
	
	@Test
	public void testEquals2() {
		assertEquals(makeFullList(), makeFullList());
	}
}
