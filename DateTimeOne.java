import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
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
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm aa");
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
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
	   HashMap<String, String> dates = new HashMap<String, String>();
	   ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.of("GMT"));
	   dates.put("GMT", dtFormat.format(greenwichTime));
	   ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.of("BST"));
	   dates.put("BST", dtFormat.format(bangladeshTime));
	   ZonedDateTime centralTime = dateTime.atZone(ZoneId.of("CST"));
	   dates.put("CST", dtFormat.format(centralTime));
	   
	   for (Entry<String,String> date : dates.entrySet()) {
		   System.out.println(date.getKey() + ": " + date.getValue());
	   }
   }
   
   public void timeZoneHashMap() {
	   DateTimeFormatter printStyle1 = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");
	   DateTimeFormatter printStyle5 = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm");
	   
	   HashMap<String, String> dates1 = new HashMap<String, String>();
	   ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.of("GMT"));
	   dates1.put("GMT", printStyle1.format(greenwichTime.toLocalDateTime()));
	   ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.of("BST"));
	   dates1.put("BST", printStyle1.format(bangladeshTime.toLocalDateTime()));
	   ZonedDateTime centralTime = dateTime.atZone(ZoneId.of("CST"));
	   dates1.put("CST", printStyle1.format(centralTime.toLocalDateTime()));
	   LocalDateTime ast = LocalDateTime.of(2020, 10, 01, 19, 59);
	   dates1.put("AST", printStyle1.format(ast));
	   LocalDateTime zst = LocalDateTime.of(2018, 11, 05, 19, 59);
	   dates1.put("ZST", printStyle1.format(zst));
	   
	   dates1 = sortStyle1(dates1);
	   
	   HashMap<String, String> dates2 = new HashMap<String, String>();
	   //dates2.putAll(dates1);
	   
	   
   }
   
   public static <Key, Value extends Comparable<String>> HashMap<String, String> sortStyle1(HashMap<String, String> map) {
       ArrayList<Entry<String, String>> list = new ArrayList<>(map.entrySet());
       list.sort(Entry.comparingByKey());

       HashMap<String, String> result = new HashMap<>();
       for (Entry<String, String> entry : list) {
           result.put(entry.getKey(), entry.getValue());
       }

       return result;   
   }
   
}