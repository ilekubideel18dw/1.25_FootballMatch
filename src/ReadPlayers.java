import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadPlayers {
	public static void main(String[] args) {
		
		// Declare the ArrayLists.
		ArrayList<Match> matches = new ArrayList<Match>();
		ArrayList<Team> footballteams = new ArrayList<Team>();
		ArrayList<Player> players = new ArrayList<Player>();
		
		// Some lines to obligate the user to enter only three arguments.
		if (args.length > 3 ) {
			System.out.println("You enter more than three arguments. Bye!");
		}
		
		else if (args.length < 3) {
			System.out.println("You don't enter three arguments. Bye!");
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
				File file = new File(args[1]);
				Scanner sc = new Scanner(file);
				
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					String[] word = line.split("::");
					
					Match fmatch = new Match();	
					
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
			
			try {
				
				// File = Argument & enter the file in Scanner.
				File file03 = new File(args[2]);
				Scanner sp = new Scanner(file03);
				
				while(sp.hasNextLine()) {
					String lineP = sp.nextLine();
					String[] wordP = lineP.split("::");
					
					Player fplayer = new Player();	
					
					// Add variable per variable in a variable.

					fplayer.setPlayerName(wordP[0]);
					fplayer.setPlayerNationality(wordP[1]);
					
					for (int w = 0; w < footballteams.size(); w++) {
						if (wordP[2].matches(footballteams.get(w).getTeamName())) {
							fplayer.setPlayerTeam(footballteams.get(w));
						}
					}
					
					fplayer.setPlayerAge(Integer.parseInt(wordP[3]));
					fplayer.setPlayerNumber(Integer.parseInt(wordP[4]));
					
					// Add all variables in the ArrayList.
					players.add(fplayer);
				}
						
			}

			// The exception.
			catch (FileNotFoundException e) {
				System.out.println("File not found...");
				
			}

			// Quantity of matches & teams:			
			System.out.println("There are " + matches.size() + " matches.");
			
			System.out.println("\n");
			
			for (int a = 0; a <= matches.size()-1; a++) {

				System.out.println(matches.get(a).getLocalTeam().getTeamName() + " " + matches.get(a).getGoalsLocal() + " - "
						+ matches.get(a).getGoalsVisitor() + " " + matches.get(a).getVisitorTeam().getTeamName());

				System.out.println("\n");
				
				System.out.println("The local team: " + matches.get(a).getLocalTeam().getTeamName());
				System.out.println("Country: " + matches.get(a).getLocalTeam().getTeamCountry());
				System.out.println("Stadium: " + matches.get(a).getLocalTeam().getTeamStadium());
				System.out.println("League: " + matches.get(a).getLocalTeam().getTeamLeague());
				System.out.println("Foundation Year: " + matches.get(a).getLocalTeam().getTeamFoundationYear());
				
				for (int c = 0; c < matches.get(a).getLocalTeam().getPlayers().size(); c++) {
					System.out.println("Player: " + players.get(e).getPlayerName());
					System.out.println("Country: " + players.get(e).getPlayerNationality());
					System.out.println("Age: " + players.get(e).getPlayerAge());
					System.out.println("Number: " + players.get(e).getPlayerNumber());
				}
				
				System.out.println("\n");
				
				System.out.println("The visitor team: " + matches.get(a).getVisitorTeam().getTeamName());
				System.out.println("Country: " + matches.get(a).getVisitorTeam().getTeamCountry());
				System.out.println("Stadium: " + matches.get(a).getVisitorTeam().getTeamStadium());
				System.out.println("League: " + matches.get(a).getVisitorTeam().getTeamLeague());
				System.out.println("Foundation Year: " + matches.get(a).getVisitorTeam().getTeamFoundationYear());
				
				for (int e = 0; e < players.size(); e++) {
					System.out.println("Player: " + players.get(e).getPlayerName());
					System.out.println("Country: " + players.get(e).getPlayerNationality());
					System.out.println("Age: " + players.get(e).getPlayerAge());
					System.out.println("Number: " + players.get(e).getPlayerNumber());
				}
				
				System.out.println("\n");
				System.out.println("--------------------------------------------------------------");
				System.out.println("\n");
			}
		}
	}
} 