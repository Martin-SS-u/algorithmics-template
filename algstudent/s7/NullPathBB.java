package algstudent.s7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import algstudent.s7.utils.Heap;
import algstudent.s7.utils.Node;

public class NullPathBB {
	static int size;
	
	public static List<Integer> nodes;
	List<Integer> usedNodes;
	public static int[][] weights;
	static double p1 = 0.5;
	static double p2 = 1 - p1;
	static int objectiveCost = 0;
	static int minWeight = 10;
	static int maxWeight = 99;
	
	boolean found = false;
	int origin;
	int target;
	int pathWeight;
	
	// Branch and Bound
	protected Heap heap; //Nodes to be explored (not used nodes)
	protected Node bestNode; //To save the final node of the best solution
	protected Node rootNode; //Initial node
	protected int pruneLimit; //To prune nodes above this value
	
	public void newNullPathBB(int n) {
		nodes = new ArrayList<Integer>(n);
		heap = new Heap();
		weights = new int[n][n];
		size = n;
		initializeWeights(weights);
		
		nullPathBB();
	}
	
	private void initializeWeights(int[][] weights) {
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
	
	private void nullPathBB() {
		found = false;
		origin = 0;
		target = size-1;
		pathWeight = 0;
		usedNodes = new ArrayList<Integer>(size);
		
		
		
		rootNode = new Node(origin);
		branchAndBound(rootNode);
		
		
		
		//Prints
		System.out.println(nodes);
		printMatrix(weights);
		System.out.println("origin: " + origin + "\ttarget: " + target);
		
		if (!found) {
			System.out.println("THERE IS NO SOLUTION");
			System.out.println(usedNodes);
		}else {
			System.out.println("Total Weight: " + pathWeight);
			System.out.println(usedNodes);
		}				
		
	}

	private void branchAndBound(Node rootNode) {
		heap.insert(rootNode); //first node to be explored
		pruneLimit = rootNode.initialValuePruneLimit();
		while (!heap.empty() && heap.estimateBest() < pruneLimit) {
			Node node = heap.extractBestNode();
			ArrayList<Node> children = node.expand();
			for (Node child : children) {
				if (child.isSolution()) {
					int cost = child.getHeuristicValue();
					if (cost < pruneLimit) {
						pruneLimit = cost;
						bestNode = child;
						found = true;
					}
				}
				else
					if (child.getHeuristicValue() < pruneLimit) {
						heap.insert(child);
						// update heuristic??
					}
			}
		} //while
		
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
