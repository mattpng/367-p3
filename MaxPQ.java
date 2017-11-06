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

public class MaxPQ<E extends Comparable<E>> implements PriorityQueueADT<E>
{
    private E[] items;
    private static final int INITIAL_SIZE = 10;
    private int numItems = 0;
    
    //ADD MORE DATA PRIVATE DATA FIELDS AS YOU NEED.

    public MaxPQ()
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
    	 E tmp;

    	 if (item == null ) 
    		 throw new IllegalArgumentException();
    	 
    	 if (numItems + 1 == items.length)
    	 {
    		items = Arrays.copyOf(items, items.length *2);
    	 }
    	 
    	 items[numItems+1] = item;
    	 int index = numItems+1;
    	 int check = index/2;
 	
    	 while (!done){
    		 
	 		if (index == 1)
	 		{
	 			done = true;
	 			break;
	 		}
	 		
	 		if (item.compareTo(items[check]) > 0)
	 		{
	 			items[index] = items[check];
	 			items[check] = item;
	 			index = check;
	 			check = index/2;
	     		
	 		}else{
	 			done = true;
	 		}	
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
     public E removeMax() throws EmptyQueueException {
     	if (isEmpty() == true){throw new EmptyQueueException();}
     	E tmp = items[1];
     	E tmp2 = null;
     	boolean done = false; 
     	items[1] = items[numItems];
     	
     	int index=1;
     	int swapIndex = 0;
     	
     	while(!done){
     		
     		if (index*2+1 > numItems){
     			done=true;
     			break;
     		}
     		
     		
     		if (tmp.compareTo(items[index*2]) > 0 || tmp.compareTo(items[index*2+1]) > 0 ){
     			if (items[index*2].compareTo(items[index*2+1]) >= 0){
     				swapIndex = index*2;
     			}
     			else{
     				swapIndex = index*2+1;
     			}
     			
     			tmp2 = items[index];
     			items[index] = items[swapIndex];
     			items[swapIndex] = tmp2;
     			index = swapIndex;
     			
     		}
     		else{
     			done=true;
     			break;
     		}
     	}
     
    
     	numItems--;
     	return tmp;

     }
    /**
     * Returns the number of elements in the priority queue.
     *
     * @return number of elements in the queue.
     */
    public int size()
    {
		return numItems;
    }
    
 // To be removed
    public E get(int i){
    	return items[i];
    }
}
