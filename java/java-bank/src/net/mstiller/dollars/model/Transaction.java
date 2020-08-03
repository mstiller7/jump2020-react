package net.mstiller.dollars.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	
	public int amtStart, amtDiff, amtEnd;
	public String user;
	public String timestamp;
	public STATUS status;
	
	public enum STATUS {
		PROCESSING,
		SUCCESS,
		VOID,
	}
	
	public Transaction(Account account) {
		timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
		user = account.id;
		status = STATUS.PROCESSING;
	}
	
}
