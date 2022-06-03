package fun.kolowert.sound;

public class MusicPlayer {
	
	public static void main(String[] args) {
		play();
	}
	
	public static void play() {
		System.out.println("MusicPlayer started");
		
		int baseNoteDuration = 400;
		double soundVolume = 0.95;
		
		Thread muz1 = new Thread(new Musician(MusicType.SOLO, 0, 0, baseNoteDuration, soundVolume), "muz1");
		Thread muz2 = new Thread(new Musician(MusicType.BASS, 0, 0, baseNoteDuration, soundVolume), "muz2");
		Thread muz3 = new Thread(new Musician(MusicType.BASS, 0, 0, baseNoteDuration, soundVolume), "muz3");
		
		muz1.start();
		muz2.start();
		muz3.start();
		
		try {
			muz1.join();
			muz2.join();
			muz3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\nMusicPlayer finished");
	}
}
