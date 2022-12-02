/*
Если необходимо, исправьте данный код
try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}

 */
package Homework2;

public class Task2 {
    public static void main(String[] args) {
        int[] newArray = {1,2,3,4,5,6,7,8,9,0};
        weirdCode(newArray);
    }

    public static void weirdCode(int[] Array) {
        try {
            int d = 1;
            double catchedRes1 = Array[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Too small array actually");
        }
    }
}
