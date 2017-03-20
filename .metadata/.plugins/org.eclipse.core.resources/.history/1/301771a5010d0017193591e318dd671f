package textExcel;

public class ValueCell extends RealCell {
	
/*	private String content;
		
	public ValueCell(String value) {
		super (value);
		content = super.fullCellText();
	}
	
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}
	
	public String fullCellText(){
		return content;
	}
	
	public double getDoubleValue(){
		return 0.0;
	}
*/
	public ValueCell(String value){
		super(value);
	}
	public double getDoubleValue(){
		String ball=getCont();
		
		double kkkkkk=Double.parseDouble(ball);
		return kkkkkk;
	}
	public String abbreviatedCellText(){
		String ball=getCont();		
		double kkkkkk=Double.parseDouble(ball);
		ball=kkkkkk+"";
		if(ball.indexOf(".")==-1){
			ball+=(".0");
		}
		ball+="               ";
		return ball.substring(0,10);
	}
	public String fullTextCell(){
		String ball=getCont();
		return  getDoubleValue()+"";
	}
}
