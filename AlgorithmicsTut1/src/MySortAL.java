import java.io.*;
import java.util.*;

public class MySortAL
{
    public static void main(String [] args )
    {
	//int N = Integer.parseInt(args[0]);
    int N=10000000;
	List<Double> data = new ArrayList<Double>(N);
	for (int i=0; i<N; i++)
	    data.add(Math.random());
	
	long time_prev = System.nanoTime();
	Collections.sort(data);
	double time = (System.nanoTime()-time_prev)/1000000000.0;
	System.out.println(time);
	
	///for (double d: data)
	   // System.out.println(d);
    //}
    }
    
}