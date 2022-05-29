package fun.kolowert.learning.multi;

import java.time.LocalTime;

public class RunnableExample implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Runnable thread is here " + LocalTime.now().toString().substring(0, 12));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		RunnableExample r = new RunnableExample();
		r.run();
	}

}
