/*
Если будет проверяться размер двумерного массива и обнаружится, что размер не 4*4 то здесь описание моего исключения,
которое можно использовать для проброса и уведомления пользователя об ошибочных входных данных
 */
package Seminar3;

public class MyArraySizeException extends Exception{
    public MyArraySizeException() {
        super("Size of array is not 4*4");
    }
}
