import java.util.NoSuchElementException;

/**
 * Class CircularArrayQueue
 * Implements MyQueue
 */
public class CircularArrayQueue implements MyQueue {


    // Int for the size of the CircularArrayQueue
    private int size;

    //Int for the head of the CircularArrayQueue
    private int head;

    // Int for the tail of the CircularArrayQueue
    private int tail;

    // Array of the Integer object that holds the integer
    private Integer[] array;


    /**
     * Constructor for the CircularArrayQueue
     * Sets the default size to be 1024
     */
    public CircularArrayQueue() {

        // Setting the initial size
        this.size = 1024;

        // Creating the array with the given size
        array = new Integer[size];

        // Setting the initial values of the head and the tail
        head = 0;
        tail = 0;
    }

    /**
     * Constructor for CircularArrayQueue with given size
     *
     * @param size
     */
    public CircularArrayQueue(int size) {

        // Setting the size
        this.size = size;

        // Creating the array with the given size
        array = new Integer[size];

        // Setting the initial values of the head and the tial
        head = 0;
        tail = 0;
    }

    /**
     * Enqueue method
     * We put the int in into the queue
     * w
     *
     * @param in
     */
    @Override
    public void enqueue(int in) {

        /**
         * If there is no space to insert element
         */
        if (getCapacityLeft() == 0 && array[tail] != null) {

            // We create a newArray with doubled size
            Integer[] newArr = new Integer[size * 2];

            /**
             * We copy the elements from the previous Array
             * But in the order as they were inserted
             * We keep the order because we dequeue from the last array
             */
            for (int i = 0; i < size; i++) {

                // We dequeue
                newArr[i] = this.dequeue();

            }

            // Show a message that we are resizing the Array
            System.out.println("Resizing......... ARRAY");

            // The array is now resized
            array = newArr;

            /**
             * And the tail is equal to the size
             * Then we add the new element to the tail
             */
            tail = size;
            array[tail] = in;

            /** The head points to the first element */
            head = 0;

            /** We update the size as it is doubled */
            size *= 2;

            /** The tail is also updated to the next index */
            tail = (tail + 1) % size;

        } else {

            /**
             * Else we have enough space
             * We insert the element at the tail
             * And the tail is incremented by now and mod is applied
             * In that way we can be sure that the array will be filled before resized
             */
            array[tail] = in;
            tail = (tail + 1) % size;
        }

    }

    /**
     * Dequeue follows the same methodology as enqueue
     *
     * @return
     * @throws NoSuchElementException
     */
    @Override
    public int dequeue() throws NoSuchElementException {

        // The element to be returned
        int element;

        // If we have an element we return it
        if (array[head] != null) element = array[head];

        else {
            // Otherwise, we throw new NoSuchElementException
            throw new NoSuchElementException();
        }

        // The head is then set to be null
        array[head] = null;

        /**
         * And the head is advanced to show the next element
         * Again mod is applied because it is a circular array
         */

        head = (head + 1) % size;

        // We return the element
        return element;

    }

    /**
     * Method noItems()
     * Return the number of elements
     *
     * @return
     */
    @Override
    public int noItems() {

        // If the head is equal to the tail and it is null then the circular array is empty
        if (head == tail && array[head] == null) return 0;
            // Otherwise
        else {

            /**
             * If the head is equal to the tail and the element pointed by them is not null
             * Then, the array is full and we return the size
             */
            if (head == tail && array[head] != null) return size;
            else {

                // Otherwise, we calculate the number of elements
                return (size - head + tail) % size;

            }
        }
    }

    /**
     * Method isEmpty
     * Return true if it is empty
     * Otherwise, it returns false
     */
    @Override
    public boolean isEmpty() {

        /**
         * If the head is equal to the tail and the element pointed by them is null
         * Then, the array is empty and we return true
         */
        if (head == tail && array[head] == null) return true;

        // Otherwise, we return false
        else return false;
    }

    /**
     * Method getCapacityLeft
     * Returns the number of elements we can insert before the CircularArray is full
     */
    public int getCapacityLeft() {
        return (size - noItems()) % size;
    }
}
