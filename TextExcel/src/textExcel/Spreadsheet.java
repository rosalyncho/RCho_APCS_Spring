// Rosalyn Cho

package textExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	Cell[][] excelSpreadsheet = new Cell[getRows()][getCols()];		// 2D array of cells with 20 rows and 12 columns
	
	public Spreadsheet(){
		for(int i = 0; i < getRows(); i++){
			for(int j = 0; j < getCols(); j++){
				excelSpreadsheet[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command){  	
		
		// split the command at spaces
		String[] splitted = command.split(" ", 3);
		SpreadsheetLocation loc;
		
		// save file
		if(command.toLowerCase().contains("save")) {
			return writeFile(command.substring(command.indexOf(' ')+1));
		} 
		// open file
		else if(command.toLowerCase().contains("open")) {
			return readFile(command.substring(command.indexOf(' ')+1));
		}
		// if there is no command
		else if(command.equals("")){
			return command;
		}
		// if the command is to clear the entire sheet
		else if(command.toLowerCase().equals("clear")){ // change the command to lower case to get rid of case issues
			for(int i = 0; i < getRows(); i++){
				for(int j = 0; j < getCols(); j++){
					excelSpreadsheet[i][j] = new EmptyCell();
				}
			}
			return getGridText();	
		}
		// if the command is to clear a specific cell
		else if(command.toLowerCase().contains("clear ")){
			String location = splitted[1];
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return getGridText();
		}
		// if the command is to assign something to a cell
		else if(command.contains("\"")){
			String[] splitInput = command.split(" = ");
			String location = splitInput[0];
			String value = splitInput[1];
			if(splitInput.length >= 3){
				System.out.println(value += " = " + splitInput[2]);
			}
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new TextCell(value.substring(1, value.length()-1)); // pass in without the quotes
	    	return getGridText(); 
		}	
		else if(splitted.length>1 && splitted[1].equals("=")){
			loc = new SpreadsheetLocation(splitted[0].toUpperCase());
			if (splitted[2].charAt(0) == 34){ //a text cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new TextCell (splitted[2]);
			}
			else if (splitted[2].contains("%")){ //a percent cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new PercentCell (splitted[2]);	
			}
			else if (splitted[2].contains("(")){ //a formula cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new FormulaCell (splitted[2]);	
			}
			else { //a value cell
				excelSpreadsheet [loc.getRow()] [loc.getCol()] = new ValueCell (splitted[2]);	
			}
			return getGridText();
		} 	
		else {
			loc = new SpreadsheetLocation(command);
			return excelSpreadsheet[loc.getRow()][loc.getCol()].fullCellText();
		}
	}
	
	@Override
	public int getRows()
	{
		return 20;	// number of rows
	}

	@Override
	public int getCols()
	{
		return 12;	// number of columns
	}

	@Override
	public Cell getCell(Location loc)
	{
		return excelSpreadsheet[loc.getRow()][loc.getCol()];	
	}

	@Override
	public String getGridText(){
		String grid = "   |";	// top left part of the spreadsheet
		for(int i=0; i < getCols(); i++){	// create the top part of the column
			grid += (char) (i + 'A') + "         |";
		}
		grid += "\n";
		for(int i=1; i <= getRows(); i++){
			if(i > 9){
				grid += i + " ";
			}
			if(i < 10){
				grid += i + "  ";
			}
			for(int j=0; j < getCols(); j++){
				grid += "|" + excelSpreadsheet[i-1][j].abbreviatedCellText();
			}
			grid += "|\n";
		}
		return grid;
	}
	
	// save file
	private String writeFile (String filename){
	     PrintStream outputFile;
	     try {
	    	 outputFile = new PrintStream(new File(filename));
	     }
	     catch (FileNotFoundException e) {
	    	 return "File not found: " + filename;
	     }
	     String str = "";
			for(int i = 0; i < getRows(); i++){
				for(char j = 'A'; j < 'M'; j++){
					Cell test=excelSpreadsheet[i][j-'A'];
					if(excelSpreadsheet[i][j-'A'] instanceof FormulaCell){
						str+=j+""+(i+1)+",FormulaCell,"+test.fullCellText()+"\n";
					}
					if(excelSpreadsheet[i][j-'A'] instanceof TextCell){
						str+=j+""+(i+1)+",TextCell,"+test.fullCellText()+"\n";
					}
					if(excelSpreadsheet[i][j-'A'] instanceof ValueCell){
						str+=j+""+(i+1)+",ValueCell,"+test.fullCellText()+"\n";
					}
					if(excelSpreadsheet[i][j-'A'] instanceof PercentCell){
						str+=j+""+(i+1)+",PercentCell,"+test.fullCellText()+"\n";
					}
				}	
			}
			outputFile.print(str);
			outputFile.close();
			return "";
	}
	// open file
	private String readFile(String filename){
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		while(inputFile.hasNextLine()){
			//Reads the input and decides which cell to construct
			String input = inputFile.nextLine();
			String[] splitted = input.split(",");
			String cellIdentifier=splitted[0];
			String cellType=splitted[1];
			String cellValue=splitted[2];
			if(cellType.equals("ValueCell"))
				excelSpreadsheet[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new ValueCell(cellValue);
			else if(cellType.equals("PercentCell"))
				excelSpreadsheet[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new PercentCell(Double.parseDouble(cellValue)*100+"%");
			else if(cellType.equals("FormulaCell"))
				excelSpreadsheet[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new FormulaCell(cellValue);
			else if(cellType.equals("TextCell"))
				excelSpreadsheet[Integer.parseInt(cellIdentifier.substring(1))-1][cellIdentifier.charAt(0)-65]= new TextCell(cellValue.substring(1,cellValue.length()-1));
		}
		inputFile.close();
		return getGridText();
	}
}
