package eu.fincon.hellosoap.service.internal;

import org.testng.annotations.Test;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;

public class AnswerRepositoryTest {
	
	private AnswerRepository repo;
	
	@BeforeMethod
	public void beforeMethod() {

		repo = new AnswerRepository();
		repo.initData();
		
	}

	@Test
	public void shouldReturnAGreetingWithAppendedName() {
		
		String answer = repo.getAnswerWithName("TESTNAME");
		
		Assert.assertTrue(answer.contains("TESTNAME"));
		Assert.assertTrue("The answer should not begin with the name.", answer.indexOf("TESTNAME") > 0);
		
	}

}
