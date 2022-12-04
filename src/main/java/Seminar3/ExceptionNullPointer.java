package Seminar3;

public class ExceptionNullPointer extends NullPointerException {
    public ExceptionNullPointer() {
        super("Element of array is null");
    }

    public ExceptionNullPointer(String s) {
        super(s);
    }
}
