package com.example.testapplication;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ArrayFlattenerTest {
    @Test
    public void testFlattenArrayWithLegitInput() {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] expectedOutput = {1, 3, 0, 4, 5, 9};
        int[] result = arrayFlattener.flattenArray(input);
        Assert.assertArrayEquals(expectedOutput, result);
    }

    @Test
    public void testFlattenArrayWithNullInput() {
        ArrayFlattener arrayFlattener = new ArrayFlattener();
        int[][] input = null;
        int[] expectedOutput = {};
        int[] result = arrayFlattener.flattenArray(input);
        Assert.assertArrayEquals(expectedOutput, result);
    }
}
