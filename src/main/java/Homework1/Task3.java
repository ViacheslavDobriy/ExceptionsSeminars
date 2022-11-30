/*
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
package Homework1;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,4,3,2,1};
        System.out.println(Arrays.toString(arrayMinusArray(array1, array2)));
    }

    public static int[] arrayMinusArray(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            throw new RuntimeException("Lengths of arrays are different!");
        }
        int[] array3 = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i] - array2[i];
        }
        return array3;
    }
}
