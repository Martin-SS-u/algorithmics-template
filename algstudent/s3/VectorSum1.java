package algstudent.s3;

import java.util.Random; 

/* This program can solve a problem in three ways. 
 * The problem is to calculate the sum of the elements of a vector
 */
public class VectorSum1{
	static int []v;
	
	//MAIN METHOD TO VERIFY PROPER OPERATION
	public static void main (String arg []) {
		int n = Integer.parseInt(arg[0]);
		
		v = new int[n];
		fillIn(v);
		write(v);
		 
		System.out.println("FIRST SOLUTION =" + sum1(v));
		System.out.println("SECOND SOLUTION =" + sum2(v));		
		System.out.println("THIRD SOLUTION =" + sum3(v));
	} 
	
	/* This method gives random values ​​to a vector of integers. 
	 * It uses the Random class, from the java.util package */
	public static void fillIn(int[]a) {
	 Random r= new Random();
	 int n=a.length;
	 for(int i=0;i<n;i++)
	  a[i]= r.nextInt(19)-9; //values between -9 and 9
	}   
	
	/* This method writes the vector */
	public static void write(int[]a) {
	 int n= a.length;
	 for (int i=0; i<n; i++)
	   System.out.print(a[i]+"//");
	 System.out.println();
	}  
	
	/* This method iteratively calculates the sum of 
	 * the vector with linear complexity O(n) */
	public static int sum1(int[]a) {
	 int n= a.length;
	 int s=0;
	 for(int i=0;i<n;i++)
	    s=s+a[i];
	 return s; 
	}    
	
	/* This method recursively calculates the sum of 
	 * the vector with a complexity O(n)
	 * (a=1;b=1;k=0)=>O(n) */
	public static int sum2(int[]a) {
	 return recSust(0,a);
	}    
	
	private static int recSust(int i, int[]a) {
	 if (i==a.length) 
		 return 0;
	 else 
		 return a[i] + recSust(i+1,a);
	} 
	
	/*  This method recursively calculates the sum of 
	 * the vector with a complexity O(n) 
	 * (a=2;b=2;k=0)=>O(n) */
	public static int sum3(int[]a) {
	  return recDiv(0,a.length-1,a);
	}  
	
	private static int recDiv(int left,int right, int[]a) {
	 if (left==right)
		 return a[left];
	 else { 
		 int m = (left+right)/2;
	     return recDiv(left,m,a) + recDiv(m+1,right,a);
	 }
	}  

} 
