package algstudent.s4;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Greedy {
	public static void main(String[] args) {
		int param = Integer.parseInt(args[0]);
		Map<String,String> solution = greedy(param);
		
		if (solution != null) {
			System.out.println("Solution found: " + solution);
		} else {
			System.out.println("Solution not found.");
		}
	}
	
	public static Map<String,String> greedy(int n) {
		JSONParser parser = new JSONParser();
		try (FileReader reader = new FileReader("src/algstudent/s4/sols/g" + n + ".json")) {
			JSONObject jsonObject = (JSONObject) parser.parse(reader);
			@SuppressWarnings("unchecked")
			Map<String, List<Long>> graph = (Map<String, List<Long>>) jsonObject.get("graph");

			Map<String, String> solution = GraphColouring.greedy(graph);
			try (FileWriter file = new FileWriter("solution.json")) {
				file.write(new JSONObject(solution).toJSONString());
			}

			return solution;
			
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
