/*
Дан следующий код:
        public static void main(String[] args) {
            InputStream inputStream;
            try {
                String[] strings = {"asdf", "asdf"};
                test();
                int a = 1/0;
                inputStream = new FileInputStream("asdffdas");
            } catch (Throwable e) {
                e.printStackTrace();
            } catch (StackOverflowError error) {
                System.out.println("asdffdas");
            } finally {
                System.out.println("Finally I was executed");
            }
            System.out.println("I am alive");
        }

        public static void test () throws IOException {
            File file = new File("1");
            file.createNewFile();
            FileReader reader = new FileReader(file);
            reader.read();
            test();
        }
Исправьте код, примените подходящие способы обработки исключений.

 */
package Seminar2;

import java.io.*;

public class Task4 {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            test();
            int a = 1/0;
            inputStream = new FileInputStream("asdffdas");
        } catch (ArithmeticException e) {
            System.out.println("Dont try divide by zero!");
        } catch (FileNotFoundException e) {
            System.out.println("I didnt find file ");
        } catch (IOException e){
            System.out.println("Something wrong with file work");
        } finally {
            System.out.println("Finally I was executed");
        }
        System.out.println("I am alive");
    }

    public static void test () throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
    }
}
