
/** class GraphTester used to measure the run time */
public class GraphTester {

	public static void main(String[] args) {
			
		// We test the run time for Graphs with sizes of 12 to 17
		for(int i=12;i<=17;i++) {
			
		   // We declare and initalize a new graph with size i
		   Graph graph = new Graph(i, 0.5);
		   
		   // time_prev used to measure the time before the call of the method
		   long time_prev = System.nanoTime();
		   Colouring colouring = graph.bestColouring(3);
		   
		   // double time measures the run time calculates the difference between the current time and time_prev in seconds
		   double time = (System.nanoTime()-time_prev)/1000000000.0;
		  
		   graph.show(colouring);
		   
		   System.out.println(i+" "+time);
		   
		   // We assign null to our graph object 
		   graph=null;
		   
		   // We call the garbage collector to collect in order every test to start under the same circumstances
		   System.gc();
		
		}
		
		
	}
	
	
}
