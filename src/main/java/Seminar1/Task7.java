/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен сумме элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */
package Seminar1;

public class Task7 {
    public static void main(String[] args) {
        int[] array1 = {1,0,3,8};
        int[] array2 = {4,5,6};
        int[] result = sumOfArrays(array1,array2);
        if(result == null) {
            System.out.println("Lengths of arrays are different");
        } else {
            for (int arr: result) {
                System.out.printf("%d ", arr);
            }
        }
    }

    public static int[] sumOfArrays(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            return null;
        }
        int[] array = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i] + array2[i];
        }
        return array;
    }
}
