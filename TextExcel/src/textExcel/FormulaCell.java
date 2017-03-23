package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String formula){
		super(formula);
	}
	
	public String abbreviatedTextCell(){
		return super.abbreviatedCellText();
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	public double getDoubleValue() {
		return 0;
	}
}