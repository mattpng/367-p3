import java.util.Arrays;

/**
 * GENERAL DIRECTIONS -
 *
 * 1. You may add private data fields and private methods as you see fit.
 * 2. Implement ALL the methods defined in the PriorityQueueADT interface.
 * 3. DO NOT change the name of the methods defined in the PriorityQueueADT interface.
 * 4. DO NOT edit the PriorityQueueADT interface.
 * 5. DO NOT implement a shadow array.
 */



public class MinPQ<E extends Comparable<E>> implements PriorityQueueADT<E>
{
    private E[] items;
    private static final int INITIAL_SIZE = 10;
    
    private int numItems = 0;

    //ADD MORE DATA PRIVATE DATA FIELDS AS YOU NEED.

    public MinPQ()
    {
        this.items = (E[]) new Comparable[INITIAL_SIZE];
        
        // TO-DO: Complete the constructor for any private data fields that you add.
    }
    
    
    /**
     * Checks if the priority queue has any
     * elements and returns true if no elements,
     * false otherwise.
     *
     * @return true if no elements in queue, false otherwise.
     */
    public boolean isEmpty(){
    	return numItems==0;
    }
    /**
     * Adds a data item to the priority queue.
     * Reorders all the other data items in the
     * queue accordingly.
     *
     * If the size if equal to the capacity of the
     * priority queue, double the capacity and then
     * add the new item.
     *
     * @param item the item to add
     * @throws IllegalArgumentException if item is null
     */
     public void insert(E item){
    	boolean done = false;
    	 
     	if (item == null) 
     		throw new IllegalArgumentException();
     	if (numItems == items.length)
     		Arrays.copyOf(items, size() * 2);
     	
     	items[numItems+1] = item;
     	
     	while (!done){
     		
     	}
     	
     	numItems++;
     	
     }
    /**
     * Returns the highest priority item in the priority queue.
     *
     * MinPriorityQueue => it will return the smallest valued element.
     * MaxPriorityQueue => it will return the largest valued element.
     *
     * @return the highest priority item in the priority queue.
     * @throws EmptyQueueException if priority queue is empty.
     */
    public E getMax() throws EmptyQueueException{
    	if (isEmpty())
    		throw new EmptyQueueException();
    	
    	return items[1];
    }

    /**
     * Returns and removes the highest priority item in the priority queue.
     * Reorders all the other data items in the
     * queue accordingly.
     *
     * MinPriorityQueue => it will return and remove the smallest valued element.
     * MaxPriorityQueue => it will return and remove the largest valued element.
     *
     * @return the highest priority item in the priority queue.
     * @throws EmptyQueueException if priority queue is empty.
     */
    public E removeMax() throws EmptyQueueException{
    	// TODO
    }

    /**
     * Returns the number of elements in the priority queue.
     *
     * @return number of elements in the queue.
     */
    public int size(){
		return numItems;
    	
    }
    
}
