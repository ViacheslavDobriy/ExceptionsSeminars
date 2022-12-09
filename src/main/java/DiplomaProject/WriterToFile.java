/**
 * This class get data from class data which has already processed and put it in corresponding file
 */
package DiplomaProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {
    Data info;
    String path;
    String dataIsReady;

    /**
     * Constructor checking the existence of the file
     * Depends on existence will be launched creating new file and writing ot updating file with new data
     * @param checkedInfo - data which has been checked for exceptions
     */
    WriterToFile(Data checkedInfo) {
        this.info = checkedInfo;
        this.path = "src/main/java/DiplomaProject/SavedData/" + this.info.getSurname() + ".txt";
        this.dataIsReady = buildData();
        System.out.println("Data is received by writer to file");
        if(!isFileExist()) {
            writeToFile();
        } else appendToFile();
    }

    /**
     * Method which create file and write to the new file a new data
     */
    private void writeToFile() {
        File file = new File(this.path);
        try(FileWriter fw = new FileWriter(file)){
            System.out.println("File is opened");
            fw.write(this.dataIsReady);
            System.out.println("data is written to new file: " + this.info.getSurname() + ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method which update existence file
     */
    private void appendToFile() {
        File file = new File(this.path);
        try(FileWriter fw = new FileWriter(file,true)){
            fw.write(this.dataIsReady);
            System.out.println("File " + info.getSurname() + ".txt was updated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method check existence of file with name which has a surname from new @info type of Data
     * @return - true or false
     */
    private boolean isFileExist() {
        File file = new File(this.path);
        return file.exists();
    }

    /**
     * Method build string for putting it in the file
     * @return data type of String
     */
    private String buildData() {
        return "<"+this.info.getSurname()+">"+
                "<"+this.info.getName()+">"+
                "<"+this.info.getMiddleName()+">"+
                "<"+this.info.getDateOfBirth()+">"+
                "<"+this.info.getPhoneNumber()+">"+
                "<"+this.info.getSex()+">"+"\n";
    }
}
