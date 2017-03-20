package textExcel;

public class FormulaCell extends RealCell{
	
	private double content;
	
	public FormulaCell(String formula) {
		super (formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		return content + "";
	}
	
	@Override
	public String fullCellText() {
		return getCellText();
	}
	
	@Override
	public double getDoubleValue(){
		return 0.0;
	}
}
