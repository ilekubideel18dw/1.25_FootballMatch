import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MultipleArrayList {
	public static void main(String[] args) {
		
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		
		// Declare the ArrayList & the ListIterator.
		ArrayList<FootballMatch> Matches = new ArrayList<FootballMatch>();

		for (int y = 0, args.length - 1 >= y, y++) {
			File file = new File(args[y]);
		
					try {
							
						// File = Argument & enter the file in Scanner.
						Scanner sc = new Scanner(file);
						
						while(sc.hasNextLine()) {
							String line = sc.nextLine();
							String[] alist = line.split("::");
							
							FootballMatch fmatch = new FootballMatch();	
							
							// Add variable per variable in a variable.
							fmatch.setLocalTeam(alist[0]);
							fmatch.setVisitorTeam(alist[1]);
							fmatch.setGoalsLocal(Integer.parseInt(alist[2]));
							fmatch.setGoalsVisitor(Integer.parseInt(alist[3]));
							
							// Add all variables in the ArrayList.
							Matches.add(fmatch);
						}
								
					}

					// The exception.
					catch (FileNotFoundException e) {
						System.out.println("File not found...");
						
					}
					
					data.add(Matches);
					
					}

					// List of all the matches:
					System.out.println("All matches:");
					
					System.out.println("There are " + Matches.size() + " matches.");
				
					for (int x = 0; Matches.size() - 1 >= x; x++) {
						System.out.println(Matches.get(x).getLocalTeam() + " " + Matches.get(x).getGoalsLocal() + " vs " + Matches.get(x).getVisitorTeam() + " " + Matches.get(x).getGoalsVisitor());
					}
					
	}
}