package miscellaneous;

public class FinalVariables {

	private final int x = 0;
	
	public static void main(String[] args) {
		FinalVariables finalVariables= new FinalVariables();
		
		
		//below is not possible because x is defined as final and can be initialized only once
		//finalVariables.x = 1;
	}
	
}
