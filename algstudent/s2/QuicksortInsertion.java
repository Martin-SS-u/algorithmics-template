package algstudent.s2;


public class QuicksortInsertion {
	static int[] v;
	/*get the position of the median of the three (left, right and 
	 the element which position is in the center between them, and
	 move the elements to order them */
	public static int median_of_three(int[] a, int left, int right) { 
		int center = (left + right) / 2;
		if (a[left] > a[center])
			Vector.interchange(a, left, center);
		if (a[left] > a[right])
			Vector.interchange(a, left, right);
		if (a[center] > a[right])
			Vector.interchange(a, center, right);
		return center;
	}
	
	public static void quicksortInsertion(int[] a, int k) {
		quicksortInsertion(a, 0, a.length-1, k);
	}
	
	public static void quicksortInsertion(int[] a, int left, int right, int k) {
		int i = left;
		int j = right - 1;
		int pivot;
		
		if(left < right) { //if there is one element it is not necessary
			if (right-left > k){ 
				int center = median_of_three(a, left, right);
				//if there are less than or equal to 3 elements, there are just ordered
				if ((right - left) >= 3){ 
					pivot = a[center]; //choose the pivot
					Vector.interchange(a, center, right); //hide the pivot
	
					do {         
				    	while (a[i] <= pivot && i < right) i++; //first element > pivot
				    	while (a[j] >= pivot && j > left) j--; //first element < pivot
				        if (i < j) Vector.interchange(a, i, j);
				    } while (i < j);   //end while
					
					//we set the position of the pivot
					Vector.interchange(a, i, right);
					
					quicksortInsertion(a, left, i-1, k);
					quicksortInsertion(a, i+1, right, k);
					
				} //if
			} //if
			else {
				insertion(a, left, right);
			}
		}
		
	}
	
	/* Sorting by the Insertion method */
	public static void insertion(int[] a, int left, int right) {
		int j;
		int pivot;
		int n = right;//a.length;
		
		for (int i = left+1 /*1*/; i < n; i++) {
			pivot = a[i];
			j = i-1;
			
			while (j >= left && pivot < a[j]) {
				a[j+1] = a[j];
				j--;
			}
			
			a[j+1] = pivot;
		}
	}


	
	
	public static void main(String arg[]) {
		int n = Integer.parseInt(arg[0]); //size of the problem
		v = new int[n];
		int k = 10;

		Vector.sorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v, k);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.reverseSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v, k);
		System.out.println("SORTED VECTOR");
		Vector.print(v);

		Vector.randomSorted(v);
		System.out.println("VECTOR TO BE SORTED");
		Vector.print(v);
		quicksortInsertion(v, k);
		System.out.println("SORTED VECTOR");
		Vector.print(v);
	} 

}
