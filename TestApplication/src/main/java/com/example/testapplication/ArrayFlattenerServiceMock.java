package com.example.testapplication;

public class ArrayFlattenerServiceMock implements ArrayFlattenerService {
    private boolean flattenArrayCalled = false;

    @Override
    public int[] flattenArray(int[][] nestedArray) {
        flattenArrayCalled = true;
        int[] flattenedArray = new int[0];

        for (int[] array : nestedArray) {
            int[] temp = new int[flattenedArray.length + array.length];
            System.arraycopy(flattenedArray, 0, temp, 0, flattenedArray.length);
            System.arraycopy(array, 0, temp, flattenedArray.length, array.length);
            flattenedArray = temp;
        }

        return flattenedArray;
    }

    public boolean isFlattenArrayCalled() {
        return flattenArrayCalled;
    }
}