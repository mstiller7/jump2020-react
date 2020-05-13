package practice.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DatesExample {
	
	public static void main(String[] args) {
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		ld = LocalDate.of(1990, 8, 10);
		System.out.println(ld);
		
		System.out.println(ld.getDayOfMonth());
		
		LocalTime lt = LocalTime.of(13, 15);
		System.out.println(lt);
		
		LocalDateTime ldt = LocalDateTime.of(2020, 4, 4, 9, 5);
		System.out.println(ldt);
		
		
		ldt = ldt.plusDays(5);
		System.out.println(ldt);
		
	}

}
