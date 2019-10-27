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
	* Style 1: the map, dates1, puts the string labels as keys, and the LocalDateTime object as the value. The map is sorted by key, and printed out in the form "key value", where the LocalDateTime value is formatted by printStyle1 "MM/dd/yyyy HH:mm"
	* Style 3: the map, dates3, takes the values of dates1 as keys and sorts by key (or in chronological order, effectively). Each date is printed out using printStyle1
	* Style 5: the ArrayList, dates5, adds the values of dates1 and sorts by the method sortByYear. The dates are printed out using printStyle5 "yyyy-MM-dd'T'HH:mm"
* sortByKey: an algorithm that converts the entries of the input map into an ArrayList, and then sorts the ArrayList with Entry.comparingByKey(). Returns the reconstructed map from the ArrayList
* sortByYear: an algorithm that takes an ArrayList as input and uses insertion sort to sort it. It looks first for the earliest year, then the earliest month, then the latest day, to sort the dates

#Section 2:



#Section 3:



#Section 4:

