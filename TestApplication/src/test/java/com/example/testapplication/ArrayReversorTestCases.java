package com.example.testapplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArrayReversorTestCases.LegitInputTest.class, ArrayReversorTestCases.NullInputTest.class})

public class ArrayReversorTestCases {

    public static class LegitInputTest {
        private ArrayReversor reversor;
        private ArrayFlattenerServiceMock flattenerServiceMock;

        @Before
        public void setUp() {
            flattenerServiceMock = new ArrayFlattenerServiceMock();
            reversor = new ArrayReversor(flattenerServiceMock);
        }

        @Test
        public void testReverseArray() {
            int[][] input = {{1, 3}, {0}, {4, 5, 9}};
            int[] expected = {9, 5, 4, 0, 3, 1};

            int[] result = reversor.reverseArray(input);
            assertArrayEquals(expected, result);
            assertTrue(flattenerServiceMock.isFlattenArrayCalled());
        }
    }

    public static class NullInputTest {
        private ArrayReversor reversor;
        private ArrayFlattenerServiceMock flattenerServiceMock;

        @Before
        public void setUp() {
            flattenerServiceMock = new ArrayFlattenerServiceMock();
            reversor = new ArrayReversor(flattenerServiceMock);
        }

        @Test
        public void testReverseArrayWithNullInput() {
            int[] result = reversor.reverseArray(null);
            assertNull(result);
           // assertTrue(flattenerServiceMock.isFlattenArrayCalled());
        }
    }
}
