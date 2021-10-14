package com.example.cftlabs.validators;

public class PasswordValidation extends Validator {

    public String passwordValidation(String pass) {
        int flagUpperCase = 0;
        int flagLowerCase = 0;
        int flagNumberCase = 0;
        String errorOutput = null;
        for (int i = 0; i < pass.length(); i++){

            if (isCharOnUpperCase(pass.charAt(i))){
                flagUpperCase = 1;
            }
            if (isCharOnLowerCase(pass.charAt(i))){
                flagLowerCase = 1;
            }
            if (isCharOnNumber(pass.charAt(i))){
                flagNumberCase = 1;
            }
        }
        if (flagUpperCase == 0)
            errorOutput = "Нет символа верхнего регистра в пароле";
        if (flagLowerCase == 0)
            errorOutput = "Нет символа нижнего регистра в пароле";
        if (flagNumberCase == 0)
            errorOutput = "Нет чисел в пароле";
        return errorOutput;
    }

    public boolean isPasswordEqual(String passOne, String passTwo){
        return passOne.equals(passTwo);
    }
}
