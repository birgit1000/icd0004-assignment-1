package ee.icd0004.birgit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GreeterTest 
{
    private Greeter greeter;

    @Before
    public void init(){
        greeter = new Greeter();
    }

    @Test
    public void shouldReturnGreetingWithGivenName(){
        String name = "Bob";
        String expectedGreetingMessage = "Hello, Bob.";

        String actualGreetingMessage = greeter.greet(name);

        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }

    @Test
    public void shouldReturnDefaultNameWhenGivenNull(){
        String name = null;
        String expectedGreetingMessage = "Hello, my friend.";

        String actualGreetingMessage = greeter.greet(name);
        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }

    @Test
    public void shouldReturnDefaultNameWhenGivenEmptyString(){
        String name = "";
        String expectedGreetingMessage = "Hello, my friend.";

        String actualGreetingMessage = greeter.greet(name);
        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }

    @Test
    public void shouldGreetUppercaseIfNameIsUppercase(){
        String name = "JERRY";
        String expectedGreetingMessage = "HELLO, JERRY.";

        String actualGreetingMessage = greeter.greet(name);
        assertEquals(expectedGreetingMessage, actualGreetingMessage); 
    }
}
