public class StackOverflowException extends  RuntimeException {
    public StackOverflowException() {
        this("Cannot add to a full stack\n");
    }

    /**
     * @param message Message to be displayed when prompted
     */
    public StackOverflowException(String message) {
        super(message);
    }
}
