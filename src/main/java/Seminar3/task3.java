/*
 - Создайте класс исключения, который будет выбрасываться при делении на 0.
Исключение должно отображать понятное для пользователя сообщение об ошибке.
 - Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа.
Исключение должно отображать понятное для пользователя сообщение об ошибке
 - Создайте класс исключения, которое будет возникать при попытке открыть несуществующий файл.
Исключение должно отображать понятное для пользователя сообщение об ошибке.
 */
package Seminar3;

import java.io.FileReader;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) {
        try {
            tryRead();
        } catch (ExceptionFileIsNotFound e) {
            System.out.println(e.getMessage());
        }
        Integer[] array = {1,null,3};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new ExceptionNullPointer();
            }
        }
        int a = 10;
        int b = 0;
        if(b == 0) throw new ExceptionDivisionByZero("Divide by zero");
    }

    public static void tryRead() throws ExceptionFileIsNotFound {
        FileReader reader;
        try {
            reader = new FileReader("123.txt");
        } catch (IOException e) {
            throw new ExceptionFileIsNotFound();
        }
    }

}
