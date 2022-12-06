/*
Реализуйте метод, принимающий в качестве аргументов двумерный массив.
Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
детализировать какие строки со столбцами не требуется.
Как бы вы реализовали подобный метод?
 */
package Seminar1;

public class Task8 {
    public static void main(String[] args) {
        int[][] array = {{1,1,1},{2,2,2},{3,3,3}};
        checkArray(array);
    }

    public static void checkArray(int[][] array) {
        if(array == null) {
            System.out.println("Array is empty");
        } else {
            for (int i = 0; i < array.length; i++) {

                for (int j = 0; j < array[i].length; j++) {
                    if(i == j && array.length == array[i].length) {
                        System.out.printf("I checked %d-row and %d-column, they are the same lengths", i,j);
                    } else if (i == j && array.length != array[i].length) {
                        System.out.printf("I checked %d-row and %d-column, they have different lengths", i,j);
                    }
                }
                System.out.println();
            }
        }
    }
}
