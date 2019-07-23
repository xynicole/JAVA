package assignment05;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDateTime;

public class DiaryEvent{
	private String description;
	private LocalDateTime start;
	private int duration;
	
	
	public DiaryEvent(String des, int year, int month, int day, int hr24, int min, int dur) {
		description = des;
		start = LocalDateTime.of(year, month, day, hr24, min);
		duration = dur;
		
	}
	
	public String toString() {
		//return "Office Hours at 2018-09-18T14:30, lasting 60 minutes
		return description + " at " + start +" lasting " + duration + " minutes";
		
	}
	
	public boolean before(DiaryEvent de) {
		return start.compareTo(de.start) < 0;
	}
	public boolean after(DiaryEvent de) {
		return start.compareTo(de.start) > 0;
	}
	
	public static int[] monthBreakdown(DiaryEvent[] array) {
		int index=0;
		int[] arr = new int[13];
		for(int i=0; i<array.length; i++) {
			index= array[i].start.getMonthValue();
			// returned array, index 0 is not going to be used here, 
			//index 1 corresponds to January, and index 12 corresponds to December.
			arr[index]++;
		}
		return arr;
	}
	public static DiaryEvent earliest(List<DiaryEvent> list) {
		int index =1;
		for(int i=1; i<13; i++) {
			if(list.get(i).before(list.get(i+1))) {
				index =i;
			}
		}
		return list.get(index);
		
	}
	
	
	
}