/*
Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
package Homework2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        talkToUser();
    }

    public static void talkToUser() {
        Scanner forUser = new Scanner(System.in);
        String inserting = forUser.nextLine();
        while (!inserting.equals("")) {
            System.out.println("Keep going!");
            inserting = forUser.nextLine();
        }
        throw new RuntimeException("Don't insert empty strings. It is prohibited in this program!");
    }
}
