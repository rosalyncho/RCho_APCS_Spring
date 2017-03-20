package textExcel;

public class RealCell implements Cell {

	private String content;
	
	public RealCell (String real) {
		content = real;
	}
	
	public void setCellText(String value){
		content = value;
	}
	
	public String getCellText(){
		return content;
	}
	
	@Override
	public String abbreviatedCellText() {
		return "";
	}

	public double getDoubleValue() {
		return 0.0;
	}
	
	@Override
	public String fullCellText() {
		return content;
	}
}