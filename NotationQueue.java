import java.util.*;

public class NotationQueue<T>{

    private final int[] arr;
    private final int capacity;
    private int front;
    private int rear;
    private int count;

    NotationQueue(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    /**
     * @param e what is being enqueued
     * @return true if successful, false if not
     */
    public boolean enqueue(T e) {

        if (isFull())
        {
            throw new QueueOverflowException();
        }

        rear = (rear + 1) % capacity;
       // arr[rear] = (int) e;
        count++;
        return true;
    }

    public int size(){
        return count;
    }

    public boolean isFull(){

        if(count>= 5){
            return true;
        }else return false;
    }

    /**
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }else return false;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        front = (front + 1) % capacity;
        count--;
        return (T) "Performed dequeue";
    }

    /**
     * Returns the string representation of the elements in the Queue,
     * the beginning of the string is the front of the queue
     * @return string representation of the Queue with elements
     */
    public String toString(){

        if (isEmpty()) {
            return "Queue is empty!";
        }


        return NotationQueue.class.toString();

    }

    /**
     * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
     * Place the delimiter between all elements of the Queue
     * @return string representation of the Queue with elements separated with the delimiter
     */
    public String toString(String delimiter){

        if (isEmpty()) {
            return "Queue is empty!";
        }



        return NotationQueue.class.toString() + delimiter;

    }

    /**
     * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
     * is the first element in the Queue
     * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
     * list reference within your Queue, you will be allowing direct access to the data of
     * your Queue causing a possible security breech.
     * @param list elements to be added to the Queue
     */
    public void fill(ArrayList<T> list){

        if (isFull())
        {
            throw new QueueOverflowException();
        }

        for (int i = 0; i < list.size(); i++) {
         rear = (rear + 1) % capacity;
               // arr[rear] = (int) list.get(i);
                count++;

        }

    }

}
