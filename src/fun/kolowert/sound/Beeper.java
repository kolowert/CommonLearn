package fun.kolowert.sound;

import javax.sound.sampled.LineUnavailableException;

public class Beeper implements Runnable {

	String mark;
	boolean letBass;

	public Beeper(String mark) {
		this.mark = mark;
		letBass = false;
	}

	public Beeper(String mark, boolean letBass) {
		this.mark = mark;
		this.letBass = letBass;
	}

	@Override
	public void run() {
		try {
			if (letBass) {
				doBass();
			} else {
				doBeeps();
			}
		} catch (LineUnavailableException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doBeeps() throws LineUnavailableException, InterruptedException {

		double volume = 0.85;
		int[] notes = { 0, /* 207, 233, 277, 311, */ 370, 415, 466, 554, 622, 740/* , 830, 932 */ };
		int[] durations = { 120, 240 };

		int counter = 0;
		int repitation = 128;
		while (counter < repitation) {
			++counter;
			int n = (int) (notes.length * Math.random());
			int d = (int) (durations.length * Math.random());
			if (notes[n] > 0) {
				SoundUtils.tone(notes[n], durations[d], volume);
			} else {
				Thread.sleep(durations[d]);
			}
			if (counter % 4 == 0) {
				System.out.print(mark);
			}
		}
	}

	public void doBass() throws LineUnavailableException, InterruptedException {

		double volume = 0.95;
		int[] notes = { 0, 0, 207, 233, 277, 311 };
		int[] durations = { 340, 480, 580, 680 };

		int counter = 0;
		int repitation = 48;
		while (counter < repitation) {
			++counter;
			int n = (int) (notes.length * Math.random());
			int d = (int) (durations.length * Math.random());
			if (notes[n] > 0) {
				SoundUtils.tone(notes[n], durations[d], volume);
			} else {
				Thread.sleep(durations[d]);
			}
			if (counter % 4 == 0) {
				System.out.print(mark);
			}
		}
	}
}
