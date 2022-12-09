package DiplomaProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile {
    Data info;

    WriterToFile(Data checkedInfo) {
        this.info = checkedInfo;
        System.out.println("Data is received by writer to file");
        String path = "src/main/java/DiplomaProject/SavedData/" + checkedInfo.getSurname() + ".txt";
        String dataIsReady = "<"+checkedInfo.getSurname()+">"+
                             "<"+checkedInfo.getName()+">"+
                             "<"+checkedInfo.getMiddleName()+">"+
                             "<"+checkedInfo.getDateOfBirth()+">"+
                             "<"+checkedInfo.getPhoneNumber()+">"+
                             "<"+checkedInfo.getSex()+">"+"\n";
        File file = new File(path);

        try(FileWriter fw = new FileWriter(file)){
            System.out.println("File is opened");
            fw.write(dataIsReady);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
