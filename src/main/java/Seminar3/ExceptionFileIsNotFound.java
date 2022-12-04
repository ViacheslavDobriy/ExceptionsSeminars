package Seminar3;

import java.io.FileNotFoundException;

public class ExceptionFileIsNotFound extends FileNotFoundException {

    public ExceptionFileIsNotFound() {
        System.out.println("File is not found");
    }
}
