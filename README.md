#Project 3: HashMap
This project is divided into four sections, each of which has a different function.

#Section 1:
**DateTimeOne methods**
* Constructor: initializes dateTime as a LocalDateTime object for the current time
* getValueOfSecond: returns the second value of dateTime
* dateTimeNow: prints out dateTime using dtFormat, a DateTimeFormatter of the pattern "MM/dd/yyyy hh:mm a". The method prints "Current Date/Time: " + dtFormat.format(dateTime)
* sleepForFiveSeconds: adds five seconds to dateTime for zyBooks purposes
* dateTimeOfOtherCity: creates ZonedDateTime objects from dateTime for GMT, BST, and CST. The method prints these times out with their labels, as well as the dateTime object as "server time".
* dateTimeDifferentZone: creates ZonedDateTime objects from dateTime for GMT, BST, and CST. These objects are placed into a LinkedHashMap with their respective labels. The map is iterated through and printed out.
* timeZoneHashMap: creates ZonedDateTime objects from dateTime for GMT, BST, and CST, as well as LocalDateTime objects for the hypothetical zones AST (10/01/2020 19:59) and ZST (11/05/2018 19:59). These objects are placed into two LinkedHashMaps and one array for three different print styles:  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*Style 1:* the map, dates1, puts the string labels as keys, and the LocalDateTime object as the value. The map is sorted by key, and printed out in the form "key value", where the LocalDateTime value is formatted by printStyle1 "MM/dd/yyyy HH:mm"  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*Style 3:* the map, dates3, takes the values of dates1 as keys and sorts by key (or in chronological order, effectively). Each date is printed out using printStyle1  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;*Style 5:* the ArrayList, dates5, adds the values of dates1 and sorts by the method sortByYear. The dates are printed out using printStyle5 "yyyy-MM-dd'T'HH:mm"  
* sortByKey: an algorithm that converts the entries of the input map into an ArrayList, and then sorts the ArrayList with Entry.comparingByKey(). Returns the reconstructed map from the ArrayList
* sortByYear: an algorithm that takes an ArrayList as input and uses insertion sort to sort it. It looks first for the earliest year, then the earliest month, then the latest day, to sort the dates

#Section 2:
**DateTimeTwo methods**
* Constructor: initializes currDate as a LocalDate object and fileDates as a LinkedHashMap<LocalDate, Integer>. Calls readDates method
* readDates: creates BufferedReader br to read Dates.txt. The strings in the text file are read and parsed by using a DateTimeFormatter object of "MM.dd.yyyy"
* daysOfCurrentMonth: dateTime objects are created to determine which day of the week the tenth and eighteenth days of the current are. The days are printed out after being assigned
* daysOfAnyMonth: takes an int month and int year as input. DateTime objects are created to determine which day of the week the fifteenth and last days of the input month are. This method utilizes java.time.Month. The days are printed out after being assigned
* compareYear: determines the differences between the current date and the file dates and prints them out alongside whether they are a leap year or not. The method utilizes java.time.Period
* dateHashMap: prints the entries in fileDates and prints them in the form "entry.getKey():entry.getValue()"
* dateHashMapSorted: sorts the entries in fileDates using sortDateAscending and assigns it to sortedFileDates. The entries in sortDateAscending are printed in the form "entry.getKey():entry.getValue()"
* sortDateAscending: an algorithm that converts the keys of the input map into an ArrayList and uses insertion sort to sort it. The ArrayList is sorted in ascending order, converted back into a map and returned

#Section 3:
**


#Section 4:

