package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String percent){
		super (percent);
	}
	
	public String abbreviatedCellText(){
		return super.abbreviatedCellText();
	}
	
	public String fullCellText(){
		return super.fullCellText();
	}

	public double getDoubleValue(){
		return Double.parseDouble(this.fullCellText().substring(0, this.fullCellText().length()-1));
	}
}
