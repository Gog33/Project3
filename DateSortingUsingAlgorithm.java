import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DateSortingUsingAlgorithm {
	HashMap<LocalDate, Integer> datesMap;
	
	public DateSortingUsingAlgorithm() throws IOException {
		datesMap = new HashMap<LocalDate, Integer>();
		readDates();
	}
	
	public void dateHashMapSortedDescending() {
		
	}
	
	public void dateHashMapSorted() {
		
	}
	
	public void readDates() throws IOException {
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));
		
		String input;
		Integer counter = 0;
		while ((input = br.readLine()) != null) {
			++counter;
			input.trim();
			LocalDate inputDate = LocalDate.parse(input, inputFormat);
			datesMap.put(inputDate, counter);
		}
		
		br.close();
	}
	
}
