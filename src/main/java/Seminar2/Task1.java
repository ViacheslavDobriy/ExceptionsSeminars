/*
Посмотрите на этот код. Все ли с ним хорошо? Если нет, то скорректируйте его и обоснуйте свое решение.
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] array = new int[10];
            System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
            int index = scanner.nextInt();
            try {
                array[index] = 1;
            } catch(Exception e) {
                System.out.println("Указан индекс за пределами массива");
            }
        }
*/
package Seminar2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
        int index = scanner.nextInt();
        if(index >=0 && index < array.length) {
            array[index] = 1;
        }
        else {
            System.out.println("Введен неверный индекс");
        }
    }
}
