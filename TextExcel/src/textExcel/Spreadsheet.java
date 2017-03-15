package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	
	Cell[][] excelSpreadsheet = new EmptyCell[20][12];	// 2D array of cells with 20 rows and 12 columns
	//private String firstRow = "   ";
	public Spreadsheet() {
		for (int i = 0; i < excelSpreadsheet.length; i++){
			for (int j = 0; j < excelSpreadsheet[i].length; j++){
				excelSpreadsheet [i][j] = new EmptyCell();
			}
		}
	}
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		String[] splitted = command.split(" ");
		if(command.equals("")){
			return command;
		}
		else if (command.toLowerCase().equals("clear")) { // if the user input is "clear"
			for(int i=0; i<20; i++){
				for(int j=0; j<12;j++){
					excelSpreadsheet[i][j]=new EmptyCell();
				}
			} 
		} // if the user types in "clear" plus a particular cell
		else if (splitted.length == 2 && splitted[0].toLowerCase().equals("clear")) {
			String location = splitted[1];
			SpreadsheetLocation loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return getGridText();
		} //if the user wants to assign a value to a cell
		else if (splitted.length == 3) { 
			String location = splitted[0];  // eg. A1
			String value = splitted[2];  
			String noQuotes = value.substring(0, value.length()-1);
			SpreadsheetLocation loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new TextCell(noQuotes);
			return getGridText();
		} else {
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return excelSpreadsheet[loc.getRow()][loc.getCol()].fullCellText();
		} 
		return null;
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
	public String getGridText()
	{
		String grid = "   |";
		for(char i = 'A'; i<='L'; i++){
			grid += i + "         |";
		}
		System.out.println(grid);
		String rowLabel = "\n";
		for (int row = 0; row < getRows(); row++){
			if (row < 9) {
				rowLabel = (row+1) + "  |";
			} else {
				rowLabel = (row+1) + " |";
			}
			for(int column = 0; column <12; column++){
				rowLabel += excelSpreadsheet[row][column].abbreviatedCellText() + "|";
			}
			System.out.println(rowLabel);
			}
		return grid + rowLabel;
	}	
}
