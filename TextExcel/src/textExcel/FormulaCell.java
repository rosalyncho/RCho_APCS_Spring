package textExcel;

public class FormulaCell extends RealCell{
	
	//private String content;
	
	public FormulaCell(String formula) {
		super (formula);
	}
	
	@Override
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	@Override
	public String fullCellText() {
		return super.fullCellText();
	}
	
	@Override
	public double getDoubleValue(){
		return 0.0;
	}
}
