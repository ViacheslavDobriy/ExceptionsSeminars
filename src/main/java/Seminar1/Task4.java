/*
Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
Метод должен пройтись по каждому элементу и проверить что он не равен null.
А теперь реализуйте следующую логику:
Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 */
package Seminar1;
public class Task4 {
    public static void main(String[] args) {
        Integer[] array = {0,1,2,3,4,6,7};
        messageToUser(checkArray(array));
    }

    public static int[] checkArray(Integer[] arr) {
        int[] exceptions = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                exceptions[i] = i;
            }
        }
        return exceptions;
    }

    public static void messageToUser(int[] exceptions) {
        String result = " ";
        for (int i = 0; i < exceptions.length; i++) {
            if(exceptions[i] != 0) {
                result +=  exceptions[i];
                result += " ";
            }
        }
        if(result != " ") {
            throw new RuntimeException("Nulls are in next positions" + result);
        } else {
            System.out.println("There is no null in this array");
        }
    }
}
