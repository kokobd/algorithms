package com.github.zelinf.algorithms.sorting;

import java.util.List;

/**
 * A max heap, used by the heapsort algorithm in this package.
 *
 * @param <E> The element type
 */
@SuppressWarnings("WeakerAccess")
class Heap<E extends Comparable<? super E>> {

    private List<E> list;
    private int size;

    /**
     * Returns the element at the specified position
     *
     * @param index index of the element
     * @return the element to return
     */
    E get(int index) {
        return list.get(index);
    }

    /**
     * Obtain the in-use size of the heap.
     *
     * @return size
     */
    int size() {
        return size;
    }

    /**
     * Construct a heap with a modifiable list.
     * The heap will operate on the list directly.
     *
     * @param list the list to operate on
     */
    Heap(List<E> list) {
        this.list = list;
        buildMaxHeap();
    }

    private void buildMaxHeap() {
        size = list.size();
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * Get the first (and max) element without modifying the the heap
     *
     * @return the first and max element
     */
    E peekHead() {
        return get(0);
    }

    /**
     * Pop the first element and put it rightly after all in-use elements.
     *
     * @return the element popped.
     * @throws ArrayIndexOutOfBoundsException if the heap is empty
     */
    E popHead() {
        E head = peekHead();
        E last = get(size() - 1);
        list.set(0, last);
        list.set(size() - 1, head);

        --size;

        maxHeapify(0);

        return head;
    }

    private void maxHeapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);
        if (l < size()
                && list.get(l).compareTo(list.get(largest)) > 0) {
            largest = l;
        }
        if (r < size
                && list.get(r).compareTo(list.get(largest)) > 0) {
            largest = r;
        }

        if (largest != i) {
            // swap list[i] and list[largest]
            E tmp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, tmp);
            maxHeapify(largest);
        }
    }

    static int left(int i) {
        return 2 * i + 1;
    }

    static int right(int i) {
        return 2 * i + 2;
    }

    static int parent(int i) {
        return (i + 1) / 2 - 1;
    }

    public static <E extends Comparable<? super E>> boolean isHeap(List<E> list) {
        for (int i = 0; i < list.size() / 2 - 1; ++i) {
            E node = list.get(i);
            if (list.get(Heap.left(i)).compareTo(node) > 0
                    || list.get(Heap.right(i)).compareTo(node) > 0) {
                return false;
            }
        }
        return true;
    }
}
