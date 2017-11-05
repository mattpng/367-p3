
public class TestGui 
{
	public static void main(String[] args)
	{
 // Started testing MinPQ, bug expanding array (inserting 10th element)
        
	    MaxPQ<Double> minpq = new MaxPQ<Double>();
    	
    	for (int k=0; k<50; k++)
    	{
    		minpq.insert(2.0 * k);	
    	  	System.out.println(minpq.getMax() + "  " + k); 	
    	}
    	System.out.println("break it up");
    	for(int v=0; v<50; v++)
    	{
    		System.out.println(minpq.removeMax());
    	}
	}
}
