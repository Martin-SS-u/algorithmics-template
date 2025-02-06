package algstudent.s11;

/**
 * This program serves to measure times automatically 
 * increasing the size of the problem
 */
public class Vector3 {
	static int []v;

	public static void main(String arg []) {
		long t1,t2;
		int sum = 0;
		
		for (int n=10; n<=Integer.MAX_VALUE; n*=5) { //n is increased *5   
		  v = new int[n];
		  Vector1.fillIn(v);

		  t1=System.currentTimeMillis();	
		  sum = Vector1.sum(v);
		  t2=System.currentTimeMillis();
		  System.out.printf("SIZE=%d TIME=%d milliseconds SUM=%d\n", n, t2-t1, sum);	
		} //for
	}//main

} 
