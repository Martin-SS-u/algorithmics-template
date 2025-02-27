package algstudent.s2;

import java.util.Random;

/* Utility class, which generates the 3 orders for a vector
Also writes the content of a vector */
public class Vector {
	/* This method returns already sorted values */
	public static void sorted(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			a[i] = i;
	}

	/* This method gives values sorted in reverse order */
	public static void reverseSorted(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++)
			a[i] = n - i - 1;
	}

	/* This method gives random values to a vector of integers, it uses the Random class from the java.util package */
	public static void randomSorted(int[] a) {
		Random r = new Random();
		int n = a.length;
		for (int i = 0; i < n; i++)
			a[i] = r.nextInt(100000);
	}

	/* This method writes the components of the vector */
	public static void print(int[] a) {
		int n = a.length;
		System.out.print("(");
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + ", ");
		System.out.println(")");
	}
	
	/* This method swaps the values at positions i and j */
	public static void interchange(int[] a, int i, int j) {
		int t;
		t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

}
