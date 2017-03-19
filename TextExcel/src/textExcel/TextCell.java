package textExcel;

public class TextCell implements Cell {
	
	private String content;
	
	public TextCell (String text){
		content = text;
	}

	public String abbreviatedCellText() {
		String abbreviated = content;
		if (content.length() < 10){
			//fill in the spaces
			while (abbreviated.length() < 10){
				abbreviated += " ";
			}
			return abbreviated;
		}else{
			return abbreviated.substring(0,10);
		}
	}

	public String fullCellText() {
		return "\"" + content + "\"";
	}
}
