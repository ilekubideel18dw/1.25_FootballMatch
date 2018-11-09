import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectToAL {
	public static void main(String[] args) {
		
		ArrayList<String> Matches = new ArrayList<String>();
		
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
				
				while(sc.hasNextLine()){
					String line = sc.nextLine();
					String[] word = line.split("::");
					FootballMatch fmatch = new FootballMatch();
					for (int x = 0; x < word.length; x++) {
						fmatch.getLocalTeam
						}
					}
						
				}
				
				System.out.println(Matches);
				System.out.println("There are " + Matches.size() + " matches in the ArrayList.");
				 
			}
			
			catch (FileNotFoundException e) {
				System.out.println("File not found...");
			}
		}
	}
}