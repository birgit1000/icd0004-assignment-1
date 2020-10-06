package ee.icd0004.birgit;

public class Greeter {
    
    public String greet(String name){
        String defaultName = "my friend";
        if (isEmpty(name)) {
            return String.format("Hello, %s.", defaultName);
        }
        return String.format("Hello, %s.", name);
    }

    public boolean isEmpty(String name){
        return name == null;
    }
}
