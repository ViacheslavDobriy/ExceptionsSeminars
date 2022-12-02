/*
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
package Homework2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(checkOnFloat());
    }

    public static float checkOnFloat() {
        Scanner floatScanner = new Scanner(System.in);
        System.out.println("Insert float");
        String insert = floatScanner.nextLine();
        float result = 0;
        try {
            result = Float.parseFloat(insert);
        } catch (NumberFormatException e) {
            System.out.println("Insert legal float number, try again!");
            checkOnFloat();
        }
        return result;
    }
}
