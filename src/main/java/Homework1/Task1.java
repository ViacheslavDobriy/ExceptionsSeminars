/*
Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */
package Homework1;

/**
 * Если переменную b сделать равной 0, то вылетит первый Exception.
 * Если результат деления a на b будет больше 6, то вылетит второй Exception.
 * Если результатом выборки из массива во втором методе будут слова "student" или "GeekBrains", то вылетит третий Exception
 */
public class Task1 {
    public static void main(String[] args) {
        SpellMyWord(takeWordFromArray(divisionTwoNumbers(2,3)));
    }

    public static int divisionTwoNumbers (int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Trying divide by zero");
        }
        return a/b;
    }

    public static String takeWordFromArray (int resultOfDivision) {
        String[] phrase = {"Slava", "is", "student", "of", "GeekBrains", "!"};
        if (resultOfDivision >= phrase.length) {
            throw new RuntimeException("Result of division is too big! Out of bounds of array!");
        }
        return phrase[resultOfDivision];
    }

    public static void SpellMyWord (String word) {
        if (word.split("").length > 5) {
            throw new RuntimeException("There is too big word for spelling!");
        }
        String[] spellingWord = new String[5];
        for (int i = 0; i < word.split("").length; i++) {
            spellingWord[i] = word.split("")[i];
        }
        for (int i = 0; i < spellingWord.length; i++) {
            System.out.printf("%s ", spellingWord[i]);
        }
    }
}
