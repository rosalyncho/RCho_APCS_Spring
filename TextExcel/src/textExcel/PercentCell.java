package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String percent){
		super(percent);
	}
	
	public String abbreviatedCellText(){
		String percent=getCellText();
		if(percent.length() < 10){
			percent=percent.substring(0,percent.indexOf("."))+"%";
			int difference = 10 - percent.length();
			for(int i = 0; i < difference; i++){
				percent += " ";
			}
		}
		return percent.substring(0,10);
	}
	
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";					
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length()-1));
	}
}
