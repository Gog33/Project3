import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	LocalDateTime dateTime;
	
	public DateTimeOne() {
		dateTime = LocalDateTime.now();
		//dateTime = LocalDateTime.of(2019, 10, 8, 15, 48); - the test time
	}
	
	public int getValueOfSecond() {
	   return dateTime.getSecond();
   }
   
   public void dateTimeNow() {
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	   System.out.println("Current Date/Time: " + dtFormat.format(dateTime));
   }
   
   public void sleepForFiveSec() {
	   dateTime.plusSeconds(5);
   }
   
   public void dateTimeOfOtherCity() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
	   	String printFormat = "Time on Server: " + timeFormat.format(dateTime) + "\n";
	   	ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT", ZoneId.SHORT_IDS));
	   	printFormat += "GMT: " + timeFormat.format(greenwichTime) + "\n";
	   	ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("BST", ZoneId.SHORT_IDS));
	   	printFormat += "BST (90E): " + timeFormat.format(bangladeshTime) + "\n";
	   	ZonedDateTime centralTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("CST", ZoneId.SHORT_IDS));
	   	printFormat += "CST (90W): " + timeFormat.format(centralTime);
	   	
		System.out.println(printFormat);
   }
   
   public void dateTimeDifferentZone() {
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	   LinkedHashMap<String, String> dates = new LinkedHashMap<String, String>();
	   ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT", ZoneId.SHORT_IDS));
	   dates.put("GMT", dtFormat.format(greenwichTime));
	   ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("BST", ZoneId.SHORT_IDS));
	   dates.put("BST", dtFormat.format(bangladeshTime));
	   ZonedDateTime centralTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("CST", ZoneId.SHORT_IDS));
	   dates.put("CST", dtFormat.format(centralTime));
	   
	   for (Entry<String,String> date : dates.entrySet())
		   System.out.println(date.getKey() + ": " + date.getValue());
   }
   
   public void timeZoneHashMap() {
	   DateTimeFormatter printStyle1 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
	   DateTimeFormatter printStyle5 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	   
	   LinkedHashMap<String, String> dates1 = new LinkedHashMap<String, String>();
	   ZonedDateTime greenwichTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("GMT", ZoneId.SHORT_IDS));
	   dates1.put("GMT", printStyle1.format(greenwichTime.toLocalDateTime()));
	   ZonedDateTime bangladeshTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("BST", ZoneId.SHORT_IDS));
	   dates1.put("BST", printStyle1.format(bangladeshTime.toLocalDateTime()));
	   ZonedDateTime centralTime = dateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("CST", ZoneId.SHORT_IDS));
	   dates1.put("CST", printStyle1.format(centralTime.toLocalDateTime()));
	   LocalDateTime ast = LocalDateTime.of(2020, 10, 01, 19, 59);
	   dates1.put("AST", printStyle1.format(ast));
	   LocalDateTime zst = LocalDateTime.of(2018, 11, 05, 19, 59);
	   dates1.put("ZST", printStyle1.format(zst));
	   
	   dates1 = sortbyKey(dates1);
	   
	   LinkedHashMap<String, String> dates3 = new LinkedHashMap<String, String>();
	   for (Entry<String,String> date : dates1.entrySet())
		   dates3.put(date.getValue(), "");
	   
	   dates3 = sortbyKey(dates3);
	   
	   ArrayList<LocalDateTime> dates5 = new ArrayList<LocalDateTime>();
	   for (Entry<String,String> entry : dates1.entrySet()) {
		   LocalDateTime newDate = LocalDateTime.parse(entry.getValue(), printStyle1);
		   dates5.add(newDate);
	   }
	   
	   dates5 = sortbyYear(dates5);
	   
	   System.out.println("Print Style 1:");
	   for (Entry<String,String> entry : dates1.entrySet())
		   System.out.println(entry.getKey() + " " + entry.getValue());
	   
	   System.out.println("Print Style 3:");
	   for (String key : dates3.keySet())
		   System.out.println(key);
	   
	   System.out.println("Print Style 5:");
	   for (int i = 0; i < dates5.size(); ++i) 
		   System.out.println(printStyle5.format(dates5.get(i)));
   }
   
   public static <Key, Value extends Comparable<String>> LinkedHashMap<String, String> sortbyKey(LinkedHashMap<String, String> map) {
       LinkedHashMap<String, String> result = new LinkedHashMap<>();
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
					   } else if (list.get(j).getDayOfMonth() > currDate.getDayOfMonth()) {
						   break;
					   } else {
						   if (list.get(j).getHour() < currDate.getHour()) {
							   list.set(j + 1, list.get(j));
							   --j;
						   } else if (list.get(j).getHour() > currDate.getHour()) {
							   break;
						   } else {
							   if (list.get(j).getMinute() < currDate.getMinute()) {
								   list.set(j + 1, list.get(j));
								   --j;
							   } else {
								   break;
							   }
						   }
					   }
				   }
			   } else {
			   list.set(j + 1, list.get(j));
			   --j;
			   }
			   list.set(j + 1, currDate);
		   }
	   }
	   return list;
   }
   
}