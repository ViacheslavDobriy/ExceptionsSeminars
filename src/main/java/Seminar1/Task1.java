/*
Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
Метод ищет в массиве заданное значение и возвращает его индекс.
При этом, например:
 - если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
 - если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
 - если вместо массива пришел null, метод вернет -3
придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
Напишите метод, в котором реализуйте взаимодействие с пользователем.
То есть, этот метод запросит искомое число у пользователя, вызовет первый,
обработает возвращенное значение и покажет читаемый результат пользователю.
Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
 */
package Seminar1;

public class Task1 {
    public static final int MIN_LENGTH = 5;

    public static void main(String[] args) {
        int[] array = null;
        messageToUser(checkArray(array, 10));
    }

    public static int checkArray(int[] array, int number) {
        if(array != null) {
            if(array.length >= MIN_LENGTH) {
                for(int i = 0; i < array.length; i++) {
                    if(array[i] == number) {
                        return i;
                    }
                }
                return -2;
            }
            return -1;
        }
        return -3;
    }

    public static void messageToUser(int number) {
        if(number == -1) {
            System.out.println("Array is too short");
        }
        if(number == -2) {
            System.out.println("Number is not found in this array");
        }
        if(number == -3) {
            System.out.println("Array is null");
        }
        if(number != -1 && number != -2 && number != -3) {
            System.out.println(number);
        }
    }
}
