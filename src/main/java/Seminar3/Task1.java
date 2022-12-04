/*
Создайте метод doSomething(), который может быть источником одного из типов checked exceptions
(тело самого метода прописывать не обязательно).
Вызовите этот метод из main и обработайте в нем исключение, которое вызвал метод doSomething().
 */
package Seminar3;

public class Task1 {
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (Exception e) {
            System.out.println("I do something! And i was processed!");
        }
    }

    public static void doSomething() throws Exception{

    }
}
