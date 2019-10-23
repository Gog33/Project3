import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DateSortingUsingAlgorithm {
	HashMap<LocalDate, Integer> datesMap;
	DateTimeFormatter dateFormat;
	
	public DateSortingUsingAlgorithm() throws IOException {
		datesMap = new HashMap<LocalDate, Integer>();
		dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		readDates();
	}
	
	public void dateHashMapSortedDescending() {
		datesMap = sortDateDescending(datesMap);
		for (LocalDate dateKey : datesMap.keySet()) {
			System.out.println(dateFormat.format(dateKey));
		}
	}
	
	public void dateHashMapSorted() {
		datesMap = sortDateAscending(datesMap);
		for (LocalDate dateKey : datesMap.keySet()) {
			System.out.println(dateFormat.format(dateKey));
		}
	}
	
	public void readDates() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));
		
		String input;
		Integer counter = 0;
		while ((input = br.readLine()) != null) {
			++counter;
			input.trim();
			LocalDate inputDate = LocalDate.parse(input, dateFormat);
			datesMap.put(inputDate, counter);
		}
		
		br.close();
	}
	
	public HashMap<LocalDate, Integer> sortDateAscending(HashMap<LocalDate, Integer> dateMap) {
		ArrayList<LocalDate> list = new ArrayList<LocalDate>(dateMap.keySet());
		HashMap<LocalDate, Integer> result = new HashMap<LocalDate, Integer>();

		for (int i = 1; i < list.size(); ++i) {
			LocalDate currDate = list.get(i);
			int j = i - 1;
			while (j >= 0 && list.get(j).getYear() >= currDate.getYear()) {
				if (list.get(j).getYear() == currDate.getYear()) {
					if (list.get(j).getMonthValue() < currDate.getMonthValue()) {
						list.set(j + 1, list.get(j));
						--j;
					} else if (list.get(j).getMonthValue() > currDate.getMonthValue()) {
						break;
					} else {
						if (list.get(j).getDayOfMonth() > currDate.getDayOfMonth()) {
							list.set(j + 1, list.get(j));
							--j;
						} else {
							break;
						}
					}
				} else {
					list.set(j + 1, list.get(j));
					--j;
				}
				list.set(j + 1, currDate);
			}
		}
		return result;
	}
	
	public HashMap<LocalDate, Integer> sortDateDescending(HashMap<LocalDate, Integer> dateMap) {
		ArrayList<LocalDate> list = new ArrayList<LocalDate>(dateMap.keySet());
		HashMap<LocalDate, Integer> result = new HashMap<LocalDate, Integer>();

		for (int i = 1; i < list.size(); ++i) {
			LocalDate currDate = list.get(i);
			int j = i - 1;
			while (j >= 0 && list.get(j).getYear() <= currDate.getYear()) {
				if (list.get(j).getYear() == currDate.getYear()) {
					if (list.get(j).getMonthValue() > currDate.getMonthValue()) {
						list.set(j + 1, list.get(j));
						--j;
					} else if (list.get(j).getMonthValue() < currDate.getMonthValue()) {
						break;
					} else {
						if (list.get(j).getDayOfMonth() < currDate.getDayOfMonth()) {
							list.set(j + 1, list.get(j));
							--j;
						} else {
							break;
						}
					}
				} else {
					list.set(j + 1, list.get(j));
					--j;
				}
				list.set(j + 1, currDate);
			}
		}
		return result;
	}
	
}
