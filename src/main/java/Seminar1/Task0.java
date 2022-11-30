/*
 - Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
 - Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
 в качестве кода ошибки, иначе - длину массива.
 */
package Seminar1;

public class Task0 {
    public static final int MIN_LENGTH = 3;

    public static void main(String[] args) {
        int[] array = {1,4, 5, 2};

        System.out.println(checkArrayLength(array));
    }

    public static int checkArrayLength(int[] array) {
        if(array != null) {
            if(array.length >= MIN_LENGTH) {
                return array.length;
            }
            return -1;
        }
        return -2;
    }
}
