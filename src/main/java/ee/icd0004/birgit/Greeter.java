package ee.icd0004.birgit;

import java.util.LinkedList;
import java.util.Queue;

public class Greeter {
    private Queue<String> upperCaseNames = new LinkedList<>();
    private Queue<String> lowerCaseNames = new LinkedList<>();
    
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

        divideUpperAndLowerCaseNames(upperCaseNames, lowerCaseNames, names);

        appendNamesToGreeting(sb);
        
        return sb.toString();
    }

    private void appendNamesToGreeting(StringBuilder sb) {
        appendLowerCaseNamesToGreeting(lowerCaseNames, sb);
        if(hasUpperCaseNames()) appendUpperCaseNamesToGreeting(upperCaseNames, sb);
    }

    private boolean hasUpperCaseNames() {
        return !upperCaseNames.isEmpty();
    }

    private void appendUpperCaseNamesToGreeting(Queue<String> upperCaseNames, StringBuilder sb) {
        StringBuilder upperCaseSb = new StringBuilder();
        int lastNameIndex = upperCaseNames.size() - 1;
        boolean isOxfordCommaNeeded = checkIfOxfordCommaIsNeeded(upperCaseNames);

        sb.append(" AND HELLO,");
        addUpperCaseNames(upperCaseNames, upperCaseSb, lastNameIndex, isOxfordCommaNeeded);
        upperCaseSb.append("!");

        sb.append(toUpperCase(upperCaseSb));
    }

    private void addUpperCaseNames(Queue<String> upperCaseNames, StringBuilder upperCaseSb, int lastNameIndex,
            boolean isOxfordCommaNeeded) {
        while(!upperCaseNames.isEmpty()){
            appendEnding(upperCaseNames.peek() , upperCaseSb, lastNameIndex, isOxfordCommaNeeded);
            upperCaseNames.remove();
        }
    }

    private String toUpperCase(StringBuilder upperCaseSb) {
        String upperCaseGreeting = upperCaseSb.toString().toUpperCase();
        return upperCaseGreeting;
    }

    private boolean checkIfOxfordCommaIsNeeded(Queue<String> names) {
        return names.size() > 2;
    }

    private void divideUpperAndLowerCaseNames(Queue<String> upperCaseNames, Queue<String> lowerCaseNames,String[] names) {
         for(String name : names){
            if(isUpperCase(name)) {
                addNameToQueue(upperCaseNames, name);
            }
            else {
                addNameToQueue(lowerCaseNames, name);
            }
        }
    }

    private void addNameToQueue(Queue<String> lowerCaseNames, String name) {
        if(hasNotIntentionalComma(name)) {
            String[] commaArray = name.split(", ");
            for(String commaName : commaArray){
                lowerCaseNames.add(commaName);
            }
            return;
        }
        else if(name.contains("\""))
            name = removeFirstAndLastQuote(name);
        lowerCaseNames.add(name);
    }

    private boolean hasNotIntentionalComma(String name) {
        return name.contains(",") && !name.contains("\"");
    }

    private String removeFirstAndLastQuote(String name) {
        name = name.substring(1, name.length()-1);
        return name;
    }

    private void appendLowerCaseNamesToGreeting(Queue<String> lowerCaseNames, StringBuilder sb) {
        boolean isOxfordCommaNeeded = checkIfOxfordCommaIsNeeded(lowerCaseNames);

        while(!lowerCaseNames.isEmpty()){
            appendEnding(lowerCaseNames.peek(), sb, lowerCaseNames.size(), isOxfordCommaNeeded);
            lowerCaseNames.remove();
        }

    }

    private void appendEnding(String name, StringBuilder sb, int listSize, boolean isOxfordCommaNeeded) {
        if(listSize != 1) {
            sb.append(" ").append(name);
            if(shouldAddComma(listSize, isOxfordCommaNeeded)) sb.append(",");
        }
        else {
            sb.append(" and ").append(name).append(".");;
        }
    }

    private boolean shouldAddComma(int listSize, boolean isOxfordCommaNeeded) {
        return listSize > 1 && isOxfordCommaNeeded;
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
