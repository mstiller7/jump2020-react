package com.collabera.jump.fruitmart;

import java.util.List;

import com.collabera.jump.fruitmart.exceptions.FruitNotFound;
import com.collabera.jump.model.Fruit;
import com.collabera.jump.model.TASTE;

public class FruitMart {

	

	public List<Fruit> searchByTaste(TASTE taste) {
		return null;
	}

	public List<Fruit> search(Fruit fruit) {
		return null;
	}
	
	

	public List<Fruit> searchByType(String fruit) throws FruitNotFound,FruitOutOfStock {
		if(fruit ==null)
		throw new FruitNotFound(fruit + " Not Found!");
	
		throw new FruitOutOfStock(fruit + " out of stock!");
	}
}
