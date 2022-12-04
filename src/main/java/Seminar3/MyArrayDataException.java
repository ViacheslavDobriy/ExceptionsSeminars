/*
Мое исключение на случай если не получается распарсить элемент массива.
 */
package Seminar3;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int x, int y) {
        super("Wrong data in the next positions: x = " + x + "; y = " + y);
    }
}
