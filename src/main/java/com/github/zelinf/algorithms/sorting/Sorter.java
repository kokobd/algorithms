package com.github.zelinf.algorithms.sorting;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Sorter<E extends Comparable<? super E>> {

    /**
     * Takes a modifiable list, sort it using the heap-sort algorithm in increasing order.
     *
     * @param list the list to be sorted
     */
    public void heapSort(List<E> list) {
        Heap<E> heap = new Heap<>(list);
        for (int i = 1; i <= list.size() - 1; i++) {
            heap.popHead();
        }
    }

    /**
     * Takes a modifiable list, sorts it using the (in-place) quick-sort algorithm in increasing order.
     *
     * @param list the list to be sorted
     */
    public void quickSort(List<E> list) {
        if (!list.isEmpty()) {
            int pivot = randomPartition(list);
            List<E> smaller = list.subList(0, pivot);
            List<E> larger = list.subList(pivot + 1, list.size());
            quickSort(smaller);
            quickSort(larger);
        }
    }

    /**
     * Partition for quick-sort
     *
     * @param list the list to be partitioned. It should be non-empty
     */
    private int partition(List<E> list) {
        E pivotValue = list.get(list.size() - 1);
        int pivotIndex = 0;

        for (int i = 0; i <= list.size() - 2; i++) {
            E x = list.get(i);
            if (x.compareTo(pivotValue) < 0) {
                list.set(i, list.get(pivotIndex));
                list.set(pivotIndex, x);
                pivotIndex++;
            }
        }

        E tmp = list.get(pivotIndex);
        list.set(list.size() - 1, tmp);
        list.set(pivotIndex, pivotValue);
        return pivotIndex;
    }

    private int randomPartition(List<E> list) {
        int i = ThreadLocalRandom.current().nextInt(list.size());
        int last_i = list.size() - 1;
        E last = list.get(last_i);
        list.set(last_i, list.get(i));
        list.set(i, last);

        return partition(list);
    }

}
