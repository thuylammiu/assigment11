package com.example.testapplication;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {
    public int[] flattenArray(int[][] input) {
        if (input == null) {
            return new int[0];
        }

        List<Integer> flattenedList = new ArrayList<>();
        for (int[] array : input) {
            for (int num : array) {
                flattenedList.add(num);
            }
        }

        int[] result = new int[flattenedList.size()];
        for (int i = 0; i < flattenedList.size(); i++) {
            result[i] = flattenedList.get(i);
        }

        return result;
    }
}
