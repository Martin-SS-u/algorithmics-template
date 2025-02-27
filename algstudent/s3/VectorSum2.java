package algstudent.s3;

/* This program serves to measure times automatically increasing the size of 
 * the problem (n) and also using a time scale determined by nTimes, 
 * which is taken from the argument arg[1] 
 * It also gets as an execution argument (arg[0]) the sum method on which
 * we will focus the measurement (options 1,2,3 respectively) 
 */
public class VectorSum2 {
	static int []v;
	
	public static void main (String arg []) {
		int nTimes = Integer.parseInt(arg[1]); 
		int option = Integer.parseInt(arg[0]);
		int sum = 0;
		long t1,t2;
		
		for(int n=3; n<= 100000; n*=2) { // n is incremented by *2  
			v = new int[n];
			VectorSum1.fillIn(v);
			  
			if (option==1) { //sum1
				  t1=System.currentTimeMillis();
				  
				  for (int repetition=1;repetition<=nTimes;repetition++)	
					  sum = VectorSum1.sum1(v);
				  t2=System.currentTimeMillis();
				
				  System.out.println ("SIZE = "+n+"**"+"TIME = "+(t2-t1)+"**"+" nTimes = "+ nTimes + " SUM = " + sum);   
			} //if
			else if (option==2) { //sum2
				  t1=System.currentTimeMillis();
				  
				  for (int repetition=1;repetition<=nTimes;repetition++)	
					  sum = VectorSum1.sum2(v);
				  
				  t2=System.currentTimeMillis();
				 
				  System.out.println ("SIZE = "+n+"**"+"TIME = "+(t2-t1)+"**"+" nTimes = "+ nTimes + " SUM = " + sum);   
			} //if
			else if (option==3) { //sum3
				  t1=System.currentTimeMillis();
				 
				  for (int repetition=1;repetition<=nTimes;repetition++)
					  sum = VectorSum1.sum3(v);
				  
				  t2=System.currentTimeMillis();
				 
				  System.out.println ("SIZE = "+n+"**"+"TIME = "+(t2-t1)+"**"+" nTimes = "+ nTimes + " SUM = " + sum);   
			} //if 
			else System.out.println ("INCORRECT OPTION"); 		
		} //for of size n 
	} //main
	
} 
