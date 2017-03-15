package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String location;
	
    public SpreadsheetLocation(String cellName){
    	location = cellName;
    }
    
    public int getRow(){
    	int rowNumber = Integer.parseInt(location.substring(1))-1;
    	return rowNumber;
    }

    public int getCol(){
    	int columnNumber = location.charAt(0)-'A';
    	return columnNumber;
    }
}
