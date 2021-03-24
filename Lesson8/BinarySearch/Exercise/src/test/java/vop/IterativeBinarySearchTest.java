package vop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IterativeBinarySearchTest {

    private static final int[] FIBOS = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void find() {
        int number2 = IterativeBinarySearch.find(FIBOS, 21);
        assertEquals(7,number2);
    }

    @Test
    public void findNegative(){

    }
}