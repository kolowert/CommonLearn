package fun.kolowert.simple;

/**
 * It is to run by command line and learn how Class from other file is compiled & used 
 */
public class AppSimple {

	public static void main(String[] args) {
		// just comment
		System.out.println("hello Simple!");
		if (args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				Second next = new Second(i, args[i]);
				next.report();
			}
		} else {
			Second next = new Second(-1, "no way");
			next.report();
		}
	}

}

class First {

	private int id;
	private String s;

	public First(int number, String input) {
		id = number;
		s = input;
	}

	public void report() {
		System.out.println("number " + id + " : " + s);
	}
	
	@Override
	public String toString() {
		return String.format("id %d  value %s", id, s);
	}
}
