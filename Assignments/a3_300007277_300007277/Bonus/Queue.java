/**
 * Queue Abstract Data Type. A Queue is a linear data structure
 * following first-in-first-out protocol, i.e. the first element
 * that has been added onto the Queue, is the first one to
 * be removed.
 *
 * @author Khang Nguyen
 */

public interface Queue<E> {
	
	    /**
     * Tests if this Queue is empty.
     *
     * @return true if this Queue is empty; and false otherwise.
     */

    public abstract boolean isEmpty();
	
    /**
     * retrieves size of this queue
     * 
     *
     * @return the size of the queue
     */

    public abstract int size();

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return The top element of this queue, or null
     */

    public abstract E dequeue();
	

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
     *
     * @param element the element be put onto the top of this queue.
     */

    public abstract void enqueue( E element );

}