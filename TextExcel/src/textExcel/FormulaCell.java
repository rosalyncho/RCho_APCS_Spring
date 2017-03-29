package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String formula){
		super(formula);
	}
	
	public String abbreviatedTextCell(){
		String value = getDoubleValue() + "";
		if (value.length() > 10) {
			return value.substring(0, 10);
		}
		else {
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
		return value;
		}
	}
	
	public String fullCellText() {
		return super.fullCellText();
	}
	
	public double getDoubleValue() {
		String formula = getCellText();
		String[] splitted = formula.split(" ");
		double value = Double.parseDouble(splitted[0]);
		for (int i = 1; i < splitted.length; i++) {
			if (splitted[i].equals("*")) {
				value *= Double.parseDouble(splitted[i + 1]);
			}
			else if (splitted[i].equals("/")) {
				value /= Double.parseDouble(splitted[i + 1]);
			}
			else if (splitted[i].equals("+")) {
				value += Double.parseDouble(splitted[i + 1]);
			}
			else if (splitted[i].equals("-")) {
				value -= Double.parseDouble(splitted[i + 1]);
			}
		}
		return value;
	}
}