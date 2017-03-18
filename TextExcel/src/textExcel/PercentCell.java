package textExcel;

public class PercentCell extends RealCell {
	
	private String content;

	public PercentCell(String percent){
		content = percent;
	}
	
	public String abbreviatedCellText(){
		return content;
	}
	
	public String fullCellText(){
		return content;
	}

	public double getDoubleValue(){
		return 0.0;
	}
}
