package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBasic {

	private static int count = 0;
	
	
	private static Lock lock = new ReentrantLock();
	
	public void increment() {
		
		//we can use lock the same way we use synchronize block 
		//but with the added advantage of unlocking the lock any other method as well
		lock.lock();
		try{
			for(int x = 0;x<100000;x++)
				count++;
		}finally {
			//the only due care that we need to take while using the lock interface is we must put 
			//lock.unlock method inside the finally block otherwise if there occurs some exception
			//in between then that thread will never be able to release the lock as lock.unlock() method
			//will never get called
			lock.unlock();
		}
	}
	public static void main(String[] args) {

		ReentrantLockBasic example = new ReentrantLockBasic();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				example.increment();
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				example.increment();
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
		System.out.println("count "+count);
	}
	
}
