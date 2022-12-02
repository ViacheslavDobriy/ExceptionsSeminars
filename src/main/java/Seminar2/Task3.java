/*
Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
(либо HashMap, если студенты с ним знакомы).
В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?,
заменить его на соответствующее число.
Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
Записать в тот же файл данные с замененными символами ?
 */
package Seminar2;
import java.io.*;
import java.util.Objects;

public class Task3 {
    public static void main(String[] args) {
        writeToFile();
        String[][] array = saveToArray();
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s ", array[i][0]);
            for (int j = 1; j < array[i].length; j++) {
                System.out.printf("%s", array[i][j]);
            }
            System.out.println();
        }
    }

    public static void writeToFile() {
        try (FileWriter writer = new FileWriter("text.txt")){
            writer.write("Анна=4\nЕлена=5\nМарина=6\nВладимир=?\nКонстантин=?\nИван=4");
        } catch (IOException e) {
            System.out.println("error occurred");
        }
    }

    public static String[][] saveToArray() {
        String[][] array = new String[6][2];
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))){
            String line;
            while((line = br.readLine()) != null) {
                String[] arr = line.split("=");
                if(Objects.equals(arr[1], "?")) {
                    arr[1] = String.valueOf(arr[0].length());
                }
                    array[i][0] = arr[0];
                    array[i][1] = arr[1];
                    i++;
            }
        } catch (IOException e) {
            System.out.println("File is not readed");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds Exception");
        }
        return array;
    }
}
