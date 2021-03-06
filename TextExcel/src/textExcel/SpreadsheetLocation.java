package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
    private int column;
    
	@Override
    public int getRow(){
        return row;
    }

    @Override
    public int getCol(){
    	return column;
    }
    
    public SpreadsheetLocation(String cellName){
    	row = Integer.parseInt(cellName.substring(1)) - 1;
    	column = Character.toUpperCase(cellName.charAt(0)) - 65;
    }
}
