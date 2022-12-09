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
        if(this.fullString.equals("")) {
            System.out.println("You entered nothing");
            setFullString();
        }
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
     * @return - this integer will be used in checkOfNumber() method
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
     * @param resultOfChecking - can't be null, so exception will be extra in this case
     */
    public void explainingError(int resultOfChecking) {
        if(resultOfChecking == -1) {
            throw new LengthOfStringException("User insert too many words");
        }
        if(resultOfChecking == -2) {
            throw new LengthOfStringException("User insert too few words");
        }
        if(resultOfChecking == 0) {
            setRestFields();
        }
    }

    /**
     * This method set values for all fields of Data class in case if there isn't thrown exception
     */
    private void setRestFields() {
        this.parsedString.addAll(Arrays.asList(this.fullString.split(" ")));
        try {
            setSex();
            setPhoneNumber();
            setDateOfBirth();
            setMiddleName();
            setName();
            setSurname();
        } catch (FieldWasNotFoundException e) {
            System.out.println(e.getMessage());
            launchButton();
        }
    }

    /**
     * This method extract sex from string if there is in the ArrayList
     */
    private void setSex() {
        if (this.parsedString.contains("m") || this.parsedString.contains("M")) {
            this.sex = "m";
            this.parsedString.remove("m");
            this.parsedString.remove("M");
        }
        if (this.parsedString.contains("f") || this.parsedString.contains("F")) {
            this.sex = "f";
            this.parsedString.remove("f");
            this.parsedString.remove("F");
        }
        if (this.sex == null) {
            throw new FieldWasNotFoundException("Field sex wasn't found in inserted string" + "\n" + "Try again!");
        }
    }

    /**
     * This method extract phoneNumber by trying parseInt(elemOfArrayList)
     * and assign to PhoneNumber field of class Data
     */
    private void setPhoneNumber() {
        for (String strToInt: this.parsedString) {
            try {
                this.phoneNumber = Integer.parseInt(strToInt);
            } catch (NumberFormatException ignored) {
            }
        }
        if (this.phoneNumber == 0) {
            throw new FieldWasNotFoundException("Field phone number wasn't found in inserted string" + "\n" + "Try again!");
        } else this.parsedString.remove(Integer.toString(this.phoneNumber));
    }

    /**
     * This method extract legal date of birth and
     * assign gotten string to dateOfBirth field of class Data
     * @whereIsMistake has a message for FieldWasNotFoundException class.
     */
    private void setDateOfBirth() {
        String[] checkDate;
        String whereIsMistake = "";
        for (String isDateOfBirth: this.parsedString) {
            try {
                checkDate = isDateOfBirth.split("\\.");
                if (checkDate.length == 3 ) {
                    if(Integer.parseInt(checkDate[0]) > 0 && Integer.parseInt(checkDate[0]) < 32) {
                        if(Integer.parseInt(checkDate[1]) > 0 && Integer.parseInt(checkDate[1]) < 13) {
                            if(Integer.parseInt(checkDate[2]) > 0 && Integer.parseInt(checkDate[2]) < 2023) {
                                this.dateOfBirth = isDateOfBirth;
                            } else whereIsMistake = "wrong value of year of birth - 'yyyy'";
                        } else whereIsMistake = "Wrong value of month of birth - 'mm'";
                    } else whereIsMistake = "Wrong value of birthday - 'dd'";
                } else whereIsMistake = "String wasn't found satisfying condition dd.mm.yyyy";
            } catch (NumberFormatException ignored) {
            }
        }
        if(this.dateOfBirth == null) {
            throw new FieldWasNotFoundException(whereIsMistake + "\n" + "Try again!");
        } else this.parsedString.remove(this.dateOfBirth);
    }

    /**
     * This method compare string with two enums of names.
     * There are enum for male names and for female names
     * Depends on sex program compare with corresponding enum
     */
    private void setName() {
        if (this.sex.equals("m")) {
            for (String isName : this.parsedString) {
                for (int i = 0; i < PopularManName.values().length; i++) {
                    if (isName.equalsIgnoreCase(PopularManName.values()[i].getName())) {
                        this.name = PopularManName.values()[i].getName();
                    }
                }
            }
        }
        if (this.sex.equals("f")) {
            for (String isName : this.parsedString) {
                for (int i = 0; i < PopularWomenName.values().length; i++) {
                    if (isName.equalsIgnoreCase(PopularWomenName.values()[i].getName())) {
                        this.name = PopularWomenName.values()[i].getName();
                    }
                }
            }
        }
        if (this.name == null) {
            throw new FieldWasNotFoundException("Field name wasn't detected in inserted string" + "\n" + "Try again!");
        } else this.parsedString.remove(this.name);
    }

    /**
     * This method extract middle name from ArrayList relying on the logic that:
     * women have 'vna' at the end of middle name AND 'hna' if middle name is 'Ili'inichna'
     * men have 'ich' at the of middle name
     */
    private void setMiddleName() {
        String[] checkMiddleName;
        for (String isMiddleName: this.parsedString) {
            checkMiddleName = isMiddleName.split("");
            if(this.sex.equals("f") && checkMiddleName[checkMiddleName.length-1].equalsIgnoreCase("a") && checkMiddleName[checkMiddleName.length-2].equalsIgnoreCase("n") && checkMiddleName[checkMiddleName.length-3].equalsIgnoreCase("v")) {
//                isMiddleName.toLowerCase()
                this.middleName = isMiddleName.toLowerCase().toUpperCase();
            }
            if(this.sex.equals("f") && checkMiddleName[checkMiddleName.length-1].equalsIgnoreCase("a") && checkMiddleName[checkMiddleName.length-2].equalsIgnoreCase("n") && checkMiddleName[checkMiddleName.length-3].equalsIgnoreCase("h")) {
                this.middleName = isMiddleName;
            }
            if(this.sex.equals("m") && checkMiddleName[checkMiddleName.length-1].equalsIgnoreCase("h") && checkMiddleName[checkMiddleName.length-2].equalsIgnoreCase("c") && checkMiddleName[checkMiddleName.length-3].equalsIgnoreCase("i")) {
                this.middleName = isMiddleName;
            }
        }
        if (this.middleName == null) {
            throw new FieldWasNotFoundException("Field middle name wasn't detected in inserted string" + "\n" + "Try again!");
        } else this.parsedString.remove(this.middleName);
    }

    /**
     * This is the last method for extracting, that's why program just assign
     * the last elem of ArrayList to field surname
     */
    private void setSurname() {
        this.surname = this.parsedString.remove(0);
    }

    /**
     * This method is a button for launching application
     */
    public void launchButton() {
        setFullString();
        explainingError(checkNumberOfWords());
    }

    @Override
    public String toString() {
        return  "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", sex='" + sex + '\'';
    }
}
