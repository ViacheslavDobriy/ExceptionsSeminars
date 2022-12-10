package DiplomaProject;

public class Application {
    public static void main(String[] args) {
        Data newData = new Data();
        newData.launchButton();

        WriterToFile newWriter = new WriterToFile(newData);
    }
}
