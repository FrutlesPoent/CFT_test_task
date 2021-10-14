package com.example.cftlabs.validators;

public class NameValidation extends Validator {

    public String nameValidation(String name) {
        String errorOutput = null;
        if (isStringZero(name)){
            return "Введите имя";
        }
        if (!(name.length() > 2))
            errorOutput = "Слишком маленькое имя";

        if (isCharOnLowerCase(name.charAt(0)))
            errorOutput = "Имя должно быть с большой буквы";

        for (int i = 0; i < name.length();i++)
            if (isCharOnNumber(name.charAt(i)))
                errorOutput = "В имени не должны быть числа";
        return errorOutput;
    }
}
