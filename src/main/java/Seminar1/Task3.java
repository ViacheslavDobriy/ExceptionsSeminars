/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения:
метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
и в каждой ячейке может лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен вернуть код ошибки.
Программа должна корректно обработать код ошибки и вывести соответствующее сообщение пользователю.
Сравнить такой вариант обработки исключений с предыдущим.
Какое преимущество у исключений перед кодами ошибок вы можете назвать в данном случае?
 */
package Seminar1;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = {{0,1,0},{0,1,1},{0,1,0}};
        int result = sumOfElem(array);
        if(result == -1) {
            System.out.println("This array is not two-dimensional");
        } else if (result == -2) {
            System.out.println("This array stores not only 0 and 1");
        } else System.out.println(result);
    }

    public static int sumOfElem(int[][] array) {
        if(array.length != array[0].length) {
            return -1;
        }
        int sum = 0;
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt != 0 && anInt != 1) {
                    return -2;
                }
                sum += anInt;
            }
        }
        return sum;
    }
}
