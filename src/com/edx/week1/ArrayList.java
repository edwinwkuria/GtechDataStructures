package com.edx.week1;

import java.util.NoSuchElementException;
/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) {
            throw new IllegalArgumentException("Null Value added");
        } else {
            int multiples = (size / INITIAL_CAPACITY) >= 1 ? size / INITIAL_CAPACITY : 0;
            int newSize = (multiples * INITIAL_CAPACITY) == size ? INITIAL_CAPACITY * (int) Math.pow(2,multiples)
                    : INITIAL_CAPACITY * (int) Math.pow(2,multiples);
            T[] newArray = (T[]) new Object[newSize];
            for (int all = 0; all < size; all++){
                newArray[all + 1] = backingArray[all];
            }
            backingArray = newArray;
            backingArray[0] = data;
            size++;
        }
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null) {
            throw new IllegalArgumentException("Null Value Added");
        } else {
            int multiples = (size / INITIAL_CAPACITY) >= 1 ? size / INITIAL_CAPACITY : 0;
            if((multiples * INITIAL_CAPACITY) == size){
                int newSize = INITIAL_CAPACITY * (int) Math.pow(2,multiples) ;
                T[] newArray = (T[]) new Object[newSize];
                for (int all = 0; all < size; all++){
                    newArray[all] = backingArray[all];
                }
                backingArray = newArray;
            }
            backingArray[size] = data;
            size++;
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size > 0) {
            int multiples = (size / INITIAL_CAPACITY) >= 1 ? size / INITIAL_CAPACITY : 0;
            int newSize = INITIAL_CAPACITY * (int) Math.pow(2, multiples);
            T[] newArray = (T[]) new Object[newSize];
            T value = backingArray[0];
            for (int all = 0; all < size; all++) {
                newArray[all] = backingArray[all + 1];
            }
            backingArray = newArray;
            size--;
            return value;
        } else {
            throw new NoSuchElementException("No element in Array");
        }
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size > 0) {
            T value = backingArray[size - 1];
            backingArray[size - 1] = null;
            size--;
            return value;
        } else {
            throw new NoSuchElementException("No Element in Array");
        }
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

}

