package model;

import java.util.Random;

public class RandomValue {
    
    // properties of the random values
    private String fieldStatus = "randomlySorted";
    private int listLength = 1000;
    private int wordLength = 5;
    private boolean isUpCase = false;
    
    // array of random strings
    String[] randomValues;
    
    public void generate() {
        /* int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 2; */
        randomValues = new String[listLength];
        Random random = new Random();
        
        for(int i = 0; i < randomValues.length; i++) {
            String generatedString = random.ints(97, 123)
            .limit(wordLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                    StringBuilder::append).toString();
            if (isUpCase) generatedString = generatedString.toUpperCase();
            randomValues[i] = generatedString;
        }
    }
    
    public void setParameter(String fieldStatus, 
            int listLength, 
            int wordLength,
            boolean isUpCase) {
        this.fieldStatus = fieldStatus;
        this.listLength = listLength;
        this.wordLength = wordLength;
        this.isUpCase = isUpCase;
    }
    
    public String[] getValues() {
        return this.randomValues;
    }
}
