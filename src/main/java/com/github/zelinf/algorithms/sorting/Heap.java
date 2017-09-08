package com.github.zelinf.algorithms.sorting;

import java.util.List;
import java.util.Objects;

/**
 * A max heap, used by the heapsort algorithm in this package.
 *
 * @param <E> The element type
 */
class Heap<E extends Comparable<? super E>> {

    private List<E> list;

    List<E> getList() {
        return list;
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
        for (int i = list.size() / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void maxHeapify(int i) {
        int largest = i;
        int l = left(i);
        int r = right(i);
        if (l < list.size()
                && list.get(l).compareTo(list.get(largest)) > 0) {
            largest = l;
        }
        if (r < list.size()
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

    static <E extends Comparable<? super E>> boolean isHeap(List<E> list) {
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
