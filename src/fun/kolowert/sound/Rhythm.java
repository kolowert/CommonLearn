package fun.kolowert.sound;

import java.util.Arrays;

public class Rhythm {
	private final String name;
	private final double[] paternSolo;
	private final double[] paternBass;

	public Rhythm(String name, double[] paternSolo, double[] paternBass) {
		super();
		this.name = name;
		this.paternSolo = paternSolo;
		this.paternBass = paternBass;
	}

	public String getName() {
		return name;
	}

	public double[] getPaternSolo() {
		return paternSolo;
	}

	public double[] getPaternBass() {
		return paternBass;
	}

	@Override
	public String toString() {
		return "Rhythm [name=" + name + ", paternSolo=" + Arrays.toString(paternSolo) + ", paternBass="
				+ Arrays.toString(paternBass) + "]";
	}

}
