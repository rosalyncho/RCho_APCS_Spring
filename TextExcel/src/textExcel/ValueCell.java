package textExcel;

public class ValueCell extends RealCell {
	
	private double content;
		
	public ValueCell(String value) {
		super (value);
		content = Double.parseDouble(super.fullCellText());;
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText(){
		return content + "";
	}
	
	public double getDoubleValue(){
		return content;
	}
}
