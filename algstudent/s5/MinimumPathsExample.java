package algstudent.s5;

//MINIMUM PATHS IN A GRAPH BY FLOYD-WARSHALL
//IT IS A SOLUTION BY DYNAMIC PROGRAMMING
//ITS TIME COMPLEXITY IS CUBIC O(n^3)
public class MinimumPathsExample {
	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths
	final static int infinite = 10000000;
	final static int empty = -1;

	public static void main(String arg[]) {
		int n = 5; //nodes of example graph
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];

		fillInWeights(weights); //weights for the example
		System.out.println("WEIGHT MATRIX IS:");
		printMatrix(weights);

		initializeFloyd(costs, p);
		floyd(weights, costs, p);

		System.out.println("MINIMUM COST MATRIX IS:");
		printMatrix(costs);

		System.out.println("P MATRIX IS:");
		printMatrix(p);

		System.out.println();
		System.out.println("MINIMUM PATHS IN THE EXAMPLE GRAPH (for every pair of different nodes):");
		System.out.println();
		for (int source = 0; source <= n-1; source++)
			for (int target = 0; target <= n-1; target++)
				if (source != target) {
					System.out.print("FROM " + v[source] + " TO " + v[target] + " = ");
					minimumPath(v, weights, costs, p, source, target);
					if (costs[source][target] < infinite)
						System.out.println("MINIMUM COST=" + costs[source][target]);
					System.out.println("**************");
				}

	}

	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {
		
		int n = weights.length;
		System.out.println("COMPLETE THIS METHOD");
		for(int pivot=0 ; pivot<n ; pivot++) {
			for(int source=0 ; source<n ; source++) {
				for(int target=0 ; target<n ; target++) {					
					int pivotCost = costs[source][pivot] + costs[pivot][target];
					
					if(pivotCost < costs[source][target]) {
						costs[source][target] = pivotCost;
						p[source][target] = pivot;
					}					
				}
			}
		}
		
	}

	static void initializeFloyd(int[][] costs, int[][] p) {
		for (int i = 0; i < costs.length; i++) {
			for (int j = 0; j < costs.length; j++) {
				costs[i][j] = weights[i][j];
				p[i][j] = empty;
			}
		}	
	}

	static void minimumPath(String[] v, int[][] weights, int[][] costs, int[][] steps, int source, int target) {
		int pivot = p[source][target];
		if(costs[source][target] == infinite) {
			System.out.println("THERE IS NO PATH");
		}else {
			System.out.print(v[source]);
			path(v,steps,source,target);
			System.out.println();
		}		
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if(i == -1) {
			System.out.print("-->" + v[j]);
		}else {
			//System.out.print("-->" + v[i]);
			if(i != j) {
				int newPivot = p[i][j];
				if(newPivot != -1) {
					path(v,steps,i,newPivot);
					
				}
				path(v,steps,newPivot,j);
			}
		}
		
	}

	/* load the example cost matrix */
	static void fillInWeights(int[][] w) {
		for (int i = 0; i < w.length; i++)
			for (int j = 0; j < w.length; j++) {
				w[i][j] = infinite;
				if(i==j) {
					w[i][j] = 0;
				}
			}
				
		w[0][1] = 19;
		w[0][2] = 10;
		w[1][2] = 20;
		w[2][1] = 19;
		w[2][3] = 14;
		w[3][0] = 27;
		w[3][1] = 67;
	    w[3][2] = 21;
		w[4][1] = 80;
	}
	
	/* print the cost matrix */
	static void printMatrix(int[][] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(String.format("%10s", a[i][j]));
			System.out.println();
		}
		System.out.println();
	}

}