package ee.icd0004.birgit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GreeterTest 
{
    @Test
    public void shouldReturnGreetingWithGivenName(){
        Greeter greeter = new Greeter();
        String name = "Bob";
        String expectedGreetingMessage = "Hello, Bob.";

        String actualGreetingMessage = greeter.greet(name);

        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }

    @Test
    public void shouldReturnDefaultNameWhenGivenNull(){
        Greeter greeter = new Greeter();
        String name = null;
        String expectedGreetingMessage = "Hello, my friend.";

        String actualGreetingMessage = greeter.greet(name);
        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }

    @Test
    public void shouldReturnDefaultNameWhenGivenEmptyString(){
        Greeter greeter = new Greeter();
        String name = "";
        String expectedGreetingMessage = "Hello, my friend.";

        String actualGreetingMessage = greeter.greet(name);
        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }
}
