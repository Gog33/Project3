
public class MesoEquivalent {
	MesoStation stid;
	int asciiAverage;
	
	public MesoEquivalent(String stid) {
		this.stid = new MesoStation(stid);
		asciiAverage = (new MesoAsciiCal(this.stid)).calAverage();
	}
}
