package textExcel;

public class ValueCell extends RealCell {
	
	private String content;
		
	public ValueCell(String value) {
		content = value;
	}
	
	public String fullCellText(){
		return content;
	}
	
	public double getDoubleValue(){
		return 0.0;
	}

}
