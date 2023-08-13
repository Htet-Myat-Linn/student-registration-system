package student;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class test {
	public static void main(String[] args) {
		String st = "1: 00 PM";
		String ed = "3: 00 PM";
		
		String tgstart = "11: 15 AM";
		String tgend = "12: 45 PM";
		
		LocalTime start =  LocalTime.parse(st,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
		LocalTime end =  LocalTime.parse(ed,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
		LocalTime targetStart =  LocalTime.parse(tgstart,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
		LocalTime targetEnd =  LocalTime.parse(tgend,DateTimeFormatter.ofPattern("h: mm a", Locale.US));
		
		
		Boolean result = (targetStart.isAfter(start) && targetStart.isBefore(end) || 
				targetEnd.isAfter(start) && targetEnd.isBefore(end));
		System.out.println(result);
		
	}
}
