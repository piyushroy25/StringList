package cs1302.p2;

import cs1302.adt.StringList;

/**
 * Abstract class that has the methods used in ArrayStringList and LinkedStringList.
 */
public abstract class BaseStringList implements StringList {

    protected int size;

    /**
     * Initializes the size variable - constructor.
     */
    public BaseStringList() {
        size = 0;
    } // BaseStringList

    /**
     * Returns the number of items in this string list.
     *
     * @return the number of items in this string list.
     */
    @Override
    public int size() {
        return this.size;
    } // size


    /**
     * Returns true if this string list has no items.
     *
     * @return true if string has no items (is empty).
     */
    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    } // isEmpty


    /**
     * Returns a string from string list that begins with start and ends with end, separated by sep.
     *
     * @param start specified starting string.
     * @param sep the specified separator string.
     * @param end the specified ending string.
     * @return a string representation of the new string.
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String newString = start;

        if (size == 0) {
            newString += end;
            return newString;
        }

        String first = get(0);
        if (first == null) {
            newString += "null";
        } else {
            newString += first;
        }

        for (int i = 1; i < size; i++) {
            newString += sep;
            String current = get(i);
            if (current == null) {
                newString += "null";
            } else {
                newString += current;
            }
        }

        newString += end;
        return newString;
    } // makeString

    /**
     * Returns makeString("[", ", ", "]").
     *
     * @return makeString.
     */
    @Override
    public String toString() {
        return makeString("[", ", ", "]");
    } // toString

    /**
     * Returns true if start is greater than or equal to 0 and there exists an item at or after the
     * start index that equals the target string. If no such item exists, then false is returned.
     *
     * @param start the index from which to start.
     * @param target the item to search for.
     * @return true if there exists an item at or after start that equals target, false otherwise.
     */
    @Override
    public boolean contains(int start, String target) {
        if (start < 0 || start >= size) {
            return false;
        }

        for (int i = start; i < size; i++) {
            String current = get(i);

            if (target == null) {
                if (current == null) {
                    return true;
                }
            } else {
                if (target.equals(current)) {
                    return true;
                }
            }
        }

        return false;
    } // contains

    /**
     * Inserts multiple items into this string list at the specified index position.
     * The relative order of inserted items is preserved. If items were already at
     * that or subsequent positions, then those items are shifted to the right.
     *
     * @param index index at which the specified items are to be inserted.
     * @param itemList string list of items to be inserted.
     * @return true if this list changed as a result of this call.
     * @throws NullPointerException if itemList is null.
     * @throws IndexOutOfBoundsException if index is out of range (less than 0 or greater than
     * the size of the list).
     */
    @Override
    public boolean add(int index, StringList itemList) {
        if (itemList == null) {
            throw new NullPointerException("itemList cannot be null.");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The specified index is out of bounds.");
        }

        int count = itemList.size();
        if (count == 0) {
            return false;
        }

        for (int i = 0; i < count; i++) {
            add(index + i, itemList.get(i));
        }

        return true;

    } // add

} // BaseStringList
