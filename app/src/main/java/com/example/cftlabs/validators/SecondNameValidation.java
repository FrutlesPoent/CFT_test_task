package com.example.cftlabs.validators;

public class SecondNameValidation extends Validator {

    public String secondNameValidation(String name){
        String errorOutput = null;
        if (isStringZero(name))
            return "Введите фамилию";
        if (!(name.length() > 2))
            errorOutput = "Слишком маленькая фамилия";

        if (isCharOnLowerCase(name.charAt(0)))
            errorOutput = "Фамилия должна быть с большой буквы";

        for (int i = 0; i < name.length();i++)
            if (isCharOnNumber(name.charAt(i)))
                errorOutput = " В фамилии не должны быть числа";

        return errorOutput;
    }
}
