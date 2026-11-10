package ru.S1lvestr.Lab2.Lab22;

import java.util.List;

import ru.S1lvestr.Lab2.Interface.Sorting;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        // Если не проверять - будет очень больно в момент, когда дослайсимся до момента равности индексов start и end
        // StackOverflowError всё же никому ловить не хочется
        if (start < end) {
            int delta = end - start;
            // + start нужен чтоб оффсет учесть. Иначе при start = 4 и end = 8 (как пример) мы получим 2, а это уж точно не середина
            int middle = (delta / 2) + start;
            slice(nums, start, middle);
            // Мы же не хотим, чтобы у нас один и тот же элемент попал в два слайса одновременно?
            // Мы не хотим. Так что инкремент наше всё
            slice(nums, middle + 1, end);
            merge(nums, start, middle, end);
        }
    }

    private void merge(List<Integer> nums, int start, int middle, int end) {
        // Вычитая два индекса, мы получаем значение на 1 меньше, чем длина массива.
        // Так что компенсируем
        int leftArraySize = middle - start + 1;
        // А тут без этого, бо зачем, если индекс middle ведёт к ласт элементу левого слайса, а не к первому правого
        int rightArraySize = end - middle;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = nums.get(start + i); // не забываем про оффсет
        }
        for (int i = 0; i < rightArraySize; i++) {
            // И ещё раз не забываем про оффсет (ну и про то, что middle указывает на последний элемент левого массива
            rightArray[i] = nums.get(i + middle + 1);
        }
        // Индексы слайсов
        int i = 0;
        int j = 0;
        int k = start; // А вот тут уже мерджа

        // А тут начинается пляска с межмассивным (?) сравнением элементов
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                nums.set(k, leftArray[i]);
                i++;
            } else {
                nums.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        // Умудрились выйти из цикла выше ранее, чем прошлись по какому-либо из всех слайсов?
        // Исправляем
        while (i < leftArraySize) {
            nums.set(k, leftArray[i]);
            i++;
            k++;
        }
        while(j < rightArraySize) {
            nums.set(k, rightArray[j]);
            j++;
            k++;
        }
    }

    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}
