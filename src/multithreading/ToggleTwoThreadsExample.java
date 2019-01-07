package multithreading;

import java.util.Timer;

public class ToggleTwoThreadsExample {

	private static Object lock = new Object();;

	
	public void printOne() {
		synchronized (lock) {
			while(true) {
				System.out.println("1");
			}
		}
	}
	
	public void printTwo() {
		synchronized (lock) {
			while(true) {
				System.out.println("2");
			}
		}
	}
	
	public static void main(String[] args) {

		ToggleTwoThreadsExample example = new ToggleTwoThreadsExample();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				example.printOne();
			}
		});
		t1.setPriority(10);
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				example.printTwo();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	Timer timer = new Timer();
	
	timer.schedule(new SecondCounter(),0, 1000);
	}
	
}
