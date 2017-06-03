package textExcel;

public class FormulaCell extends RealCell{
	
	private Spreadsheet excelSpreadsheet;
	
	public FormulaCell(String formula, Spreadsheet excelSheet){
		super(formula);
		excelSpreadsheet=excelSheet;
	}
	
	public double getDoubleValue(){
		String input = getCellText();
		String[] splitted=input.split(" "); // splits the formula at spaces
		String[] range=splitted[2].split("-");
		double answer=0;
		// if the formula contains "SUM"
		if(splitted[1].toLowerCase().equals("sum")){
			SpreadsheetLocation start =new SpreadsheetLocation(range[0]);
			SpreadsheetLocation end =new SpreadsheetLocation(range[1]);
			double sum=0;
			for(int i=start.getRow()+1;i<=end.getRow()+1;i++){
				for (int j=start.getCol();j<=end.getCol();j++){
					SpreadsheetLocation cellLoc= new SpreadsheetLocation((char)(j+65)+""+i);
					if((excelSpreadsheet.getCell(cellLoc)) instanceof RealCell){
						sum=sum + ((RealCell)(excelSpreadsheet.getCell(cellLoc))).getDoubleValue();
					}
				}
			}
			return sum;
		} // if the formula contains "AVG"
		else if(splitted[1].toLowerCase().equals("avg")){
			SpreadsheetLocation start =new SpreadsheetLocation(range[0]);
			SpreadsheetLocation end =new SpreadsheetLocation(range[1]);
			double sum=0;
			int count=0;
			for(int i=start.getRow()+1;i<=end.getRow()+1;i++){
				for (int j=start.getCol();j<=end.getCol();j++){
					SpreadsheetLocation cellLoc= new SpreadsheetLocation((char)(j+65)+""+i);
					if((excelSpreadsheet.getCell(cellLoc)) instanceof RealCell){
						sum=sum + ((RealCell)(excelSpreadsheet.getCell(cellLoc))).getDoubleValue();
						count++;
					}
				}
			}
			return sum/count;
		}
		// if it's a number
		if(splitted[1].toUpperCase().charAt(0)>'A'-1 && splitted[1].toUpperCase().charAt(0)<'L'-1){
			SpreadsheetLocation cell = new SpreadsheetLocation(splitted[1]);
			answer=answer + ((RealCell)excelSpreadsheet.getCell(cell)).getDoubleValue();
		} // if it's a cell
		else {
			answer=Double.parseDouble(splitted[1]);
		}
		
		for(int i=2;i<splitted.length-1;i+=2){		// goes through the rest of the operators
			if(splitted[i+1].toUpperCase().charAt(0)>(int)'A'-1 && splitted[i+1].toUpperCase().charAt(0)<(int)'L'+1){
				SpreadsheetLocation cell = new SpreadsheetLocation(splitted[i+1]);
				// if the operator is addition				
				if(splitted[i].equals("+")){
					answer+= ((RealCell)excelSpreadsheet.getCell(cell)).getDoubleValue();
				} // if the operator is subtraction
				if(splitted[i].equals("-")){
					answer-= ((RealCell)excelSpreadsheet.getCell(cell)).getDoubleValue();
				} // if the operator is multiplication
				if(splitted[i].equals("*")){
					answer*= ((RealCell)excelSpreadsheet.getCell(cell)).getDoubleValue();
				} // if the operator is division
				if(splitted[i].equals("/")){
					answer/= ((RealCell)excelSpreadsheet.getCell(cell)).getDoubleValue();
				}
			} else {
				double next=Double.parseDouble(splitted[i+1]);
				// if the operator is addition
				if(splitted[i].equals("+")){
					answer+=next;
				} // if the operator is subtraction
				if(splitted[i].equals("-")){
					answer-=next;
				} // if the operator is multiplication
				if(splitted[i].equals("*")){
					answer*=next;
				} // if the operator is division
				if(splitted[i].equals("/")){
					answer/=next;
				}
			}
		}
		return answer;
		
	}
	@Override
	public String abbreviatedCellText() {
		return (getDoubleValue()+"            ").substring(0, 10);		// returns truncated content
	}
	
	@Override
	public String fullCellText() {
		return getCellText();
	}

}