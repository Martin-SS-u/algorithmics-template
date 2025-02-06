package algstudent.s11;

/**
 * This program serves to measure times of 
 * the addition operation
 */
public class Vector2 {
	static int[] v;
	
	public static void main(String arg []){
	  int n = Integer.parseInt(arg[0]); //Size of the problem
	  v = new int[n];
	  Vector1.fillIn(v);
	  
	  //Measurement of times
	  long t1,t2;
	  t1 = System.currentTimeMillis();	
	  int sum = Vector1.sum(v);
	  t2 = System.currentTimeMillis();
	  
	  System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d\n", n, t2-t1, sum);
	}
} 
