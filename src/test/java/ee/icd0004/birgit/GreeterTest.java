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

    @Test 
    public void shouldReturnGreetingWith2NamesWhenGivenArrary(){
        String[] names = {"Jill", "Jane"};
        String expectedGreetingMessage = "Hello, Jill and Jane.";

        String actualGreetingMessage = greeter.greet(names);
        assertEquals(expectedGreetingMessage, actualGreetingMessage); 
    }

    @Test 
    public void shouldReturnGreetingWithManyNameWhenGivenArrary(){
        String[] names = {"Amy", "Brian", "Charlotte"};
        String expectedGreetingMessage = "Hello, Amy, Brian, and Charlotte.";

        String actualGreetingMessage = greeter.greet(names);
        assertEquals(expectedGreetingMessage, actualGreetingMessage); 
    }

    @Test
    public void shouldReturnSeparateGreetingForUppercaseName(){
        String[] names = {"Amy", "BRIAN", "Charlotte"};
        String expectedGreetingMessage = "Hello, Amy and Charlotte. AND HELLO, BRIAN!";

        String actualGreetingMessage = greeter.greet(names);
        assertEquals(expectedGreetingMessage, actualGreetingMessage); 
    }

    @Test
    public void shouldReturnGreetingAndDivideNamesWhenManyInString(){
        String[] names = {"Bob", "Charlie, Dianne"};
        String expectedGreetingMessage = "Hello, Bob, Charlie, and Dianne.";

        String actualGreetingMessage = greeter.greet(names);
        assertEquals(expectedGreetingMessage, actualGreetingMessage); 
    }
}
