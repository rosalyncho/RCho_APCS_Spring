package textExcel;

public class TextCell implements Cell {
	
	private String content;
	
	public TextCell (String str) {
		str = content;
	}
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub

		String abbreviated;
		if(content.length() < 10){
			abbreviated = content.substring(0);
		}else{
			abbreviated = content.substring(0, 10);
		}
		return abbreviated;

	}
	
	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return null;
	}

}