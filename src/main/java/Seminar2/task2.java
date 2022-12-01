/*
Обработайте возможные исключительные ситуации. “Битые” значения в исходном массиве считайте нулями.
Можно внести в код правки, которые считаете необходимыми.
        public static int sum2d(String[][] array) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < 5; j++) {
                    int val = Integer.parseInt(array[i][j]);
                    sum += val;
                }
            }
            return sum;
        }
 */
package Seminar2;

public class task2 {
    public static void main(String[] args) {
        String[][] array = {{"1","3","100","5"},{"ds","r4","2"}};
        System.out.println(sum2d(array));
    }

    public static int sum2d(String[][] array) {
        if (array == null) {
            throw new RuntimeException("Array is null");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int val = Integer.parseInt(array[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException was found");
                }
            }
        }
        return sum;
    }
}
