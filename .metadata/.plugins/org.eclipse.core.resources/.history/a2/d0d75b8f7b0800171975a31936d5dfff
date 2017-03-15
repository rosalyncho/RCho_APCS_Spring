package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int columnNumber;
	private int rowNumber;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub	
        return rowNumber;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return columnNumber;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	columnNumber = cellName.charAt(0)-'A';
    	rowNumber = Integer.parseInt(cellName.substring(1))-1;
    }
}
