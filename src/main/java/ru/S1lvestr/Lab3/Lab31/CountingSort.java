package ru.S1lvestr.Lab3.Lab31;

import java.util.ArrayList;
import java.util.List;

import ru.S1lvestr.Lab2.Interface.Sorting;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        int n = nums.size();
        if (n == 0) return;
        List<Integer> temp = new ArrayList<>(nums);
        int max = nums.getFirst();
        for (Integer num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int[] countArray = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            countArray[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            countArray[nums.get(i)]++;
        }
        for (int i = 1; i <= max; i++) {
            countArray[i] += countArray[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            nums.set(countArray[temp.get(i)] - 1, temp.get(i));
            countArray[temp.get(i)]--;
        }
    }
}
