package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.StringList;
import cs1302.p2.BaseStringList;

/**
 * LinkedStringList class that has methods for a linked list using Nodes.
 */
public class LinkedStringList extends BaseStringList implements StringList {

    private Node head;

    /**
     * Constructor that creates an empty LinkedStringList with no nodes.
     */
    public LinkedStringList() {
        head = null;
        size = 0;
    } // LinkedStringList

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

        Node newNode = new Node(item);

        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getNext();
            }
            newNode.setNext(previous.getNext());
            previous.setNext(newNode);
        }

        size++;
        return true;

    } // add

    /**
     * Removes all of the items from this string list. The string list will be
     * empty after this method returns.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;
    } // clear

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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        String item;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        item = current.getItem();
        return item;
    } // get

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
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        String removedItem;
        if (index == 0) {
            removedItem = head.getItem();
            head = head.getNext();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            removedItem = current.getNext().getItem();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return removedItem;
    } // remove

    /**
     * Returns a new string list that contains the items from this string list in reverse order.
     *
     * @return a new string list with items from this list in reverse order.
     */
    @Override
    public StringList reverse() {
        LinkedStringList newList = new LinkedStringList();

        Node current = head;

        while (current != null) {
            Node newNode = new Node(current.getItem());
            newNode.setNext(newList.head);
            newList.head = newNode;

            newList.size++;
            current = current.getNext();
        }

        return newList;
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
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Indices are out of bounds");
        }

        StringList newList = new LinkedStringList();
        Node current = head;

        for (int i = 0; i < start; i++) {
            current = current.getNext();
        }

        int counter = 0;
        for (int i = start; i < stop; i++) {
            newList.add(counter, current.getItem());
            current = current.getNext();
            counter++;
        }

        return newList;
    } // slice

} // LinkedStringList
