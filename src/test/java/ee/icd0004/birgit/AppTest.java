package ee.icd0004.birgit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( false );
    }

    @Test
    public void shouldReturnGreetingWithGivenName(){
        //arrange
        Greeter greeter = new Greeter();
        String name = "Bob";
        String expectedGreetingMessage = "Hello, Bob";

        //act
        String actualGreetingMessage = greeter.greet(name);

        //assert
        assertEquals(expectedGreetingMessage, actualGreetingMessage);
    }
}
