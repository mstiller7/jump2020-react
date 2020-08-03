package net.mstiller.dollars.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	
	public int amtStart, amtDiff, amtEnd;
	public String timestamp;
	
	public Transaction() {
		timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	}
	
}
