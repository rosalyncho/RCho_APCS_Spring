 package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		Scanner console = new Scanner(System.in);
    	Grid excelSpreadsheet = new Spreadsheet();
    	String input = console.nextLine();
    	while(input.equals("quit")){ // loop until user types quit
			String answer = excelSpreadsheet.processCommand(input);
			System.out.println(answer);
		}
    //	System.out.println(excelSpreadsheet.getGridText());
	}
}