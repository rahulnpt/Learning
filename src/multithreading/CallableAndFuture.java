package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CallableAndFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		List<Future<String>> futureList = new ArrayList<>();
		
		IntStream.range(0, 10)
			.forEach(i->{
				Future<String> future = executorService.submit(new myCallable(i+1));
				futureList.add(future);
			});
		
		futureList.stream()
			.map(future->{
				String id= null;
				try {
					id = future.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return id;
			})
			.forEach(System.out::println);
		
		executorService.shutdown();
	}
}

class myCallable implements Callable<String>{
	
	private int id;
	
	myCallable(int id){
		this.id = id;
	}
	
	public String call() throws Exception {
		Thread.sleep(1000);
		return "id:"+this.id;
	}
	
}