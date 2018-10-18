package com.esme.spring.faircorp;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;


public class ConsoleGreetingServiceTests {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testGreeting() {
        ConsoleGreetingService greetingService = new ConsoleGreetingService(); // (1)
        greetingService.Greet("Spring");
        outputCapture.expect(Matchers.startsWith("HelloSpring"));
    }
}
