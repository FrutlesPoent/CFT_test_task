package com.example.cftlabs.validators;

public class Validator {

    protected boolean isCharOnNumber(char character) {
        return Character.isDigit(character);
    }

    protected boolean isCharOnLowerCase(char character){
        return Character.isLowerCase(character);
    }

    protected boolean isCharOnUpperCase(char character) {
        return Character.isUpperCase(character);
    }

    protected boolean isStringZero(String str){
        return str.length() == 0;
    }
}
