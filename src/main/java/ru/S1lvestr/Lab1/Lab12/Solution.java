package ru.S1lvestr.Lab1.Lab12;

public class Solution {
    public int removeElementInplace(int[] arr, int val) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }
}
