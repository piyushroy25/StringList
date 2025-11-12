package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.p2.BaseStringList;

/**
 * Class that extends BaseStringList and implements StringList.
 */
public class ArrayStringList extends BaseStringList implements StringList {

    private String[] items;


    /**
     * Initializes the size of items and sets size to zero - constructor.
     */
    public ArrayStringList() {
        this.items = new String[10];
        size = 0;
    } // ArrayStringList


    /**
     * Inserts an item into this string list at the specified index position. If an item was already
     * at that position, then that item and subsequent items are shifted to the right.
     *
     * @param index index at which the specified string is to be inserted.
     * @param item item to be inserted.
     * @return true if this list changed as a result of the call.
     * @throws NullPointerException if item is null.
     * @throws IllegalArgumentException if item is empty.
     * @throws IndexOutOfBoundsException if index is out of bounds (index is less than zero or
     * greater than size.
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("Item cannot be null");
        }
        if (item.length() == 0) {
            throw new IllegalArgumentException("Item cannot be empty");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index cannot be less than 0 or greater than size");
        }

        if (size == items.length) {
            makeBigger();
        }

        for (int i = size - 1; i >= index; i--) {
            items[i + 1] = items[i];
        }

        items[index] = item;
        size++;
        return true;
    } // add


    /**
     * Returns the item at the specified index position in this string list.
     *
     * @param index index of the item to return.
     * @return the item at the specified position in this string list.
     * @throws IndexOutOfBoundsException if index is out of bounds (index is less than zero or
     * greater than or equal to size.
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Index cannot be less than 0 or greater than size");
        }

        return items[index];
    } // get

    /**
     * Removes all of the items from this string list. The string list will be
     * empty after this method returns.
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    } // clear

    /**
     * Removes the item at the specified index position in this string list. Any items in the
     * string list that were after the removed string are shifted to the left.
     *
     * @param index index of the item to remove
     * @return the string that was removed
     * @throws IndexOutOfBoundsException  if index is out of range (it is less than zero or
     * greater than size).
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of range");
        }

        String removeVariable = items[index];
        for (int i = index; i < (size - 1); i++) {
            items[i] = items[i + 1];
        }

        items[size - 1] = null;

        size--;
        return removeVariable;
    } // remove

    /**
     * Returns a new string list that contains the items from this string list in reverse order.
     *
     * @return a new string list with items from this list in reverse order.
     */
    @Override
    public StringList reverse() {
        StringList newArray = new ArrayStringList();

        int counter = 0;
        for (int i = size - 1; i >= 0; i--) {
            newArray.add(counter, items[i]);
            counter++;
        }

        return newArray;
    } // reverse

    /**
     * Returns a new string list that contains the items from this list between the specified start
     * index (inclusive) and stop index (exclusive).
     *
     * @param start left endpoint (inclusive) of the slice
     * @param stop right endpoint (exclusive) of the slice
     * @return new string list with items from this list from start (inclusive) to stop (exclusive)
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > size || start > stop) {
            throw new IndexOutOfBoundsException("Cannot have that endpoint index value");
        }

        ArrayStringList newArray = new ArrayStringList();

        int counter = 0;
        for (int i = start; i < stop; i++) {
            newArray.add(counter, items[i]);
            counter++;
        }

        return newArray;
    } // slice

    /**
     * Make the array bigger if needed by a size of 50% + 1.
     */
    private void makeBigger() {
        String[] newArray = new String[items.length + (int) (items.length / 2) + 1];
        for (int i = 0; i < items.length; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    } // makeBigger

} // ArrayStringList
