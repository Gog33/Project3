import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	Calendar calendar;
	
	public DateTimeOne() {
		this.calendar = Calendar.getInstance();
	}
	
	public int getValueOfSecond() {
	   return calendar.get(Calendar.SECOND);
   }
   
   public void dateTimeNow() {
	   Date date = calendar.getTime();
	   LocalDateTime ldt = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	   DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("mm/dd/yyyy hh:mm aa");

	   System.out.println("Current Date/Time: " + dtFormat.format(ldt));
   }
   
   public void sleepForFiveSec() {
	   calendar.add(Calendar.SECOND, 5);
   }
   
   public void dateTimeOfOtherCity() {
		
   }
   
   public void dateTimeDifferentZone() {
	
   }
   
   public void timeZoneHashMap() {
	   
   }
}