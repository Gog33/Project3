import java.time.LocalDate;
import java.time.DayOfWeek;
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
		
	}
	
	public void compareYear() {
		
	}
	
	public void dateHashMap() {
		
	}
	
	public void dateHashMapSorted() {
		
	}
	
}
