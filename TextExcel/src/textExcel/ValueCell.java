package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String value)
	{
		super(value);
	}
	
	public double getDoubleValue()
	{
		String value=getCellText();
		double number=Double.parseDouble(value);
		return number;
	}
	
	public String abbreviatedCellText()
	{
		String value = getCellText();
		double abbreviated=Double.parseDouble(value);
		value = abbreviated + "";
		if(value.length() > 10){
			value += (".0");
		}
		int difference = 10 - value.length();
		for (int i = 0; i < difference; i++) {
			value += " ";
		}
		return value.substring(0,10);
	}
	
	public String fullTextCell()
	{
		return  getDoubleValue()+"";
	}
}
