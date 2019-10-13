package by.epam.app.exception;

public class FileIsEmptyException extends RuntimeException {

    public FileIsEmptyException() {
        super();
    }

    public FileIsEmptyException(String message) {
        super(message);
    }
}
