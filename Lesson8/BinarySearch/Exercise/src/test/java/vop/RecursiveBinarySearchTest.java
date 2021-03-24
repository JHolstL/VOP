package vop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveBinarySearchTest {

    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
    private int key;

    @Before
    public void setUp() throws Exception {
        key = 8;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void recursiveFind() {
        int test = RecursiveBinarySearch.recursiveFind(FIBOS, 4);

        assertTrue(test<0);
    }

    @Test
    public void testRecursiveFind() {
        int number1 = RecursiveBinarySearch.recursiveFind(FIBOS, 21);
        assertEquals(7, number1);

    }
}