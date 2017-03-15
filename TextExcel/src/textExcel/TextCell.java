package textExcel;

public class TextCell implements Cell {
	
private String text;
	
	public TextCell (String str){
		text = str;
	}

	public String abbreviatedCellText() {
		if (text.length() > 10){
			return text.substring(0, 9);	
		}else{
			int abbreviated = 10 - text.length();
			String abbreviatedText = "";
			for (int i = 0; i <= abbreviated; i++){
				abbreviatedText +=" ";
			}
			return abbreviatedText;
		}
		
	}

	public String fullCellText() {
		return text;
	}

}
