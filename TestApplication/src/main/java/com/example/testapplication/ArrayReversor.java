package com.example.testapplication;

import java.util.ArrayList;
import java.util.List;

public class ArrayReversor {
    private final ArrayFlattenerService flattenerService;

    public ArrayReversor(ArrayFlattenerService flattenerService) {
        this.flattenerService = flattenerService;
    }

    public int[] reverseArray(int[][] nestedArray) {
        if (nestedArray == null) {
            return null;
        }

        int[] flattenedArray = flattenerService.flattenArray(nestedArray);
        List<Integer> reversedList = new ArrayList<>();

        for (int i = flattenedArray.length - 1; i >= 0; i--) {
            reversedList.add(flattenedArray[i]);
        }

        return reversedList.stream().mapToInt(Integer::intValue).toArray();
    }
}
