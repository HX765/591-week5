public class Occupation {
    //Read in file
    //Calculate the fastest growth occupation
    //

    String title; 
    double num2026;
    double num2016;
    
	public Occupation(String title, double num2026, double num2016) {
		super();
		this.title = title;
		
		this.num2026 = num2026;
		this.num2016 = num2016;
	}

	public String getTitle() {
		return title;
	}

	public double getNum2026() {
		return num2026;
	}

	public double getNum2016() {
		return num2016;
	}



}
