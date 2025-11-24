/*
 * Written by Alexa Adams
 */

import java.io.File;
import java.util.Scanner;

public class SheepSchedulerSimulator 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String fileName, choice;
		final String DELIM = "\t";
		final int FIELD_AMT = 3;	//name, shearing time, arrival time
		
		System.out.print("Sheep Shearing Scheduler Program");
		
		do
		{
			System.out.print("\n\nEnter a file name: ");
			fileName = scanner.nextLine().trim();
			
			try
			{
				Scanner fileScanner = new Scanner(new File(fileName));
				int count = 0;
				
				while(fileScanner.hasNextLine())
				{
					fileScanner.nextLine();
					count++;
				}
				fileScanner.close();
				Sheep[] allSheep = new Sheep[count];
						
				fileScanner = new Scanner(new File(fileName));
				int index = 0;
				while(fileScanner.hasNextLine())		//read file
				{
					String fileLine = fileScanner.nextLine();
					String[] splitLines = fileLine.split(DELIM);
					
					if(splitLines.length != FIELD_AMT)
						continue;	//skip if not properly formatted
					
					String name = splitLines[0];
					int shearingTime = Integer.parseInt(splitLines[1]);
					int arrival = Integer.parseInt(splitLines[2]);
					
					allSheep[index++] = new Sheep(name, shearingTime, arrival);	//adds sheep to array
				}
				fileScanner.close();	//closes the file Scanner
				
				SheepScheduler s = new SheepScheduler();
				System.out.print("\nPrinting sheep shearing schedule...\n\n");
				
				Sheep[] schedule = s.scheduleShearing(allSheep);
				
				if(schedule == null || schedule.length == 0)
				    System.out.println("No sheep scheduled.\n");
				else
				{
					for (int i = 0; i < schedule.length; i++)
						if(schedule[i] != null)
							System.out.println(schedule[i].toString());
				}
				
				System.out.println("\nAll sheep have been sheared!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			System.out.print("\nDo you want to run the program again? (Y/N): ");
			choice = scanner.nextLine().trim();
			
			while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
			{
				System.out.print("\nThat's not a valid answer. Try again (Y/N): ");
				choice = scanner.nextLine().trim();
			}
			
		}while(choice.equalsIgnoreCase("y"));
		
		System.out.print("\nGoodbye!");
	}

}
