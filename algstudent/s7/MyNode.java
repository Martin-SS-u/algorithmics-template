package algstudent.s7;

import java.util.ArrayList;

import algstudent.s7.utils.Node;

public class MyNode extends Node {
	int i;

	public MyNode(int i) {
		// TODO Auto-generated constructor stub
		this.i = i;
		calculateHeuristicValue();
		
	}

	@Override
	public void calculateHeuristicValue() {
		int aaa = Integer.MAX_VALUE;
		for(int j=0; j < NullPathBB.weights.length; j++) {
			if(Math.abs(NullPathBB.weights[i][j]) < aaa) {
				aaa = NullPathBB.weights[i][j];
			}
		}
		heuristicValue = aaa;
	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> children = new ArrayList<Node>();
		for(int n : NullPathBB.nodes) {
			if(i != n /*And not used*/) {
				children.add(new MyNode(n));
			}
		}
		return children;
	}

	@Override
	public boolean isSolution() {
		// TODO Auto-generated method stub
		
		return true;
	}

}
