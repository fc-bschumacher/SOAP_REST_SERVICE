package eu.fincon.hellosoap.service.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class AnswerRepository {

	private static final List<String> greetings = new ArrayList<String>();

	@PostConstruct
	public void initData() {
		greetings.add("Howdy");
		greetings.add("Konnichi wa");
		greetings.add("Moin moin");
	}
	
	public String getAnswerWithName(String name) {
		Assert.notNull(name);
		
		int index = new Random().nextInt(greetings.size());
        String greeting = greetings.get(index);
		return greeting + " " + name + "!";
		
	}
	
}
