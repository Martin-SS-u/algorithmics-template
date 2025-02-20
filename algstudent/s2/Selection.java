package algstudent.s2;

/* This program is used to order n elements with a quadratic algorithm
(SELECTION) */
public class Selection {
	static int[] v;

	/* Sorting by the Selection method */
	public static void selection(int[] a) {
		int n = a.length;
		int posMin;
		for (int i = 0; i < n - 1; i++) { //to find the lowest element
			posMin = i;
			for (int j = i + 1; j < n; j++)
				if (a[j] < a[posMin])
					posMin = j;
			Vector.interchange(a, i, posMin); //swap
		} // for
	}

	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		selection(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		selection(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		selection(v);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 

}
