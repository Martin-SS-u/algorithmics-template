package algstudent.s7.utils;

import java.util.ArrayList;
import java.util.UUID;

import algstudent.s7.NullPathBB;

/**
 * To represents the different states of a problem in the graph
 * For each problem, we should extend this class with specific information
 * We also need to compare Nodes because it is the way to compare them in the priority queue
 * @author viceg
 */
public class Node implements Comparable<Node> {
    protected int depth; //Number of moves made so far (is equal to the number of nodes developed) on this branch
    protected UUID parentID; //Parent ID for node tracking
    protected UUID ID; //ID for the node
    protected int heuristicValue; //Value of the calculated heuristic

    int i;
    /**
     * Constructor for Node objects
     */
	public Node(int i) { //Values by default
    	depth = 0; 
    	parentID = null; //It does not have parent unless we say another thing
    	ID = UUID.randomUUID();
    	
    	this.i = i;
		calculateHeuristicValue();
	}
	
	/**
	 * Getter for depth
	 * @return The depth variable
	 */
    public int getDepth() {return depth;}
	  
    /**
     * Getter for heuristicValue
     * @return The heuristicValue variable
     */
	public int getHeuristicValue() { return heuristicValue; }
	
	/**
	 * Compares whether two nodes are equal using the ToString method
	 * @param n Another node to be compared with
	 * @return True if there are equal. False otherwise
	 */
    public boolean equals(Node n) {
		return (n.toString().equals(toString()));
	}
    
    /**
     * Getter for parentID
     * @return The parentID variable
     */
    public UUID getParentID() {
    	return parentID;
    }
    
    /**
     * Gets the ID of the node
     * @return ID of the node
     */
    public UUID getID() {
    	return ID;
    }
    
    /**
     * We can have extra information about the problem to prune all the nodes
     * above a specific heuristicValue. By default we know nothing, so we 
     * do not prune anything
     * @return Value of the initial prune limit 
     */
	public int initialValuePruneLimit() {
		return Integer.MAX_VALUE; //Implementation by default
	}
    
	@Override
	public int compareTo(Node node) { //BRANCHING METHOD
		int totalValue = heuristicValue;
		int totalValueToBeCompared = node.getHeuristicValue();
		
		if (totalValue > totalValueToBeCompared) return 1; //this has less priority (is bigger)
		else if (totalValue == totalValueToBeCompared) return 0; //The same priority
		else return -1; //this has more priority (is smaller)
	}
    
	public void calculateHeuristicValue() {
		int aaa = Integer.MAX_VALUE;
		for(int j=0; j < NullPathBB.weights.length; j++) {
			if(Math.abs(NullPathBB.weights[i][j]) < aaa) {
				aaa = NullPathBB.weights[i][j];
			}
		}
		heuristicValue = aaa;
	}

	
	public ArrayList<Node> expand() {
		ArrayList<Node> children = new ArrayList<Node>();
		for(int n : NullPathBB.nodes) {
			if(i != n /*And not used*/) {
				children.add(new Node(n));
			}
		}
		return children;
	}

	
	public boolean isSolution() {
		// TODO Auto-generated method stub
		
		return true;
	}
}
