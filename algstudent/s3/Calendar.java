package algstudent.s3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

	private String fileName = "src/algstudent/s3/participants.txt";
	private String[] participants;
	private int numberOfParticipants;
	
	public void Run() {
		participants = readFile(fileName);
		String[][] calendar = makeCalendar(0, numberOfParticipants-1);
		printCalendar(calendar);
	}
	
	public void timedAlgorithm(int num) {
		participants = new String[num];
		for(int i=0 ; i< num; i++) {
			participants[i] = "participant_"+i;
		}
		makeCalendar(0, num-1);
	}	

	private String[][] makeCalendar(int first, int last) {
        int middle = (last-first)/2;
        String[][] matrix = new String[last-first+1][last-first+1];
        if(middle != 0) {
        	
        	String[][] cal = makeCalendar(first, middle + first);
            for(int i = first;i<=middle + first;i++) {
                for(int j = 0; j<cal.length;j++) {
                    matrix[(i)%matrix.length][(j)%matrix.length] = cal[(i)%cal.length][(j)%cal.length];
                    matrix[matrix.length - 1 - (i)%matrix.length][matrix.length -1 - (j)%matrix.length] = cal[(i)%cal.length][(j)%cal.length];
                }
            }

            cal = makeCalendar(middle+first+1, last);
            for(int i = middle +first+ 1; i<=last;i++) {
                for(int j = 0; j<cal.length;j++) {
                    matrix[(i)%matrix.length][(j)%matrix.length] = cal[(i)%cal.length][(j)%cal.length];
                    matrix[matrix.length - 1 - (i)%matrix.length][matrix.length - 1 - (j)%matrix.length] = cal[(i)%cal.length][(j)%cal.length];
                }
            }        	
        }
        else {
            matrix[0][0] = participants[first];
            matrix[0][1] = participants[last];
            matrix[1][0] = participants[last];            
            matrix[1][1] = participants[first];
        }
        return matrix;
    }
	
	
	private void printCalendar(String[][] table) {
		int size = table.length;
		System.out.print("PLAYER/OPPONENT");
		for(int i=1 ; i< size ; i++) {
			System.out.print("\t\tDAY " + i);
		}
		System.out.println();
		for(int i=0 ; i<size ; i++) {
			for(int j=0 ; j<size ; j++) {
				System.out.print("\t" + table[i][j] + "\t");
			}
			System.out.println();
		}
		
	}
	
	
	
	public String[] readFile(String fileName) {        
		List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            numberOfParticipants = Integer.parseInt(reader.readLine());
            
            for (int i = 0; i < numberOfParticipants; i++) {
                String name = reader.readLine();
                if (name != null) {
                    names.add(name);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        String[] result = new String[names.size()];
        for(int i=0; i< names.size(); i++) {
        	result[i] = names.get(i);
        }
		return result;
    }
}
