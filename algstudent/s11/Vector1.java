/*
JAVA is sensitive to upper and lower case.
A class should begin with a capital letter.
Methods and all kinds of variables should begin with lower case.
 
Java classes are stored in files with the same as the class, 
(to which we add the .java extension). Vector1.java in this case.

Packages must be in a directory path with the same name, that is,
package alg77777777.s1 should be in the directory alg77777777/s1.
*/

package algstudent.s11;

import java.util.Random ; //It is the class that generates random numbers

/**
 * This program is for working with vectors and see how Java programs work
 */
public class Vector1 {
	static int[] v; //vector of elements
	static int[] w; //another vector of elements

	public static void main(String arg []){
	  int n = Integer.parseInt(arg[0]); //Size of the problem in the first argument
	  v = new int[n];
	  fillIn(v);
	  write(v);	
	  
	  int s = sum(v);
	  System.out.println("THE SUM OF ELEMENTS IS = "+ s);
	  
	  int[] m = new int[2];
	  maximum(v, m);
	  System.out.println("THE MAXIMUM IS IN POSITION = "+ m[0]);
	  System.out.println("THE MAXIMUM IS = "+ m[1]);
	  
	  w = new int[n] ;
	  fillIn(w);
	  write(w);

	  int matches1 = matches1(v, w);
	  System.out.println("Number of matches by quadratic algorithm = " + matches1);
	  int matches2 = matches2(v, w);
	  System.out.println("Number of matches by linear algorithm = " + matches2);
	} 
	
	/**
	 * This method gives random values ​​to a vector of integers. 
	 * It uses the Random class in the java.util package
	 * @param a Vector to be filled in
	 */
	public static void fillIn(int[] a){
	  Random r = new Random();
	  int n = a.length;
	  for(int i=0; i<n; i++)
	     a[i] = r.nextInt(199) - 99; //values between -99 and 99
	}   
	
	/**
	 * This method shows the contents on screen
	 * @param a Vector with numbers
	 */
	public static void write(int[]a) {
	  System.out.println();
	  int n = a.length;
	  for (int i=0; i<n; i++)
	     System.out.println ("ELEMENT " + i + " = " + a[i]);
	  System.out.println();
	}    
	
	/**
	 * This method adds the elements of a vector and returns it
	 * @param a Vector with numbers
	 * @return Addition of all the numbers in the vector
	 */
	public static int sum(int[]a){
	  int s = 0;
	  int n = a.length;
	  for (int i=0; i<n; i++) 
		  s = s+a[i];
	  return s;
	} 

	/** 	
	 * This method calculates the maximum and its position 
	 * and returns them
	 * @param a Vector with numbers
	 * @param m m[0] gives the position of the max value and m[1] gives the max value
	 */
	public static void maximum(int[]a, int[]m){
	  int n = a.length;
	  m[0] = 0; //Initial position for max value
	  m[1] = a[0]; //Initial max value
	  for (int i=1; i<n; i++) //The rest of the elements
	     if (a[i] > m[1]) {
	    	m[0] = i;
	     	m[1] = a[i];
	     }
	} 
	
	/**
	 * This method calculates the number of matches of the input vectors (they are of the same dimension). 
	 * We define a match as the fact that on the same position there is the same value in both vectors. 
	 * In this case it is solved "with the happy idea" of two nested loops
	 * @param a a Vector
	 * @param b another Vector
	 * @return number of matches among values
	 */
	public static int matches1(int[]a, int[]b) {
		int c = 0;
		int n = a.length;
		for (int i=0; i<n; i++)
		    for (int j=0 ;j<n; j++)
	               if (i==j && a[i]==b[j])
	             c++;
	        return c;
	}
	
	/**
	 * This method calculates the number of matches of the input vectors (they are of the same dimension). 
	 * We define a match as the fact that on the same position there is the same value in both vectors. 
	 * In this case it is solved with just one loop.
	 * @param a a Vector
	 * @param b another Vector
	 * @return number of matches among values
	 */
	public static int matches2(int[]a, int[]b) {
		int c = 0;
		int n = a.length;
		for (int i=0; i<n; i++) 
	          if (a[i] == b[i])
	             c++;
	        return c;
	}

}
