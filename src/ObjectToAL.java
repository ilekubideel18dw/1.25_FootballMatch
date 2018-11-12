import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectToAL {
	public static void main(String[] args) {
		
		ArrayList<FootballMatch> Matches = new ArrayList<FootballMatch>();
		
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

			catch (FileNotFoundException e) {
				System.out.println("File not found...");
				
			}

			System.out.println("There are " + Matches.size() + " matches in the ArrayList.");
		
			for (int x = 0; Matches.size() - 1 >= x; x++) {
				System.out.println(Matches.get(x).getLocalTeam() + " " + Matches.get(x).getGoalsLocal() + " vs " + Matches.get(x).getVisitorTeam() + " " + Matches.get(x).getGoalsVisitor());
			}
		}
	}
}