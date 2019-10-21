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
	   String printFormat = "Current Date/Time: " + 
			   calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH) +
			   "/" + calendar.get(Calendar.YEAR) + " " + calendar.get(Calendar.HOUR) + ":" + 
			   calendar.get(Calendar.MINUTE) + " " + calendar.get(Calendar.AM_PM);
	   System.out.println(printFormat);
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