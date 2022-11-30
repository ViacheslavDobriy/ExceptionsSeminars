/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше
 */
package Homework1;

import java.util.Arrays;

/*
 В этой задаче я бросаю два исключения:
 1) если длины массивов разные;
 2) если элемент второго исходного массива равен нулю, чтобы избежать деления на ноль.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {5,4,2,1,9};
        System.out.println(Arrays.toString(arrayDivideByArray(array1, array2)));
    }

    public static float[] arrayDivideByArray(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            throw new RuntimeException("Lengths of arrays are different!");
        }
        float[] array3 = new float[array1.length];
        for (int i = 0; i < array1.length; i++) {
            if(array2[i] == 0) {
                throw new RuntimeException("Attempt divide by zero!");
            }
            array3[i] = array1[i] / array2[i];
        }
        return array3;
    }
}
