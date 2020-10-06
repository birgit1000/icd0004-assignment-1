package ee.icd0004.birgit;

public class Greeter {
    
    public String greet(String name){
        if (name == null) return "Hello, my friend.";
        return String.format("Hello, %s.", name);
    }
}
