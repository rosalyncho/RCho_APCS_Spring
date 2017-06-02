package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String percent){
		super(percent);
	}
	
	public String abbreviatedCellText(){
		String percent=getCellText();
		// if the length is less than 10
		if(percent.length() < 10){
			percent=percent.substring(0,percent.indexOf("."))+"%";// gets everything before the decimal and adds "%" to it
			int spaces = 10 - percent.length(); // spaces needed to fill in next to the content
			for(int i = 0; i < spaces; i++){
				percent += " ";	// fill in the spaces
			}
			return percent;
		} else {	// if the content has more than 10 characters
			return percent.substring(0,10);	// truncate the content to 10 characters
		}
	}
	
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";					
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length()-1));
	}
}
