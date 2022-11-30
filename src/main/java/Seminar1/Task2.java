/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
(кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
 */
package Seminar1;

public class Task2 {
    public static void main(String[] args) {
        int[][] twoDimArray = {{0,1,0}, {1,0,1}, {1,0,0}};
        System.out.println(checkArray(twoDimArray));
    }

    public static int checkArray(int[][] twoDimArray) {
        if(twoDimArray.length != twoDimArray[0].length) {
            throw new RuntimeException("This array is not square");
        }
        int result = 0;
        for(int i = 0; i < twoDimArray.length; i++) {
            for(int j = 0; j < twoDimArray[i].length; j++) {
                if(twoDimArray[i][j] == 0 || twoDimArray[i][j] == 1) {
                    result += twoDimArray[i][j];
                } else {
                    throw new RuntimeException("There is wrong value in this array");
                }
            }
        }
        return result;
    }
}
