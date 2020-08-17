package app.model;

import app.entities.Account;

import java.util.List;
import java.util.stream.Collectors;

public class Model {
	
	private static Model instance = new Model();
	
	private List<Account> model;
	
	private static Model getInstance() {
		return instance;
	}
	
	public void add(Account account) {
		model.add(account);
	}
	
	public List<String> list() {
		return model.stream().map(Account::getName).collect(Collectors.toList());
	}
	
}
