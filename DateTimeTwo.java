import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.time.Period;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class DateTimeTwo {
	LocalDate currDate;
	LinkedHashMap<LocalDate, Integer> fileDates;
	
	public DateTimeTwo() throws IOException {
		currDate = LocalDate.now();
		fileDates = new LinkedHashMap<LocalDate, Integer>();
		readDates();
	}
	
	public void readDates() throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Dates.txt"));
			String input;
			Integer dateNum = 0;
			while ((input = br.readLine()) != null) {
				++dateNum;
				LocalDate inputDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("MM.dd.yyyy"));
				fileDates.put(inputDate, dateNum);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void daysOfCurrentMonth() {
		String dateString = currDate.getMonthValue() + "/10/" + currDate.getYear();
		LocalDate tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/yyyy"));
		DayOfWeek tenthDay = tempDate.getDayOfWeek();
		
		dateString = currDate.getMonthValue() + "/18/" + currDate.getYear();
		tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/yyyy"));
		DayOfWeek eighteenthDay = tempDate.getDayOfWeek();
		
		System.out.println("The tenth day of this month is " + tenthDay +
				" and the eighteenth is " + eighteenthDay);
	}
	
	public void daysOfAnyMonth(int month, int year) {
		String dateString = month + "/15/" + year;
		LocalDate tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/yyyy"));
		boolean leapYear = tempDate.isLeapYear();
		DayOfWeek fifteenthDay = tempDate.getDayOfWeek();
		
		Month typeMonth = Month.of(month);
		int numDaysInMonth = typeMonth.length(leapYear);
		dateString = month + "/" + numDaysInMonth + "/" + year;
		tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/yyyy"));
		DayOfWeek lastDay = tempDate.getDayOfWeek();
		
		System.out.println("For the year (" + year + ") and month (" + month +
				"), the fifteenth day is " + fifteenthDay +
				"and the last day is" + lastDay);
	}
	
	public void compareYear() {
		for (LocalDate fileDate : fileDates.keySet()) {
			Period timeDiff = Period.between(currDate, fileDate);
			String notLeapYear = "";
			if (!fileDate.isLeapYear())
				notLeapYear = "not ";
			System.out.println(fileDate.getYear() + " is " + notLeapYear +
					"a leap year, and Difference: " + timeDiff.getYears() +
					" years, " + timeDiff.getMonths() + " months, and" +
					timeDiff.getDays() + ".");
		}
	}
	
	public void dateHashMap() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for (Entry<LocalDate, Integer> entry : fileDates.entrySet()) {
			System.out.println(entry.getKey().format(dateFormat) +
					":" + entry.getValue());
		}
	}
	
	public void dateHashMapSorted() {
		
	}
	
}
