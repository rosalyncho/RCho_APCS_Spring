package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int row;
	private int column;
	
	Cell[][] excelSpreadsheet = new EmptyCell[20][12];	// 2D array of cells with 20 rows and 12 columns
	
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

		if(command.equals("")){
			return command;
		}
		if (command.toLowerCase().equals("clear")) { // if the user input is "clear"
			for(int i=0; i<20; i++){
				for(int j=0; j<12;j++){
					excelSpreadsheet[i][j]=new EmptyCell();
				}
			} 
			return getGridText();
		}// if the user types in "clear" plus a particular cell
		else if (command.toLowerCase().equals("clear ")) {
			String[] splitted = command.split(" ");
			String location = splitted[1];
			SpreadsheetLocation loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
		} //if command is for example "A1 = "hello""
		else if (command.contains("=")) { 
			String[] splitted = command.split(" ");
			String location = splitted[0];
			String str = splitted[1];
			SpreadsheetLocation loc = new SpreadsheetLocation(location);
			excelSpreadsheet[loc.getRow()][loc.getCol()] = new TextCell(str);
			return getGridText();
		}
			SpreadsheetLocation loc = new SpreadsheetLocation(command);
			return excelSpreadsheet[loc.getRow()][loc.getCol()].fullCellText();
		
	}
	
	@Override
	public int getRows()
	{
		row = 20;
		return row;
	}

	@Override
	public int getCols()
	{
		column = 12;
		return column;
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
		String rowLabel = "";
		for (int row = 0; row < getRows(); row++){
			if (row < 9) {
				rowLabel = (row+1) + "  |";
			} else {
				rowLabel = (row+1) + " |";
			}
			for(int j = 0; j<12; j++){
				rowLabel += excelSpreadsheet[row][j].abbreviatedCellText() + "|";
			}
			System.out.println(rowLabel);
		}
		return "";
	}	
}
