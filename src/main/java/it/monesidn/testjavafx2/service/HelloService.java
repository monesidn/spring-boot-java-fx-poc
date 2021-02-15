package it.monesidn.testjavafx2.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	private Map<String, AtomicInteger> helloCount = new HashMap<>();

	public String generateHello(String name) {
		String lName = name.toLowerCase();
		int count = 1;
		if (helloCount.containsKey(lName)) {
			count = helloCount.get(lName).incrementAndGet();
		} else {
			helloCount.put(lName, new AtomicInteger(count));
		}
		
		String suffix;
		switch (count) {
			case 1:
				suffix = "for the first time.";
				break;
			case 2:
				suffix = "for the second time.";
				break;
			case 3:
				suffix = "for the third time.";
				break;
			default:
				suffix = "for the " + count +"th time.";
				break;
		}
		return "Hello " + name + " " + suffix;
		
	}
}
