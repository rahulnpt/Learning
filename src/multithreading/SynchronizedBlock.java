package multithreading;

public class SynchronizedBlock {

	private static int count1 = 0;
	private static int count2 = 0;
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void computeCount1() {

		synchronized (lock1) {
			for (int i = 0; i < 1000000; i++) {
				++count1;
			}
		}
	}

	public static void computeCount2() {
		synchronized (lock2) {
		for (int i = 0; i < 1000000; i++) {
				++count2;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Main thread starts");

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				computeCount1();
				computeCount2();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				computeCount1();
				computeCount2();
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

		System.out.println(count1);
		System.out.println(count2);

		System.out.println("Main thread ends");
	}

}
