package com.github.zelinf.algorithms.sorting;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(JUnitQuickcheck.class)
public class HeapTest {

    @Test
    public void isHeapTest() {
        List<Integer> l1 = Arrays.asList(16, 14, 10, 8, 7, 9, 3, 2, 4, 1);
        Assert.assertTrue(Heap.isHeap(l1));

        List<Integer> l2 = Arrays.asList(16, 4, 10, 14, 7, 9, 3, 2, 8, 1);
        Assert.assertFalse(Heap.isHeap(l2));
    }

    @Property
    public void heapConstructionTest(@When(satisfies = "#_ != null") List<Integer> list) {
        Assume.assumeTrue(list != null);

        List<Integer> unordered = new ArrayList<>(list);
        for (int i = 0; i < 10; i++) {
            Collections.shuffle(unordered);
            List<Integer> heap = new Heap<>(unordered).getList();
            Assert.assertTrue(Heap.isHeap(heap));
        }
    }
}