package multithreading;

public class WaitAndNotifyExample {

	private int count=0;
	
	public void initialIncrement() throws InterruptedException{
		synchronized (this) {
			for(int i=0;i<10;i++){
				++count;
				System.out.println(count);
			}
			/*putting sleep here so that the other thread will get a 
			 *chance to execute and invoke wait method otherwise if the notify 
			 *method gets called first before wait then the program will not terminate at all.
			 **/ 
			Thread.sleep(10);
			notify();
		}
	}
	
	public void finalIncrement() throws InterruptedException{
		synchronized (this) {
			wait();
			for(int i=0;i<10;i++){
				++count;
				System.out.println(count);
			}
		}
	}
	
	public static void main(String[] args) {
		WaitAndNotifyExample waitAndNotifyExample = new WaitAndNotifyExample();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					waitAndNotifyExample.initialIncrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					waitAndNotifyExample.finalIncrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t2.start();
		t1.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
