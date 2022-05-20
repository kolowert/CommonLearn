package fun.kolowert.learning.rizne;

import java.util.Arrays;
import java.util.List;

public class CollectionPlay {
	
	public static void main(String[] args) {
		
		commonArray();
		
	}
	
	public static void commonArray() {
		// Common array for List created from base array
		System.out.println("common array");
		
		String[] arr = {"one", "two", "three"};

		List<String> alist = Arrays.asList(arr);
		System.out.println(alist); // [one, two, three]

		arr[0] = "111";
		System.out.println(alist); // [111, two, three]
				
		alist.set(1, "222");
		System.out.println(Arrays.toString(arr)); // [111, 222, three]
		
		// Avoiding common array by replacing temporary copy
		System.out.println("\nAvoiding common array");
		String[] brr = {"one", "two", "three"};
		
		// make temporary copy
		String[] bcopy = new String[brr.length];
		System.arraycopy(brr, 0, bcopy, 0, brr.length);
		
		List<String> blist = Arrays.asList(bcopy);
		System.out.println(blist); // [one, two, three]

		brr[0] = "111";
		System.out.println(blist); // [one, two, three]
				
		blist.set(1, "222");
		System.out.println(Arrays.toString(brr)); // [111, two, three]
	}
	
}
