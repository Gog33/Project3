import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
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
	   
	   for (Entry<String,String> date : dates.entrySet())
		   System.out.println(date.getKey() + ": " + date.getValue());
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
	   
	   dates1 = sortbyKey(dates1);
	   
	   HashMap<String, String> dates3 = new HashMap<String, String>();
	   for (Entry<String,String> date : dates1.entrySet())
		   dates3.put(date.getValue(), "");
	   
	   dates3 = sortbyKey(dates3);
	   
	   ArrayList<LocalDateTime> dates5 = new ArrayList<LocalDateTime>();
	   for (Entry<String,String> entry : dates1.entrySet()) {
		   LocalDateTime newDate = LocalDateTime.parse(entry.getValue(), printStyle1);
		   dates5.add(newDate);
	   }
	   
	   dates5 = sortbyYear(dates5);
	   
	   
	   
   }
   
   public static <Key, Value extends Comparable<String>> HashMap<String, String> sortbyKey(HashMap<String, String> map) {
       HashMap<String, String> result = new HashMap<>();
	   ArrayList<Entry<String, String>> list = new ArrayList<>(map.entrySet());
       list.sort(Entry.comparingByKey());

       for (Entry<String, String> entry : list) {
           result.put(entry.getKey(), entry.getValue());
       }

       return result;   
   }
   
   public static ArrayList<LocalDateTime> sortbyYear(ArrayList<LocalDateTime> list) {
	   for (int i = 1; i < list.size(); ++i) {
		   LocalDateTime currDate = list.get(i);
		   int j = i - 1;
		   while (j >= 0 && list.get(j).getYear() >= currDate.getYear()) {
			   if (list.get(j).getYear() == currDate.getYear()) {
				   if (list.get(j).getMonthValue() > currDate.getMonthValue()) {
					   list.set(j + 1, list.get(j));
					   --j;
				   } else if (list.get(j).getMonthValue() < currDate.getMonthValue()) {
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
		   }
		   list.set(j, currDate);
	   }
	   return list;
   }
   
}