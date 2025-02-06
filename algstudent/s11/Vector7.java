package algstudent.s11;

/**
 * This program serves to measure times automatically increasing 
 * the size of the problem. In addition, we use a repetition value 
 * determined by nTimes, an argument of the program
 */
public class Vector7 {
	static int[]v;
	static int[]b;
	
	public static void main(String arg []) {
		int repetitions = Integer.parseInt(arg[0]);
		long t1,t2;
		int nMatches = 0;
		
		for (int n=10000; n<=Integer.MAX_VALUE; n*=2){ //n is increased *5   
			  v = new int[n];
			  b = new int[n]; 
			  Vector1.fillIn(v);
			  Vector1.fillIn(b);	
			  
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=repetitions; repetition++){    	
				  nMatches = Vector1.matches2(v,b);			     
			  }
			  t2 = System.currentTimeMillis();
			  System.out.printf("SIZE=%d TIME=%d milliseconds NUM_MATCHES=%d NTIMES=%d\n", n, t2-t1, nMatches, repetitions);	
		}//for 
		
	}//main

}
