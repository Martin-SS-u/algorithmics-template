package algstudent.s5;

import java.util.Random;

public class MinimumPaths {

	static String[] v; //node vector
	static int[][] weights; //weight matrix
	static int[][] costs; //Floyd's paths cost matrix
	static int[][] p; //predecessor matrix (steps) in Floyd paths
	static int n; // size
	final static int infinite = 10000000;
	final static int empty = -1;
	
	
	final static double p1 = 0.5;
	final static double p2 = 1-p1;
	final static int minWeight = 10;
	final static int maxWeight = 99;
	static Random random = new Random();
	
	
	public static void main(String arg[]) {
		if(arg.length > 0 &&  arg[0] != null) {
			n = Integer.parseInt(arg[0]);
		}else {
			n = 5; //nodes of example graph
		}
		
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;

		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];
		
		fillInWeightsRandom(weights); //weights for the example
		System.out.println("WEIGHT MATRIX IS:");
		printMatrix(weights);

		initializeFloyd(costs, p, weights);
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
					if (costs[source][target] < infinite) {
						System.out.println("MINIMUM COST=" + costs[source][target]);
					}
					System.out.println("**************");
				}
		
		
	}
	
	public static void basicAlgorithm(int n) {
		weights = new int[n][n];
		costs = new int[n][n];
		p = new int[n][n];
		v = new String[n];
		for (int i = 0; i < n; i++)
			v[i] = "NODE" + i;
		
		
		//randomly generating weights
		MinimumPaths.fillInWeightsRandom(weights);
		
		//computing floyd
		MinimumPaths.floyd(weights, costs, p);
		
		//computing the shortest paths
		for (int source = 0; source <= n-1; source++)
			for (int target = 0; target <= n-1; target++)
				if (source != target) {
					minimumPath(v, weights, costs, p, source, target);
				}

	}
	
	/* ITERATIVE WITH CUBIC COMPLEXITY O(n^3) */
	static void floyd(int[][] weights, int[][] costs, int[][] p) {	
		initializeFloyd(costs, p, weights);
		int n = weights.length;
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

	static void initializeFloyd(int[][] costs, int[][] p, int[][] weights) {
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
			path(v,steps,pivot,target);
			System.out.println();
		}		
	}

	/* IT IS RECURSIVE and WORST CASE is O(n), IT IS O(n) if you write all nodes */
	static void path(String[] v, int[][] steps, int i, int j) {
		if(i == -1) {
			System.out.print("-->" + v[j]);
		}else {
			System.out.print("-->" + v[i]);
			if(i != j) {
				int newPivot = p[i][j];
				if(newPivot != -1) {
					path(v,steps,i,newPivot);
					path(v,steps,newPivot,j);
				}
				
				
			}
		}		
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
	
	static void fillInWeightsRandom(int[][] w) {
		for (int i = 0; i < w.length; i++)
			for (int j = 0; j < w.length; j++) {
				if(i==j) {
					w[i][j] = 0;
				}else {
					double prob = Math.random(); // returns in [0,1)
					if(prob < p1) { // prob < 0.5
						w[i][j] = random.nextInt(minWeight, maxWeight+1);
					}else {
						w[i][j] = infinite;
					}
				}				
			}
		
	}
	
	
	
	
}
