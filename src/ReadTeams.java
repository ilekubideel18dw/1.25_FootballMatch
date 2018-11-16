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
				File file01 = new File(args[0]);
				Scanner sm = new Scanner(file01);
				
				while(sm.hasNextLine()) {
					String lineF = sm.nextLine();
					String[] wordF = lineF.split("::");
					
					FootballMatch fmatch = new FootballMatch();	
					
					// Add variable per variable in a variable.
					fmatch.setLocalTeam(wordF[0]);
					fmatch.setVisitorTeam(wordF[1]);
					fmatch.setGoalsLocal(Integer.parseInt(wordF[2]));
					fmatch.setGoalsVisitor(Integer.parseInt(wordF[3]));
					
					// Add all variables in the ArrayList.
					matches.add(fmatch);
				}
						
			}

			// The exception.
			catch (FileNotFoundException e) {
				System.out.println("File not found...");
			}
			
			try {
				
				// File = Argument & enter the file in Scanner.
				File file02 = new File(args[1]);
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

			// Quantity of matches & teams:			
			System.out.println("There are " + matches.size() + " matches.");
			System.out.println("There are " + footballteams.size() + " teams.");
		
			/*for (int x = 0; matches.size() - 1 >= x; x++) {
				System.out.println(matches.get(x).getLocalTeam() + " " + matches.get(x).getGoalsLocal() + " vs " + matches.get(x).getVisitorTeam() + " " + matches.get(x).getGoalsVisitor());
			}*/
		}
	}
} 