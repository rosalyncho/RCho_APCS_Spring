package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private int row;
	private int column;
	
	
	Cell[][] excelSpreadsheet = new EmptyCell[20][12];	// 2D array of cells with 20 rows and 12 columns
	
	
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
	String[] arr = command.split(charAt.(0));
		return command;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		row = 20;
		return row;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		column = 12;
		return column;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
