
public class MesoAsciiCal extends MesoAsciiAbstract {
	MesoStation station;
	final static double NRMN_AVG = 79.0;
	
	public MesoAsciiCal(MesoStation station) {
		this.station = station;
	}
	
	public int calAverage() {
		double asciiAverage = 0.0;
		for (int i = 0; i < station.getStID().length(); ++i) {
			asciiAverage += (int) station.getStID().charAt(i);
		}
		asciiAverage = asciiAverage / station.getStID().length();

		if (asciiAverage - Math.floor(asciiAverage) < 0.25) {
			asciiAverage = (int) Math.floor(asciiAverage);
		} else {
			asciiAverage = (int) Math.ceil(asciiAverage);
		}
		
		double finalAverage = (asciiAverage + NRMN_AVG) / 2.0;
		return (int) Math.ceil(finalAverage);
	}
}