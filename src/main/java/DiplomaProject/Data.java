/*
    Этот класс служит для обработки данных
 */
package DiplomaProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Data {

    private String fullString;
    private final ArrayList<String> parsedString = new ArrayList<>();
    private static final int NUMBER = 6;
    private String surname;
    private String name;
    private String middleName;
    private String dateOfBirth;
    private int phoneNumber;
    private String sex;

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

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
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
     * If user inserted correct number of words there is calling setter for parsedString
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
            setRestFields();
        }
    }

    private void setRestFields() {
        this.parsedString.addAll(Arrays.asList(this.fullString.split(" ")));
        setSex();
        setPhoneNumber();
        setDateOfBirth();
        setName();
    }

    public ArrayList<String> getParsedString() {
        return parsedString;
    }

    /**
     * This method extract sex from string if there is in the ArrayList
     * TODO: throw exception if both condition was ignored
     */
    private void setSex() {
        if (this.parsedString.contains("m")) {
            this.sex = "m";
            this.parsedString.remove("m");
        }
        if (this.parsedString.contains("f")) {
            this.sex = "f";
            this.parsedString.remove("f");
        }
    }

    /**
     * This method extract phoneNumber by trying parseInt(elemOfArrayList)
     * and assign to PhoneNumber field of class Data
     * TODO: throw exception if phoneNumber wasn't detected
     */
    private void setPhoneNumber() {
        for (String strToInt: this.parsedString) {
            try {
                this.phoneNumber = Integer.parseInt(strToInt);
            } catch (Exception ignored) {

            }
        }
        this.parsedString.remove(Integer.toString(this.phoneNumber));
    }

    /**
     * This method extract legal date of birth and
     * assign gotten string to dateOfBirth field of class Data
     * TODO: throw exceptions if dateOfBirth wasn't found or incorrect
     */
    private void setDateOfBirth() {
        String[] checkDate;
        for (String isDateOfBirth: this.parsedString) {
            try {
                checkDate = isDateOfBirth.split("\\.");
                if (checkDate.length == 3 ) {
                    if(Integer.parseInt(checkDate[0]) > 0 && Integer.parseInt(checkDate[0]) < 32) {
                        if(Integer.parseInt(checkDate[1]) > 0 && Integer.parseInt(checkDate[1]) < 13) {
                            if(Integer.parseInt(checkDate[2]) > 0 && Integer.parseInt(checkDate[2]) < 2023) {
                                this.dateOfBirth = isDateOfBirth;
                            }
                        }
                    }
                }
            } catch (Exception ignored) {

            }
        }
        this.parsedString.remove(this.dateOfBirth);
    }

    /**
     * This method compare string with two enums of names.
     * There are enum for male names and for female names
     * Depends on sex program compare with corresponding enum
     * TODO: throw exception if name wasn't found
     */
    private void setName() {
        if (this.sex.equals("m")) {
            for (String isName : this.parsedString) {
                for (int i = 0; i < PopularManName.values().length; i++) {
                    if (isName.equals(PopularManName.values()[i].getName())) {
                        this.name = isName;
                    }
                }
            }
            this.parsedString.remove(this.name);
        }
        if (this.sex.equals("f")) {
            for (String isName : this.parsedString) {
                for (int i = 0; i < PopularWomenName.values().length; i++) {
                    if (isName.equals(PopularWomenName.values()[i].getName())) {
                        this.name = isName;
                    }
                }
            }
            this.parsedString.remove(this.name);
        }
    }
}
