package com.techlab.collection.crud;

import java.util.*;

public class MyTreeMap {

	public void create(TreeMap newTreeMap, Object newKey, Object newValue) {
		newTreeMap.put(newKey, newValue);
	}
	
	public void read(TreeMap newTreeMap) {
		System.out.println(newTreeMap);
	}
	
	public void update(TreeMap newTreeMap, Object newKey, Object newValue) {
		newTreeMap.put(newKey, newValue);
	}
	
	public void delete(TreeMap newTreeMap, Object newKey) {
		newTreeMap.remove(newKey);
	}
}
