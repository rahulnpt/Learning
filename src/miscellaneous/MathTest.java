package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MathTest {
	public static void main(String[] args) {
		/*double s =2/5;
		System.out.println(s);
		
		long[] no = {467905213, 623958417, 714532089, 938071625};
		System.out.println(Arrays.stream(no).sum());*/
		int result = MathTest.pickingNumbers( Arrays.asList(new Integer[] {4,2,3,4,4,9,98,98,3,3,3,4,2,98,1,98,98,1,1,4,98,2,98,3,9,9,3,1,4,1,98,9,9,2,9,4,2,2,9,98,4,98,1,3,4,9,1,98,98,4,2,3,98,98,1,99,9,98,98,3,98,98,4,98,2,98,4,2,1,1,9,2,4}));
		System.out.println(result);
	}
	   public static int pickingNumbers(List<Integer> a) {
	    	List<Integer> arraySizes = new ArrayList<>();
	    	a.stream().forEach((i)->{
	    		List<Integer> collect = IntStream.range(0, a.size())
					.filter((j)->{
						int diff = Math.abs(i - (a.get(j)));
						//System.out.println("i : "+i+" ,  j :"+j+" , a.get(j) :"+a.get(j)+" , diff : "+diff+" , diff <= 1 : "+(diff <= 1));
						return diff <= 1 ;
					}).boxed().map(k->a.get(k)).collect(Collectors.toList());
	    		
	    		int localMax = collect.stream().max(Comparator.naturalOrder()).get().intValue();
	    		int localMin = collect.stream().min(Comparator.naturalOrder()).get().intValue();
	    		int MinFrequeny = Collections.frequency(collect, localMin);
	    		int MaxFrequeny = Collections.frequency(collect, localMax);
    			
	    		List<Integer> filteredEle = null; 
    			if( Math.abs(localMax - localMin )>=2) {
    				if(MinFrequeny > MaxFrequeny) {
    					filteredEle = collect.stream().filter(I-> I != localMax).collect(Collectors.toList());
    				}else if(MinFrequeny < MaxFrequeny) {
    					filteredEle = collect.stream().filter(I-> I != localMin).collect(Collectors.toList());
    				}else {
    					filteredEle = collect.stream().filter(I-> I != localMin).collect(Collectors.toList());
    				}
    			}else{
    				filteredEle = collect;
    			};
	    		
	    		//System.out.println(filteredEle+" : "+ filteredEle.size());
				arraySizes.add(
					filteredEle.size());
	    	});
			return arraySizes.stream().max(Comparator.naturalOrder()).get().intValue();
	    }
}
