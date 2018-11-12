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
				File file = new File(args[0]);
				Scanner sc = new Scanner(file);
				
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] word = line.split("::");
					FootballMatch fmatch = new FootballMatch();				
					fmatch.setLocalTeam(word[0]);
					fmatch.setVisitorTeam(word[1]);
					fmatch.setGoalsLocal(Integer.parseInt(word[2]));
					fmatch.setGoalsVisitor(Integer.parseInt(word[3]));
					Matches.add(fmatch);
					}
						
				}

			catch (FileNotFoundException e) {
				System.out.println("File not found...");
				
			}
			
			System.out.println(Matches);
			System.out.println("There are " + Matches.size() + " matches in the ArrayList.");
		
		}
	}
}