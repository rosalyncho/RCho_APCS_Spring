package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String value)
	{
		super(value);
	}
	
	public String abbreviatedCellText()
	{
		String value = getCellText();	// get the content
		double abbreviated=Double.parseDouble(value);
		value = abbreviated + "";
		// if the content has more than 10 characters
		if(value.length() > 10){
			value += (".0");
			return value.substring(0,10); // truncate the content to 10 characters
		} else { // if the content has less than 10 characters
			int spaces = 10 - value.length(); // spaces needed to fill in next to the content
			for (int i = 0; i < spaces; i++) {	// fill in the spaces
				value += " ";
		}
		return value;
		}
	}
	
	public String fullTextCell()
	{
		return  getDoubleValue()+"";
	}
	
	public double getDoubleValue()
	{
		String value=getCellText();
		double number=Double.parseDouble(value);
		return number;
	}
	
}
