package ee.icd0004.birgit;

public class Greeter {
    
    public String greet(String name){
        String defaultName = "my friend";
        if (isEmpty(name)) {
            return getGreeting(defaultName);
        }
        else if(isUpperCase(name)){
            return getGreeting(name).toUpperCase();
        }
        return getGreeting(name);
    }

    public String greet(String[] names){
        StringBuilder sb = new StringBuilder();
        sb.append("Hello, ");
        int lastNameIndex = names.length - 1;

        for(int i = 0; i < names.length; i++){
            if(i != lastNameIndex) {
                sb.append(names[i]);
                sb.append(" and ");
            }
            else {
                sb.append(names[i]);
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private String getGreeting(String name) {
        return String.format("Hello, %s.", name);
    }

    private boolean isUpperCase(String name) {
        return name.toUpperCase().equals(name);
    }

    public boolean isEmpty(String name){
        return name == null || name.isEmpty();
    }
}
