package algstudent.s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphColouring {
//	Implement a class GraphColouring.java, so that with the provided class Greedy.java we can
//	calculate a solution and visualize it with the provided Python module. You must add the provided
//	JAR to the build path for the latter to work.
//	Explain the time complexity of the implemented algorithm. 
	static String[] colours = { "red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime" };
	
	/**
	 * Time complexity O(n)
	 */
	public static Map<String, String> greedy(Map<String, List<Long>> graph) {
		Map<String, String> result = new HashMap<String, String>();
		
		
		for (String node : graph.keySet()) { // O(n)
            List<Long> connections = graph.get(node);
            List<String> usedColours = new ArrayList<>();

            for (Long neighbor : connections) { 
            	String neighborString = String.valueOf(neighbor);
                if (result.containsKey(neighborString)) {
                    usedColours.add(result.get(neighborString));
                }
            }

            for (String colour : colours) { 
                if (!usedColours.contains(colour)) {
                    result.put(node, colour);
                    break;
                }
            }
        }

        return result;
    
	}
		
}
