// Rosalyn Cho

package textExcel;

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
		String[] splitted = command.split(" ");
		SpreadsheetLocation loc;
		
		if(splitted.length == 0){
			return command;
		}
		// if the command is to clear the entire sheet
		if(command.toLowerCase().equals("clear")){ // change the command to lower case to get rid of case issues
			for(int i = 0; i < getRows(); i++){
				for(int j = 0; j < getCols(); j++){
					excelSpreadsheet[i][j] = new EmptyCell();
				}
			}
			return getGridText();	
		}
		// if the command is to clear a specific cell
		else if(splitted.length == 2){
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
		
		else if(command.contains("%")){
			String location = splitted[1];
			String value = splitted[2];
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new PercentCell(value);
			return getGridText();
		}
		else if (command.contains("-") || command.contains("+") || command.contains("*") || command.contains("/")){
			String location = splitted[1];
			String value = splitted[2];
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new FormulaCell(value);
			return getGridText();
		}
		else if(command.contains(".")) {
			String location = splitted[1];
			String value = splitted[2];
			loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new ValueCell(value);
			return getGridText();
		} else {
			loc = new SpreadsheetLocation(command);
			return excelSpreadsheet[loc.getRow()][loc.getCol()].fullCellText();
		}
	}

	
	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return excelSpreadsheet[loc.getRow()][loc.getCol()];	
	}

	@Override
	public String getGridText(){
		String grid = "   |";
		for(int i=0; i < getCols(); i++){
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
}
