package com.Akif;
/**
 * New version of HashTableChain class from the book.
 * It uses chaining with binary tree instead of linked list.
 * @param <K> Key type of table.
 * @param <V> Value type of table.
 */
@SuppressWarnings("unchecked")
public class MyHashTableChain<K, V extends Comparable<V>> implements KWHashMap<K, V>  {
    /** The table */
    private BinarySearchTree<Entry<K, V>>[] table;
    /** The number of keys */
    private int numKeys;
    /** The capacity */
    private static final int CAPACITY = 101;
    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;
    // Constructor
    public MyHashTableChain() {
        table = new BinarySearchTree[CAPACITY];
    }
    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    @Override
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.
        // Search the list at table[index] to find the key.
        for (BinarySearchTree<Entry<K, V>> it = table[index]; it.hasNext (); ) {
            Entry<K, V> nextItem = it.next ();
            if (nextItem.getKey().equals(key))
                return nextItem.getValue();
        }
        // assert: key is not in the table.
        return null;
    }
    /**
     * Returns true if this table contains no elements.
     * @return true if this table contains no elements
     */
    @Override
    public boolean isEmpty () {
        return table.length==0;
    }

    /** Method put for class HashtableChain.
     post This key value pair is inserted in the
     table and numKeys is incremented. If the key is already
     in the table, its value is changed to the argument
     value and numKeys is not changed.
     @param key The key of item being inserted
     @param value The value for this key
     @return The old value associated with this key if
     found; otherwise, null
     */
    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new binary tree at table[index].
            table[index] = new BinarySearchTree<> ();
        }
        // Search the tree at table[index] to find the key.
        for (BinarySearchTree<Entry<K, V>> it = table[index]; it.hasNext (); ) {
            Entry<K, V> nextItem = it.next ();
            // If the search is successful, replace the old value.
            if (nextItem.getKey().equals(key)) {
                // Replace value for this key.
                V oldVal = nextItem.getValue();
                nextItem.setValue(value);
                return oldVal;
            }
        }

        // assert: key is not in the table, add new item.
        table[index].add (new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length))
            rehash();
        return null;
    }
    /**
     * Removes the mapping for the specified key from this table if present.
     * @param key key whose mapping is to be removed from the table.
     * @return the previous value associated with key, or null if there was no mapping for key.
     */
    @Override
    public V remove (Object key) {
        V temp =null;
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null) {
            // Create a new tree at table[index].
            return null;
        }
        // Search the tree at table[index] to find the key.
        for (BinarySearchTree<Entry<K, V>> it = table[index]; it.hasNext (); ) {
            Entry<K, V> nextItem = it.next ();
            if (nextItem.getKey().equals(key)){
                temp = nextItem.value;
                table[index].remove (nextItem);
            }

        }
        return temp;
    }
    /**
     * Returns the number of key value mappings in this table.
     * @return the number of key value mappings in this table.
     */
    @Override
    public int size () {
        int total=0;
        for (int i = 0; i < table.length; i++) {
            if ((table[i] != null)) {
                total+=table[i].size ();
            }
        }
        return total;
    }
    /** Expands table size when loadFactor exceeds LOAD_THRESHOLD
     post The size of the table is doubled and is an odd integer.
     Each nondeleted entry from the original table is
     reinserted into the expanded table.
     The value of numKeys is reset to the number of items
     actually inserted; numDeletes is reset to 0.
     */
    private void rehash() {
        // Save a reference to oldTable.
        BinarySearchTree<Entry<K, V>>[] oldTable = table;
        // Double capacity of this table.
        table =  new BinarySearchTree[2 * oldTable.length + 1];
        // Reinsert all items in oldTable into expanded table.
        numKeys = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null)) {
                // Insert entry in expanded table
                for (BinarySearchTree<Entry<K, V>> it = oldTable[i]; it.hasNext (); ) {
                    Entry<K, V> nextItem = it.next ();
                    put(nextItem.getKey(), nextItem.getValue());
                }
            }
        }
    }
    /** Contains key value pairs for a hash table. */
    private static class Entry<K, V extends Comparable<V>> implements Comparable<Entry<K, V>> {
        /** The key */
        private K key;
        /** The value */
        private V value;
        /** Creates a new key value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }
        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }
        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }

        /**
         * Compares this object with the specified object for order. Returns a negative integer, zero,
         * or a positive integer as this object is less than, equal to, or greater than the specified object.
         * Comparing is done by values of map.
         * @param o the object to be compared.
         * @return a negative integer, zero, or a positive integer as this object is less than,
         * equal to, or greater than the specified object.
         */
        @Override
        public int compareTo (Entry<K, V> o) {
            return value.compareTo (o.value);
        }
    }
}
