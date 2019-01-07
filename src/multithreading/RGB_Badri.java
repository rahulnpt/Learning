package multithreading;


public class RGB_Badri { 
static String flag = "r";
public static void main(String[] args) {
    Runnable r = () -> {
        for (int i = 1; i <= 10;) {
            if(RGB_Badri.flag.equals("r")) {
                System.out.print(RGB_Badri.flag);
                RGB_Badri.flag = "g";
            }
        }
    };
 
    Runnable g = () -> {
        for (int i = 2; i <= 10;) {
            if(RGB_Badri.flag.equals("g")) {
                System.out.print(RGB_Badri.flag);
                RGB_Badri.flag = "b";
            }
        }
    };
    Runnable b = () -> {
        for (int i = 1; i <= 10;) {
            if(RGB_Badri.flag.equals("b")) {
                System.out.println(RGB_Badri.flag);
                RGB_Badri.flag = "r";
            }
        }
    };
 
     Thread t1 = new Thread(r, "r");
     Thread t2 = new Thread(g, "g");
     Thread t3 = new Thread(b, "b");
     t1.start();
     t2.start();
     t3.start();
}}
 