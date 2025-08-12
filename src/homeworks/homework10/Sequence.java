package homeworks.homework10;

import java.util.Arrays;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {
        // Используем временный массив максимального размера
        int[] temp = new int[array.length];
        int counter = 0;

        // Проходим по всем элементам массива
        for (int element : array) {
            if (condition.isOk(element)) {
                temp[counter] = element;
                counter++;
            }
        }

        // Возвращаем массив точного размера
        return Arrays.copyOf(temp, counter);
    }
}