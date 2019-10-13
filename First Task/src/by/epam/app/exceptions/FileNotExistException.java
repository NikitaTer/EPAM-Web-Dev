package by.epam.app.exceptions;

public class FileNotExistException extends RuntimeException {

    public FileNotExistException() {
    }

    public FileNotExistException(String message) {
        super(message);
    }
}
