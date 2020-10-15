package com.revature.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class App {
	public static void main(String[] args) {
		List<Model> list = new Vector<Model>();
		list.add(new Model(17, "Peter"));
		list.add(new Model(5, "Jacob"));
		list.add(new Model(44, "Kevin"));
		
		//Can only do this since implemented comparable
		Collections.sort(list);
		
		//Collections.sort(list, new ModelComparator());
		
		IterableStuff(list);
		
		Queue<Model> queue = new PriorityQueue<Model>();
		//queue.poll();
		
		Stack<Model> stack = new Stack<Model>();
		//stack.pop();
		
		//Not a collection!
		//String is key, model is value.
		//With hash map, goes in hashing algorithm to get a location,
		//the location will then point at a model.
		//Hashing makes new id for each key, much faster
		//to look things up than a list.
		Map<String, Model>  map = new HashMap<String, Model>();
		Model m = map.get("horse");
		map.put("pig", m);
		List<List<Model>> arrayList = new ArrayList<List<Model>>();
		arrayList.add(list);
		arrayList.add(list);
		
	}
	public static void  IterableStuff(List<Model> list) {
		//We can access iterator directly and loop
		// through the whole collection
		Iterator<Model> it = list.iterator();
		while(it.hasNext()) {
			Model m = it.next();
			System.out.println(m.name);
		}
		//With Iterable implemented, we can also use
		// an "enhanced for loop" or "for-each loop"
		// which is read here as "for each Model m in list"
		//Typically the best way to loop through elements.
		for (Model m : list) {
			System.out.println(m.name + ", " + m.number);
		}
		//Lambda, anonymous method, not belong to anyone
		//Lambda, give parentheses, not have any name or 
		//return type. Model is parameter, runs code in model
		// Finally, our forEach method, which we get from
		// Iterable as well. It takes a lambda, or anonymous method,
		// in the format of (parameters) -> { code }
		list.forEach( (Model m) -> { 
			System.out.println("Inside lambda!" + 
					m.name);
		});
		
	}
	public void doStuff(Model m) {
		System.out.println(m.name + ", " + m.number);
	}
}
// In order to be sortable by Collections (the class), 
// we need to implement Comparable<T>
class Model implements Comparable<Model>{
	public int number;
	public String name;
	
	public Model(int number, String name){
		this.name = name;
		this.number = number;
	}
	// We use compareTo to establish the "natural ordering"
	// of our objects, which is extermely useful in sorting algorithms
	public int compareTo(Model other) {
		// compareTo should return 0 for equals,
		// -1 (or any number <0) for less than and 
		// 1 (or any number >0 for greater than
		if (number <other.number /*&& name.compareTo(other.name)<0*/) {
			return -1;
		}
		else if (number> other.number /*&& name.compareTo(other.name)>0*/) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
class ModelComparator implements Comparator<Model>{

	public int compare(Model arg0, Model arg1) {
		return arg0.name.compareTo(arg1.name);
	}
	
}