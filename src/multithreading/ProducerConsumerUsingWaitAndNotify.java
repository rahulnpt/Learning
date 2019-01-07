package multithreading;

public class ProducerConsumerUsingWaitAndNotify {

	
	public void produce(){
		synchronized (this) {
			System.out.println("producer called");
			try {
				Thread.sleep(1000);//putting it to sleep so that the other thread will get a chance to get into wait state
				notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void consume() throws InterruptedException{
		synchronized (this) {
			wait();
			System.out.println("consumer called");
			System.out.println("consumer called again");
		}
		
	}
	
	public static void main(String[] args) {

		ProducerConsumerUsingWaitAndNotify waitAndNotifyExample = new ProducerConsumerUsingWaitAndNotify();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
					waitAndNotifyExample.produce();
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					waitAndNotifyExample.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
	
	}
	
}
