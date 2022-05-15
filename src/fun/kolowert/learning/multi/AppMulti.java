package fun.kolowert.learning.multi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppMulti {

	public static void main(String[] args) {
		System.out.println("Hello Multi!");
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		System.out.println(service.toString());
		
		String s = null;
		
		System.out.println(s);
		
	}
	
}
