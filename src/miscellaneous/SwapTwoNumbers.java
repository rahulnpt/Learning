package miscellaneous;

public class SwapTwoNumbers {

	
	public static void main(String args[]) {
		 int x = 5; 
        int y = 10; 
	    swap(x, y);    
	         
	}
	public static void swap(int x,int y) {
		x = x + y; 
        y = x - y; 
        x = x - y; 
        System.out.println("After swaping:"
             + " x = " + x + ", y = " + y);
	}
}
