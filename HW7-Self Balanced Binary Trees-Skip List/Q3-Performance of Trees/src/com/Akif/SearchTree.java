package com.Akif;

/**
 * A basic interface for binary search tree.
 * @param <E> Type of interface.
 */
public interface SearchTree<E> {
    boolean add(E item);
    boolean contains(E target);
    E find(E target);
    E delete(E target);
    boolean remove(E target);
}
