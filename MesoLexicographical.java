import java.util.TreeMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
public class MesoLexicographical extends MesoSortedAbstract
{
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		Map<String, Integer> sortedMap = sortedMap(asciiVal);
		
		for (Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
	
	public Map<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		TreeMap<String, Integer> sorted = new TreeMap<String, Integer>();
		sorted.putAll(unsorted);
		return sorted;
	}
}