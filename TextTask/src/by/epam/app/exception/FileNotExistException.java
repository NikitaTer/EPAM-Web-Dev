package by.epam.app.exception;

public class FileNotExistException extends RuntimeException {

    public FileNotExistException() {
        super();
    }

    public FileNotExistException(String message) {
        super(message);
    }
}
