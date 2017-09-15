package com.github.zelinf.algorithms.sorting;

import java.util.List;

public final class Sorting {

    /**
     * Takes a modifiable list, sort it using the heap-sort algorithm in increasing order.
     *
     * @param list the list to be sorted
     * @param <E>  type of list elements
     */
    public static <E extends Comparable<? super E>> void heapSort(List<E> list) {
        Heap<E> heap = new Heap<>(list);
        for (int i = 1; i <= list.size() - 1; i++) {
            heap.popHead();
        }
    }
}
