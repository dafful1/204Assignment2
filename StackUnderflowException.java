public class StackUnderflowException extends  RuntimeException {
    public StackUnderflowException() {
        this("Cannot remove from an empty stack\n");
    }

    /**
     * @param message Message to be displayed when prompted
     */
    public StackUnderflowException(String message) {
        super(message);
    }
}
