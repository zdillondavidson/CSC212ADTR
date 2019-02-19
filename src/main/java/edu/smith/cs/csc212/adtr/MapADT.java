package edu.smith.cs.csc212.adtr;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * An abstract view of a Map or dictionary object for CSC212.
 * 
 * @author jfoley
 *
 * @param <KeyType> - the type of objects stored as keys; kept unique.
 * @param <ValueType> - the type of objects mapped to by keys; not necessarily
 *        unique.
 */
public interface MapADT<KeyType, ValueType> {
	/**
	 * Put a new entry in this table.
	 * 
	 * @param k - the first column; kept unique.
	 * @param v - the second column; what the key k maps to.
	 */
	public void put(KeyType k, @Nonnull ValueType v);

	/**
	 * Get the value stored for key k; or return null.
	 * 
	 * @param k - the key to lookup in the table.
	 * @return the value found or null if k is missing.
	 */
	@Nullable
	public ValueType get(KeyType k);

	/**
	 * How many key-value mappings are in this data structure?
	 * 
	 * @return the size of this map.
	 */
	public int size();

	/**
	 * Remove the mapping from this table based on the key k.
	 * 
	 * @param k - the key to remove from the table.
	 * @return what it was mapped to, if you care.
	 */
	@Nullable
	public ValueType remove(KeyType k);

	/**
	 * Get a list of all the keys in this table (order may be random).
	 * 
	 * @return the list of keys.
	 */
	public ListADT<KeyType> getKeys();

	/**
	 * Get the entries from this mapping table as a {@linkplain ListADT} of
	 * {@linkplain Pair} objects.
	 * 
	 * @return the entries of this table.
	 */
	public ListADT<Pair<KeyType, ValueType>> getEntries();

	/**
	 * Convert this to a Java data structure; probably useful for unit-test errors.
	 * 
	 * @return - a Java List object.
	 */
	default public Map<KeyType, ValueType> toJava() {
		HashMap<KeyType, ValueType> output = new HashMap<>();
		for (Pair<KeyType, ValueType> x : this.getEntries()) {
			output.put(x.getKey(), x.getValue());
		}
		return output;
	}
}
