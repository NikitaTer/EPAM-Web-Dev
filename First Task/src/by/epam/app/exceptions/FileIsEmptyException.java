package by.epam.app.exceptions;

public class FileIsEmptyException extends RuntimeException {

    public FileIsEmptyException() {
    }

    public FileIsEmptyException(String message) {
        super(message);
    }
}
