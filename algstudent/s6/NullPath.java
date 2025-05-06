package algstudent.s6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NullPath {
	
	static int size;
	static List<Integer> nodes;
	List<Integer> usedNodes;
	static int[][] weights;
	static double p1 = 0.5;
	static double p2 = 1 - p1;
	static int objectiveCost = 0;
	static int minWeight = 10;
	static int maxWeight = 99;
	
	boolean found = false;
	int origin;
	int target;
	int pathWeight;
	
		
	public void newNullPath(int n) {
		nodes = new ArrayList<Integer>(n);
		weights = new int[n][n];
		size = n;
		initializeWeights(weights);
		
		nullPath();
	}
	
	static void initializeWeights(int[][] weights) {
		Random r = new Random();
		for(int i=0; i< weights.length; i++) {
			nodes.add(i);
			for(int j=0; j< weights.length; j++) {
				if(r.nextDouble() < p1) {
					weights[i][j] = r.nextInt(minWeight, maxWeight+1);
				}else {
					weights[i][j] = r.nextInt(-maxWeight, -(minWeight-1));
				}
			}
		}
	}

	
	private void nullPath() {
		found = false;
		origin = 0;
		target = size-1;
		pathWeight = 0;
		usedNodes = new ArrayList<Integer>(size);
		
		
		usedNodes.add(origin);
		backtracking(origin, target);
		
		
//		//Prints
//		System.out.println(nodes);
//		printMatrix(weights);
//		System.out.println("origin: " + origin + "\ttarget: " + target);
//		
//		if (!found) {
//			System.out.println("THERE IS NO SOLUTION");
//			System.out.println(usedNodes);
//		}else {
//			System.out.println("Total Weight: " + pathWeight);
//			System.out.println(usedNodes);
//		}				
		
	}
	
	void backtracking(int current, int target) {
		if (isSolution(usedNodes)) {
			found = true;
			return;
		}
		
		for(int child=0; child< nodes.size(); child++) {
			if(!found && !usedNodes.contains(nodes.get(child))) {
				if(!(usedNodes.size() == nodes.size()-1)) {
					pathWeight += weights[current][child];
					usedNodes.add(child);
					backtracking(child, target);
					if(!found) {
						pathWeight -= weights[current][child];
						usedNodes.remove((Integer) child);
					}/*else {
						found = true;
						return;
					}*/
				}else {
					pathWeight += weights[current][target];
					usedNodes.add(target);
					if(!found) {
						pathWeight -= weights[current][target];
						usedNodes.remove((Integer) target);
					}/*else {
						found = true;
						return;
					}*/
				}
			}
		}//for all the j children of state
		if (found) {
			return;
		}
	}	
	

	private boolean isSolution(List<Integer> usedNodes) {
		if(!isPathWeightValid()){
			return false;
		}
		else if(usedNodes.size() != nodes.size()) {
			return false;
		}
		else {
			for(int i=0; i< nodes.size(); i++) {
				if(!usedNodes.contains(nodes.get(i))) {
					return false;
				}
			}
		}
		return true;		
	}
	
	private boolean isPathWeightValid() {
		return (pathWeight >= (objectiveCost- maxWeight) && pathWeight <= (objectiveCost + maxWeight));
	}
	
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


