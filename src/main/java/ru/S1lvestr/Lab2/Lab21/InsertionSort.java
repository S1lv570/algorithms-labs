package ru.S1lvestr.Lab2.Lab21;

import java.util.List;
import ru.S1lvestr.Lab2.Interface.Sorting;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int currentValue = nums.get(i);
            // Делаем j зависимой от i, чтоб руками инкремент дополнительной строкой не делать.
            // Ну и это наш второй указатель, через который мы будем смотреть, что за элемент был ДО текущего
            int j = i - 1;
            // Тут j >= 0 нужен, чтоб вовремя остановить декремент этой шайтан-машины.
            // В ином случае при вызове метода get() вылетаем за пределы листа с индексом -1
            while (j >= 0 && nums.get(j) > currentValue) {
                // Не используем i вместо j + 1 т.к. i у нас остаётся на месте для отслеживания уже отсортированного куска
                // А вот j откатывается назад и проверяет предыдущие элементы
                nums.set(j + 1, nums.get(j));
                j--;
            }
            // Помещаем элемент в правильную относительно текущего i позицию
            nums.set(j + 1, currentValue);
        }
    }
}
