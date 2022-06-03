package fun.kolowert.sound;

import javax.sound.sampled.LineUnavailableException;

public class SoundPlay {

	public static void main(String[] args) throws LineUnavailableException, InterruptedException {
		
		System.out.println("main started");
		play3();
		play3();
		System.out.println("main finished");

	}
	
	public static void play3() {
		System.out.println("play3 started");
		
		Thread beeper1 = new Thread(new Beeper("1"), "Beeper1");
		Thread basser1 = new Thread(new Beeper("8", true), "Bass1");
		Thread basser2 = new Thread(new Beeper("9", true), "Bass2");
		
		beeper1.start();
		basser1.start();
		//basser2.start();
		
		try {
			beeper1.join();
			basser1.join();
			basser2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nplay3 finished");
	}
	
	
	public static void play2() throws LineUnavailableException, InterruptedException {
		System.out.println("play2");

		double volume = 0.85;
		int[] notes = { 0, /* 207, 233,*/ 277, 311, 370, 415, 466, 554, 622/*, 740, 830, 932 */ };
		int[] durations = { 120, 240, 480 };

		int counter = 0;
		int repitation = 64;
		while (counter < repitation) {
			++counter;
			int n = (int) (notes.length * Math.random());
			int d = (int) (durations.length * Math.random());
			System.out.print(n + "" + d + " ");
			if (n > 0) {
				SoundUtils.tone(notes[n], durations[d], volume);
			} else {
				Thread.sleep(durations[d]);
			}
			if (counter % 32 == 0) {
				System.out.println();
			}
		}

	}

	public static void play1() {
		System.out.println("play1");
		try {
			int max = 1200;
			int min = 440;
			double x = 440.0;
			do {
				int tone = (int) (x + 0.5);
				SoundUtils.tone(tone, 120);
				System.out.print(tone + " ");
				x = x * 13.0 / 12.0;
			} while (x <= max);
			System.out.println();
			do {
				int tone = (int) (x + 0.5);
				SoundUtils.tone(tone, 110);
				System.out.print(tone + " ");
				x = x * 12.0 / 13.0;
			} while (x >= min);

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public static void play0() throws LineUnavailableException, InterruptedException {
		System.out.println("(1000, 100)");
		SoundUtils.tone(1000, 100);
		Thread.sleep(1_500);

		System.out.println("(100, 1000)");
		SoundUtils.tone(100, 1000);
		Thread.sleep(1_500);

		System.out.println("(5000, 100)");
		SoundUtils.tone(5000, 100);
		Thread.sleep(1_500);

		System.out.println("(400, 500)");
		SoundUtils.tone(400, 500);
		Thread.sleep(1_500);

		System.out.println("(400, 500, 0.2)");
		SoundUtils.tone(400, 500, 0.2);
	}
}
