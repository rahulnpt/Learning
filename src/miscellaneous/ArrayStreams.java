package miscellaneous;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayStreams {
	public static void main(String[] args) {
		int [] test= {5,6,1,4,100,7,7,8};
		int [] test1= {5,5,5,5,5,5};
		System.out.println(Arrays.stream(test1).max().getAsInt());
	}
}
