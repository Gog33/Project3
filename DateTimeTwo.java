import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
public class DateTimeTwo {
	LocalDate currDate;
	
	public DateTimeTwo() {
		currDate = LocalDate.now();
	}
	
	public void daysOfCurrentMonth() {
		String dateString = currDate.getMonthValue() + "/10/" + currDate.getYear();
		LocalDate tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/uuuu"));
		DayOfWeek tenthDay = tempDate.getDayOfWeek();
		
		dateString = currDate.getMonthValue() + "/18/" + currDate.getYear();
		tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/uuuu"));
		DayOfWeek eighteenthDay = tempDate.getDayOfWeek();
		
		System.out.println("The tenth day of this month is " + tenthDay +
				" and the eighteenth is " + eighteenthDay);
	}
	
	public void daysOfAnyMonth(int month, int year) {
		String dateString = month + "/15/" + year;
		LocalDate tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/uuuu"));
		boolean leapYear = tempDate.isLeapYear();
		DayOfWeek fifteenthDay = tempDate.getDayOfWeek();
		
		Month typeMonth = Month.of(month);
		int numDaysInMonth = typeMonth.length(leapYear);
		dateString = month + "/" + numDaysInMonth + "/" + year;
		tempDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("M/d/uuuu"));
		DayOfWeek lastDay = tempDate.getDayOfWeek();
		
		System.out.println("For the year (" + year + ") and month (" + month +
				"), the fifteenth day is " + fifteenthDay +
				"and the last day is" + lastDay);
	}
	
	public void compareYear() {
		
	}
	
	public void dateHashMap() {
		
	}
	
	public void dateHashMapSorted() {
		
	}
	
}
