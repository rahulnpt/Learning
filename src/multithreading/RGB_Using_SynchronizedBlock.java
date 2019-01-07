package multithreading;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RGB_Using_SynchronizedBlock {
	
	//static Counter counter= new Counter();
	
	static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) throws InterruptedException {
		
		Timer timer = new Timer(); 
		
		//timer.schedule(counter, 1000, 1000);
		
		Thread t1 = new Thread(()->{
			try {
				for (int i = 0; i < 100; i++) {
					print();
					Thread.sleep(1000);
					lock.unlock();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t2 = new Thread(()->{
			try {
				for (int i = 0; i < 100; i++) {
					print();
					Thread.sleep(1000);
					lock.unlock();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		Thread t3 = new Thread(()->{
			try {
				for (int i = 0; i < 100; i++) {
					print();
					Thread.sleep(1000);
					lock.unlock();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
	
	public static void print() throws InterruptedException {
		lock.lock();
		int mod = counter.getCount()%3;
		if(mod == 0) {
			System.out.print(" r ");
		}else if(mod== 1) {
			System.out.print(" g ");
		}else if(mod == 2) {
			System.out.print(" b \n");
		}
	}
	
}
/*class Counter extends TimerTask{

	private int count = 0;
	
	@Override
	public void run() {
		++count;
	}

	public int getCount() {
		return count;
	}

}*/