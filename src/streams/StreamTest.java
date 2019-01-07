package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>(Arrays.asList(new int[] {5,4,1,2,1,45,8}));
		List<int[]> collect = list.stream().filter(i->{
			System.out.println(i[0]);
			return true;
		}).collect(Collectors.toList());
		System.out.println(collect);
		
		int[] a = {5,4,8,4,5,4,5};
		Arrays.stream(a).filter(j->{
			System.out.println(j);
			return true;
		}).count();
	}
}
