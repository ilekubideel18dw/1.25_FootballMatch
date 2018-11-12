import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class ObjectToAL {
	public static void main(String[] args) {
		
		// Declare the ArrayList & the ListIterator.
		ArrayList<FootballMatch> Matches = new ArrayList<FootballMatch>();
		ListIterator<FootballMatch> lite = null;
		
		// Some lines to obligate the user to enter only one argument.
		if (args.length > 1 ) {
			System.out.println("You enter more than one argument. Bye!");
		}
		
		else if (args.length < 1) {
			System.out.println("You don't enter a argument. Bye!");
		}
		
		else {

			try {
				
				// File = Argument & enter the file in Scanner.
				File file = new File(args[0]);
				Scanner sc = new Scanner(file);
				
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] word = line.split("::");
					
					FootballMatch fmatch = new FootballMatch();	
					
					// Add variable per variable in a variable.
					fmatch.setLocalTeam(word[0]);
					fmatch.setVisitorTeam(word[1]);
					fmatch.setGoalsLocal(Integer.parseInt(word[2]));
					fmatch.setGoalsVisitor(Integer.parseInt(word[3]));
					
					// Add all variables in the ArrayList.
					Matches.add(fmatch);
				}
						
			}

			// The exception.
			catch (FileNotFoundException e) {
				System.out.println("File not found...");
				
			}

			// List of all the matches:
			System.out.println("All matches:");
			
			System.out.println("There are " + Matches.size() + " matches.");
		
			for (int x = 0; Matches.size() - 1 >= x; x++) {
				System.out.println(Matches.get(x).getLocalTeam() + " " + Matches.get(x).getGoalsLocal() + " vs " + Matches.get(x).getVisitorTeam() + " " + Matches.get(x).getGoalsVisitor());
			}
			
			System.out.println("");
			
			// List of the draws, and deleting from the list.
			System.out.println("The matches finished in draw:");
			
			lite = Matches.listIterator();
			FootballMatch draw = lite.next();
			
			while(lite.hasNext()) {
				if(draw.getGoalsLocal() == draw.getGoalsVisitor()) {
					System.out.println(draw.getLocalTeam() + " " + draw.getGoalsLocal() + " vs " + draw.getVisitorTeam() + " " + draw.getGoalsVisitor());
					
					lite.remove();
				}
			}
			
			System.out.println("");
			
			// List of all the matches without the draws.
			System.out.println("The matches finished with the victory of one of the teams:");
			
			for (int x = 0; Matches.size() - 1 >= x; x++) {
				System.out.println(Matches.get(x).getLocalTeam() + " " + Matches.get(x).getGoalsLocal() + " vs " + Matches.get(x).getVisitorTeam() + " " + Matches.get(x).getGoalsVisitor());
			}
		}
	}
} 