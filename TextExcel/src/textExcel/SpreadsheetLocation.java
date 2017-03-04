package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String location;
	
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
    	int row = Integer.parseInt(this.location.substring(1))-1;
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
    	int column = this.location.charAt(0)-'A';
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        // TODO: Fill this out with your own code
    	location = cellName;
    }

}
