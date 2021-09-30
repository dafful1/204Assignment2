public class QueueUnderflowException extends RuntimeException {

    public QueueUnderflowException() {
        this("Cannot dequeue from a empty queue\n");
    }

    /**
     * @param message Message to be displayed when prompted
     */
    public QueueUnderflowException(String message) {
        super(message);
    }
}
