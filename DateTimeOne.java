import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	LocalDateTime dateTime;
	
	public DateTimeOne() {
		dateTime = LocalDateTime.now();
	}
	
	public int getValueOfSecond() {
	   return dateTime.getSecond();
   }
   
   public void dateTimeNow() {
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("mm/dd/yyyy hh:mm aa");
	   LocalDateTime printDate = dateTime;
	   if (printDate.getHour() > 11)
		   printDate.minusHours(12);
	   System.out.println("Current Date/Time: " + dtFormat.format(printDate));
   }
   
   public void sleepForFiveSec() {
	   dateTime.plusSeconds(5);
   }
   
   public void dateTimeOfOtherCity() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm");
	   	String printFormat = "Time on Server: " + timeFormat.format(dateTime) + "\n";
	   	ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.of("GMT"));
	   	printFormat += "GMT: " + timeFormat.format(greenwichTime) + "\n";
	   	ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.of("BST"));
	   	printFormat += "BST (90E): " + timeFormat.format(bangladeshTime) + "\n";
	   	ZonedDateTime centralTime = dateTime.atZone(ZoneId.of("CST"));
	   	printFormat += "CST (90W): " + timeFormat.format(centralTime);
	   	
		System.out.println(printFormat);
   }
   
   public void dateTimeDifferentZone() {
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("mm/dd/yyyy hh:mm");
	   HashMap<String, String> dates = new HashMap<String, String>();
	   ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.of("GMT"));
	   dates.put("GMT", dtFormat.format(greenwichTime));
	   ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.of("BST"));
	   dates.put("BST", dtFormat.format(bangladeshTime));
	   ZonedDateTime centralTime = dateTime.atZone(ZoneId.of("CST"));
	   dates.put("CST", dtFormat.format(centralTime));
	   
	   
   }
   
   public void timeZoneHashMap() {
	   
   }
}