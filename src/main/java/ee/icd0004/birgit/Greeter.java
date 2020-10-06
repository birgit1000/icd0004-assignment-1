package ee.icd0004.birgit;

import java.util.LinkedList;
import java.util.Queue;

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
        Queue<String> upperCaseNames = new LinkedList<>();
        Queue<String> lowerCaseNames = new LinkedList<>();
        divideUpperAndLowerCaseNames(upperCaseNames, lowerCaseNames, names);

        appendLowerCaseNamesToGreeting(lowerCaseNames, sb);
        if(!upperCaseNames.isEmpty()) appendUpperCaseNamesToGreeting(upperCaseNames, sb);
        
        return sb.toString();
    }

    private void appendUpperCaseNamesToGreeting(Queue<String> upperCaseNames, StringBuilder sb) {
        StringBuilder upperCaseSb = new StringBuilder();
        int lastNameIndex = upperCaseNames.size() - 1;
        boolean isOxfordCommaNeeded = checkIfOxfordCommaIsNeeded(upperCaseNames);
        sb.append(" AND HELLO,");

        while(!upperCaseNames.isEmpty()){
            appendEnding(upperCaseNames.peek() , upperCaseSb, lastNameIndex, isOxfordCommaNeeded);
            upperCaseNames.remove();
        }
        
        upperCaseSb.append("!");
        String upperCaseGreeting = upperCaseSb.toString().toUpperCase();
        sb.append(upperCaseGreeting);
    }

    private boolean checkIfOxfordCommaIsNeeded(Queue<String> upperCaseNames) {
        return upperCaseNames.size() > 2;
    }

    private void divideUpperAndLowerCaseNames(Queue<String> upperCaseNames, Queue<String> lowerCaseNames,
            String[] names) {
         for(String name : names){
            if(isUpperCase(name)) upperCaseNames.add(name);
            else lowerCaseNames.add(name);
        }
    }

    private void appendLowerCaseNamesToGreeting(Queue<String> lowerCaseNames, StringBuilder sb) {
        boolean isOxfordCommaNeeded = checkIfOxfordCommaIsNeeded(lowerCaseNames);

        while(!lowerCaseNames.isEmpty()){
            appendEnding(lowerCaseNames.peek() , sb, lowerCaseNames.size(), isOxfordCommaNeeded);
            lowerCaseNames.remove();
        }

    }

    private void appendEnding(String name, StringBuilder sb, int listSize, boolean isOxfordCommaNeeded) {
        if(listSize != 1) {
            sb.append(" ").append(name);
            if(listSize > 1 && isOxfordCommaNeeded) sb.append(",");
        }
        else {
            sb.append(" and ").append(name).append(".");;
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
