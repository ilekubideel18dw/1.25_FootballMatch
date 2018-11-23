import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTeams {
	public static void main(String[] args) {
		
		// Declare the ArrayLists.
		ArrayList<FootballMatch> matches = new ArrayList<FootballMatch>();
		ArrayList<Team> footballteams = new ArrayList<Team>();
		
		// Some lines to obligate the user to enter only two arguments.
		if (args.length > 2 ) {
			System.out.println("You enter more than two arguments. Bye!");
		}
		
		else if (args.length < 2) {
			System.out.println("You don't enter two arguments. Bye!");
		}
		
		else {
			
			try {
				
				// File = Argument & enter the file in Scanner.
				File file02 = new File(args[0]);
				Scanner st = new Scanner(file02);
				
				while(st.hasNextLine()) {
					String lineT = st.nextLine();
					String[] wordT = lineT.split("::");
					
					Team fteam = new Team();	
					
					// Add variable per variable in a variable.
					fteam.setTeamName(wordT[0]);
					fteam.setTeamCountry(wordT[1]);
					fteam.setTeamStadium(wordT[2]);
					fteam.setTeamLeague(wordT[3]);
					fteam.setTeamFoundationYear(Integer.parseInt(wordT[4]));
					
					// Add all variables in the ArrayList.
					footballteams.add(fteam);
				}
				
			}

			// The exception.
			catch (FileNotFoundException e) {
				System.out.println("File not found...");
			}
			
			try {
				
				// File = Argument & enter the file in Scanner.
				File file = new File(args[0]);
				Scanner sc = new Scanner(file);
				
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] word = line.split("::");
					
					FootballMatch fmatch = new FootballMatch();	
					
					// Add variable per variable in a variable.
					
					for (int a = 0; a < footballteams.size(); a++) {
						if (word[0].matches(footballteams.get(a).getTeamName())) {
							fmatch.setLocalTeam(footballteams.get(a));
						}
						
						else if (word[1].matches(footballteams.get(a).getTeamName()))
							fmatch.setVisitorTeam(footballteams.get(a));
						}

					fmatch.setGoalsLocal(Integer.parseInt(word[2]));
					fmatch.setGoalsVisitor(Integer.parseInt(word[3]));
					
					// Add all variables in the ArrayList.
					matches.add(fmatch);
				}
						
			}

			// The exception.
			catch (FileNotFoundException e) {
				System.out.println("File not found...");
				
			}

			// Quantity of matches & teams:			
			System.out.println("There are " + matches.size() + " matches.");
		}
	}
} 