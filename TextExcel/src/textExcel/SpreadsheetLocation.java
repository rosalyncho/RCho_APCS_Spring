package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String location;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
    	int rowNumber = Integer.parseInt(location.substring(1))-1;
        return rowNumber;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	int columnNumber = location.charAt(0)-'A';
        return columnNumber;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	location = cellName;
    }

}
