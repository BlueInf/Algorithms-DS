import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class CircularArrayRing<E>
 * A list that forgets
 * Data structure which remembers the last N entries
 * Extends AbstractCollection<E>
 * Implements Ring<E>
 *
 * @param <E>
 */
public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

    // Int for the size of the CircularArrayQueue
    private int size;

    // Array of E (Generics) that can hold different Objects
    private E[] array;

    // Int for the tail of the CircularArrayRing
    private int tail;

    /**
     * Constructor for the CircularArrayRing
     * Sets the default size to be 12
     */
    public CircularArrayRing() {

        // Sets the default size to be 12
        this.size = 12;

        // Cast to E[] Type
        array = (E[]) new Object[size];

        // The tail is set to be 0
        tail = 0;

    }

    /**
     * Constructor for the CircularArrayRing
     * Sets the size to be the given size in the argument
     */
    public CircularArrayRing(int size) {

        // Sets the size
        this.size = size;


        // Cast to E[] Type
        array = (E[]) new Object[size];

        // The tail is set to be 0
        tail = 0;

    }


    /**
     * Size method
     * Returns the number of elements of the CircularArrayRing
     *
     * @return
     */
    @Override
    public int size() {

        // We return the size if we do have a element
        if (array[tail % size] != null) return size;

        return tail;

    }

    /**
     * Iterator method
     * Returns an Iterator<E> object
     *
     * @return i
     */
    @Override
    public Iterator iterator() {


        /**
         * We create a new Iterator
         */
        Iterator<E> iterator = new Iterator<E>() {

            /**
             * We set the index of the current Element
             * It is (tail-1) because the iterator iterates backwards from the most recent element added
             */
            int currentE = (tail - 1 + size) % size;


            // The Size of the
            int elementsCounted = 0;

            /**
             * Method hasNext((
             * Returns if we have next element
             */
            @Override
            public boolean hasNext() {
                // If we haven't added any element then we return false
                if (tail == 0 && array[tail] == null) return false;

                // If the  current Element is null then we return false
                if (array[currentE] == null) return false;

                /**
                 *  If the current element is not null but we have reached the size
                 *  Then, the CircularArrayRing is full and we return false
                 */
                if (array[currentE] != null && elementsCounted == size()) return false;

                    // Otherwise, we return the next element
                else return true;
            }

            /**
             * Method next()
             * Returns the nextElement
             */
            @Override
            public E next() {

                // If we have a next Element
                if (hasNext()) {

                    // We get it
                    E element = array[currentE];

                    // The iterator iterates backwards
                    currentE = (currentE - 1 + size) % size;

                    // The currentSize of the Array is also incremented
                    elementsCounted++;


                    // We return the element
                    return element;

                } // Else we throw a NoSuchElementException
                else throw new NoSuchElementException("No such element");
            }


            /**
             * Method Remove throws an UnsupportedOperationException
             * @throws UnsupportedOperationException
             */
            @Override
            public void remove() throws UnsupportedOperationException {
                throw new UnsupportedOperationException("Remove is not supported!!!");
            }
        };

        /** We return the iterator */
        return iterator;
    }

    /**
     * Method gets the last added variables first
     * Get(0) gets the last item you added
     * Get(1) gets the previous item and so on...
     * Throws an IndexOutOfBoundsException if the index is either larger than the number of items added or larger than the ring size
     * @param index
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {

        // If the index is negative or is either larger than the number of items added or larger than the ring size
        if (index < 0 || index > size - 1 || index > size() - 1)

            // It throws an new IndexOutOfBoundsException
            throw new IndexOutOfBoundsException("Ring not big enough");

        // Otherwise, it returns the element
        return array[(tail - index - 1 + size) % size];
    }

    /**
     * Method add
     * Adds an element to the CircularArrayRing
     * @param a
     * @return
     */
    @Override
    public boolean add(Object a) {

        // We insert the element
        array[tail] = (E) a;

        // The tail is incremented and mod is applied in order to fill the array
        tail = (tail + 1) % size;

        // We return true
        return true;

    }
}
