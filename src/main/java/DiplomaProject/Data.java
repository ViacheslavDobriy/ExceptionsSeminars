/*
    Этот класс служит для обработки данных
 */
package DiplomaProject;

import java.util.Scanner;

public class Data {

    private String fullString;
    private static final int NUMBER = 6;
    private String surname;
    private String name;
    private String middleName;
    private String dateOfBirth;
    private int phoneNumber;
    private char sex;

    public Data() {
        System.out.println("New data was created...");
    }

    /**
     * This method request for string from user and put this string in fullString value.
     */
    public void setFullString() {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Insert information about person");
        this.fullString = newScanner.nextLine();
    }

    /**
     * Method checkNumberOfWords return:
     * -1 if there are too many data in inserted string
     * -2 if there aren't enough data
     * 0 if user inserted correct number of data
     * @return
     */
    public int checkNumberOfWords() {
        if(this.fullString.split(" ").length > NUMBER) {
            return -1;
        }
        if (this.fullString.split(" ").length < NUMBER) {
            return -2;
        }
        return 0;
    }

    /**
     * This method receive result of checking of user's string and inform user about made mistakes
     * @param resultOfChecking
     */
    public void explainingError(int resultOfChecking) {
        if(resultOfChecking == -1) {
            System.out.println("User insert too many words");
        }
        if(resultOfChecking == -2) {
            System.out.println("User insert too few words");
        }
        if(resultOfChecking == 0) {
            System.out.println("All is fine");
        }
    }
}
