
public class MesoAsciiCal extends MesoAsciiAbstract {
	MesoStation station;
	
	public MesoAsciiCal(MesoStation station) {
		this.station = station;
	}
	
	public int calAverage() {
		double asciiAverage = 0.0;
		for (int i = 0; i < station.getStID().length(); ++i) {
			asciiAverage += (int) station.getStID().charAt(i);
		}
		asciiAverage = asciiAverage / station.getStID().length();

		if (asciiAverage - Math.floor(asciiAverage) < 0.5) {
			return (int) Math.floor(asciiAverage);
		} else {
			return (int) Math.ceil(asciiAverage);
		}
	}
}