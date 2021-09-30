/**
 * Exception class
 */
public class InvalidNotationFormatException extends RuntimeException {



public InvalidNotationFormatException() {
        this("The password must contain at least one digit\n");
    }

    /**
     * @param message Message to be displayed when prompted
     */
public InvalidNotationFormatException(String message) {
        super(message);
    }
}

