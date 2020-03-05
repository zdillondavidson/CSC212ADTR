package edu.smith.cs.csc212.adtr;

import java.util.List;

import edu.smith.cs.csc212.adtr.real.JavaList;

import java.util.ArrayList;

/**
 * Creates a SetADT from a List.
 * @author zoedillon-davidson
 *
 * @param <T> - A List to be created into a Set.
 */
public class SetFromList<T> extends SetADT<T> {
	/**
	 * Java object.
	 */
	private ArrayList<T> inner;

	/**
	 * Construct an empty SetFromList.
	 */
	public SetFromList() {
		this.inner = new ArrayList<T>();

	} 

	public SetFromList(List<T> toAdd) {
		for (T i : toAdd) {
			this.insert(i);
		}
	}

	@Override
	public int size() {
		return this.inner.size();
	}

	@Override
	public void insert(T value) {
		if (!this.inner.contains(value)) {
			this.inner.add(value);
		}
	}

	@Override
	public boolean contains(T value) {
		if (this.inner.contains(value)) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(T value) {
		this.inner.remove(value);

	}

	@Override
	public ListADT<T> toList() {
		return new JavaList<>(inner);
	}

}
