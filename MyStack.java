import java.util.ArrayList;
import java.util.Stack;

public class MyStack<T> {

    MyStack(int size){

    }


    int size = 0;
    Stack<String> myStack = new Stack<String>();

    public boolean isEmpty() {
        if (myStack.size() > 0) {
            return true;
        } else return false;
    }


    /**
     * . The element is popped from the top of the stack and is removed from the same.
     */
    public T pop() {
        if (myStack.isEmpty()) {
            throw new StackUnderflowException();
        } else {
            T element = (T) myStack.peek();
            myStack.pop();
            size--;
            return element;
        }
    }


    /**
     * method is used to push an element into the Stack. The element gets pushed onto the top of the Stack.
     * Returns true if operation is successful
     *
     * @param e the string to add to the stack
     */
    public boolean push(T e) {
        if (myStack.size() > 5) {
            throw new StackOverflowException();
        } else {
            myStack.push((String) e);
            size++;
            return true;
        }
    }

    /**
     * Checks if the stack is full
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        if (myStack.size() <= 5) {
            return false;
        } else return true;
    }

    /**
     * Takes a peek into the top of the stack without removing the first element
     *
     * @return the first element
     */
    public T top() {
        return (T) myStack.peek();
    }

    /**
     * Checks for the size of the stack
     *
     * @return the size of the stack
     */
    public int size() {
        return size;
    }


    /**
     * @return the toString of the stack
     */
    public String toString() {

        if (myStack.isEmpty()) {
            return "Stack is empty!";
        }


        String a = myStack.peek();
        String result = "";

        // Pop the top element of the stack
        myStack.pop();

        // Recursively call the function PrintStack
        toString(String.valueOf(myStack));

        // Print the stack element starting
        // from the bottom

        result= a + " ";

        // Push the same element onto the stack
        // to preserve the order
        myStack.push(a);
        return result;
    }


    /**
     * Returns the string representation of the elements in the Stack, the beginning of the
     * string is the bottom of the stack
     * Place the delimiter between all elements of the Stack
     * @return string representation of the Stack from bottom to top with elements
     * separated with the delimiter
     */
    public String toString(String delimiter) {
        if (myStack.isEmpty()) {
            return "Stack is empty!";
        }


        String a = myStack.peek();
        String result = "";


        myStack.pop();


        toString(String.valueOf(myStack));



        result= a + delimiter;


        myStack.push(a);
        return result;

    }

    /**
     * Fills the stack with whatever is in the array list Fill
     *
     * @param fill the arraylist to fill the stack
     */
    public void fill(ArrayList<String> fill) {
        for (int i = 0; i < fill.size(); i++) {
            myStack.push(String.valueOf(i));
        }
    }
}
