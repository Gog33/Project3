import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class MesoEquivalent {
	MesoStation station;
	int asciiAverage;
	HashMap<String, Integer> equalAscii = new HashMap<String, Integer>();
	
	public MesoEquivalent(String stid) {
		station = new MesoStation(stid);
		asciiAverage = (new MesoAsciiCal(station)).calAverage();
	}
	
	public HashMap<String, Integer> calAsciiEqual() throws IOException {
		if (!equalAscii.isEmpty()) {
			return equalAscii;
		}
		
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		for (int i = 0; i < 3; ++i) {
			br.readLine();
		}
		String stIDinput;
		while ((stIDinput = br.readLine()) != null) {
			stIDinput = stIDinput.trim();
			stIDinput = stIDinput.substring(0, 4);
			int stIDasciiAverage = calAsciiVal(stIDinput);
			if (stIDasciiAverage == asciiAverage) {
				equalAscii.put(stIDinput, stIDasciiAverage);
			}
		}
		br.close();
		
		return equalAscii;
	}
	
	public int calAsciiVal(String stID) {
		double asciiAverage = 0.0;
		for (int i = 0; i < stID.length(); ++i) {
			asciiAverage += (int) stID.charAt(i);
		}
		asciiAverage = asciiAverage / stID.length();

		if (asciiAverage - Math.floor(asciiAverage) < 0.25) {
			return (int) Math.floor(asciiAverage);
		} else {
			return (int) Math.ceil(asciiAverage);
		}
	}
	
}
