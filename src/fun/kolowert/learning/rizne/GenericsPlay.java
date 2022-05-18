package fun.kolowert.learning.rizne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericsPlay {
	
	public static void main(String[] args) {
		
		List<Foo> foos = new ArrayList<>();
		foos.add(new Foo(128, "Name for Foo 1", new int[] { 1, 4, 9, 2 }));
		foos.add(new Foo(144, "Name for Foo 2", new int[] { 2, 0, 1, 8 }));
		
		dump(foos);
		
	}
	
	private static void dump(Collection<?> c) {
		   for (Iterator<?> i = c.iterator(); i.hasNext();) {
		       Object o = i.next();
		       System.out.println(o);
		   }
		}
	
}
