package fun.kolowert.learning.multi;

import java.time.LocalTime;

public class ThreadExample extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sleep(1000);
				System.out.println("ThreadExample thread " + LocalTime.now().toString().substring(0, 12));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadExample example = new ThreadExample();
		example.start();
	}
}
