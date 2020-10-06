package ee.icd0004.birgit;

public class Greeter {
    
    public String greet(String name){
        String defaultName = "my friend";
        if (isEmpty(name)) {
            return String.format("Hello, %s.", defaultName);
        }
        else if(isUpperCase(name)){
            return String.format("Hello, %s.", name).toUpperCase();
        }
        return String.format("Hello, %s.", name);
    }

    private boolean isUpperCase(String name) {
        return name.toUpperCase().equals(name);
    }

    public boolean isEmpty(String name){
        return name == null || name.isEmpty();
    }
}
