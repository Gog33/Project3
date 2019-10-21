import java.util.Calendar;
public class DateTimeOne extends MesoDateTimeOneAbstract
{
	Calendar calendar;
	int secondValue;
	
	public DateTimeOne() {
		this.calendar = Calendar.getInstance();
		secondValue = calendar.get(Calendar.SECOND);
	}
	
	public int getValueOfSecond() {
	   return secondValue;
   }
   
   public void dateTimeNow() {
	   
   }
   
   public void sleepForFiveSec() {
	   
   }
   
   public void dateTimeOfOtherCity() {
		
   }
   
   public void dateTimeDifferentZone() {
	
   }
   
   public void timeZoneHashMap() {
	   
   }
}