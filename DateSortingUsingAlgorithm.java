import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeParseException;
public class DateSortingUsingAlgorithm {
	LinkedHashMap<LocalDate, Integer> datesMap;
	static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public DateSortingUsingAlgorithm() throws IOException {
		datesMap = new LinkedHashMap<LocalDate, Integer>();
		readDates();
	}
	
	public void dateHashMapSortedDescending() {
		LinkedHashMap<LocalDate, Integer> descendingDatesMap = sortDateDescending(datesMap);
		for (LocalDate dateKey : descendingDatesMap.keySet()) {
			System.out.println(DATE_FORMAT.format(dateKey));
		}
	}
	
	public void dateHashMapSorted() {
		LinkedHashMap<LocalDate, Integer> ascendingDatesMap = sortDateAscending(datesMap);
		for (LocalDate dateKey : ascendingDatesMap.keySet()) {
			System.out.println(DATE_FORMAT.format(dateKey));
		}
	}
	
	public void readDates() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("SortingDates.txt"));
		
		String input;
		Integer counter = 0;
		while ((input = br.readLine()) != null) {
			LocalDate inputDate;
			++counter;
			input = input.trim();
			try {
				inputDate = LocalDate.parse(input, DATE_FORMAT);
			} catch (DateTimeParseException e) {
				DateTimeFormatter altFormat = DateTimeFormatter.ofPattern("yyyy- MM-dd");
				inputDate = LocalDate.parse(input, altFormat);
			}
			datesMap.put(inputDate, counter);
		}
		
		br.close();
	}
	
	public LinkedHashMap<LocalDate, Integer> sortDateAscending(LinkedHashMap<LocalDate, Integer> dateMap) {
		ArrayList<LocalDate> list = new ArrayList<LocalDate>(dateMap.keySet());
		LinkedHashMap<LocalDate, Integer> result = new LinkedHashMap<LocalDate, Integer>();

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
		for (int i = 0; i < list.size(); ++i) {
			int dateNum = dateMap.get(list.get(i));
			result.put(list.get(i), dateNum);
		}
		return result;
	}
	
	public LinkedHashMap<LocalDate, Integer> sortDateDescending(LinkedHashMap<LocalDate, Integer> dateMap) {
		ArrayList<LocalDate> list = new ArrayList<LocalDate>(dateMap.keySet());
		LinkedHashMap<LocalDate, Integer> result = new LinkedHashMap<LocalDate, Integer>();

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
		for (int i = 0; i < list.size(); ++i) {
			int dateNum = dateMap.get(list.get(i));
			result.put(list.get(i), dateNum);
		}
		return result;
	}
	
}
