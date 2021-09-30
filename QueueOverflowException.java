public class QueueOverflowException extends  RuntimeException{

    public QueueOverflowException() {
        this("Cannot enqueue into a full queue\n");
    }

    /**
     * @param message Message to be displayed when prompted
     */
    public QueueOverflowException(String message) {
        super(message);
    }
}
