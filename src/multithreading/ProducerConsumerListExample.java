package multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerListExample {
	
	private List<Integer> testList = new ArrayList<>();
	
	//create an object lock
	private final Object lock = new Object();
	
	//define the upper limit for the list
	private static final int LIMIT = 5;
	
	//define lower limit here
	private static final int BOTTOM = 0;
	
	//value to be inserted inside the List
	private int value = 0;
	
	public void produce() throws InterruptedException{
		synchronized (lock) {
			while(true){
				System.out.println("Entering inside producer method");
				if(testList.size() == BOTTOM){
					for(int i=0;i<LIMIT;i++){
						System.out.println("adding "+(++value)+" to list");
						testList.add(value);
					}
					lock.notify();
				}else{
					System.out.println("waiting for Items to be removed from the list");
					lock.wait();
				}
				Thread.sleep(1000);
			}
		}
	}
	
	public void consume() throws InterruptedException{
		synchronized (lock) {
			while(true){
				System.out.println("Entering inside consumer method");
				//lock.wait();
				if(testList.size() == LIMIT){
					/*Iterator<Integer> itr= testList.iterator();
					while(itr.hasNext()){
						System.out.println("consuming "+itr.next()+" from the list");
						itr.remove();
					}*/
					for(int i=0;i<LIMIT;i++) {
						System.out.println("consuming "+testList.remove(--value)+" from the list");
					}
					lock.notify();
				}else{
					System.out.println("waiting for Items to be added to the list");
					lock.wait();
				}
				
			}
		}
	}
	
	public static void main(String[] args) {

		ProducerConsumerListExample producerConsumerListExample = new ProducerConsumerListExample();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					producerConsumerListExample.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				try {
					producerConsumerListExample.consume();
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
