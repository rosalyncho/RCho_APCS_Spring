package textExcel;

public class TextCell implements Cell {
	
	private String content;
	private int length;
	
	public TextCell(String textCell){
		content = textCell;
		length = textCell.length();
	}
	
	@Override
	public String abbreviatedCellText() {
		return (content + "          ").substring(0, 10);
	}
	
	@Override
	public String fullCellText() {
		return ("\"" + content.substring(0, length) + "\"");
	}
}
