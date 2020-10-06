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
        sb.append("Hello,");
        int lastNameIndex = names.length - 1;

        appendNamesToGreeting(names, sb, lastNameIndex);
        
        return sb.toString();
    }

    private void appendNamesToGreeting(String[] names, StringBuilder sb, int lastNameIndex) {
        for(int i = 0; i < names.length; i++){
            appendEnding(names[i], sb, lastNameIndex, i);
        }
    }

    private void appendEnding(String name, StringBuilder sb, int lastNameIndex, int i) {
        if(i != lastNameIndex) {
            sb.append(" ");
            sb.append(name);
            if(lastNameIndex != 1) sb.append(",");
        }
        else {
            sb.append(" and ");
            sb.append(name);
            sb.append(".");
        }
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
