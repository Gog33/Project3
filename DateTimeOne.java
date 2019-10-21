import java.util.Calendar;
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