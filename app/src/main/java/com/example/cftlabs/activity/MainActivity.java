package com.example.cftlabs.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cftlabs.date.DateChoose;
import com.example.cftlabs.R;
import com.example.cftlabs.validators.BirthdayValidation;
import com.example.cftlabs.validators.NameValidation;
import com.example.cftlabs.validators.PasswordValidation;
import com.example.cftlabs.validators.SecondNameValidation;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private String name;
    private String secondName;
    public static final String USER_NAME = "firstName";
    public static final String USER_SEC_NAME= "secondName";
    public static final String APP_SETTINGS = "userSettings";
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(APP_SETTINGS, MODE_PRIVATE);
        Button registrationButton = (Button) findViewById(R.id.buttonRegistration);
        isData(); // Проверка на наличие сохраненных данных
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    saveData();
                    nextWindow();
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveData();
    }

    private void saveData() {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(USER_NAME, name);
        editor.putString(USER_SEC_NAME, secondName);
        editor.apply();
    }

    private void isData(){
        settings = getSharedPreferences(APP_SETTINGS,MODE_PRIVATE);
        String saved = settings.getString(USER_NAME, "Вы впервые зарегистрировались");
        name = settings.getString(USER_NAME, "Вы впервые зарегестрировались");
        secondName = settings.getString(USER_SEC_NAME, "Вы впервые зарегестрировались");
        if (!saved.equals("Вы впервые зарегистрировались")){
            nextWindow();
        }
    }

    private void deleteData(){
        SharedPreferences preferences = getSharedPreferences(APP_SETTINGS, 0);
        preferences.edit().remove(USER_NAME).commit();
        preferences.edit().remove(USER_SEC_NAME).commit();
    }

    private void nextWindow(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("YourName", name);
        intent.putExtra("YourSecName", secondName);
        startActivity(intent);
    }

    private boolean validation(){
        TextInputLayout textInputLayoutName = findViewById(R.id.textInputLayoutFirstName);
        TextInputLayout textInputLayoutSecondName = findViewById(R.id.textInputLayoutSecondName);
        TextInputLayout textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        TextInputLayout textInputLayoutPasswordSec = findViewById(R.id.textInputLayoutPasswordReady);
        Button birthdayButton = findViewById(R.id.birthdayButton);


        String nameText = textInputLayoutName.getEditText().getText().toString();
        String secondNameText = textInputLayoutSecondName.getEditText().getText().toString();
        String passwordFirstText = textInputLayoutPassword.getEditText().getText().toString();
        String passwordSecondText = textInputLayoutPasswordSec.getEditText().getText().toString(); // Хватить проверки на совпдаение с первым паролем

        PasswordValidation passwordValidation = new PasswordValidation();
        NameValidation nameValidation = new NameValidation();
        SecondNameValidation secondNameValidation = new SecondNameValidation();
        BirthdayValidation birthdayValidation = new BirthdayValidation();

        String nameResult = nameValidation.nameValidation(nameText);
        String secondNameResult = secondNameValidation.secondNameValidation(secondNameText);
        String passwordFirstResult = passwordValidation.passwordValidation(passwordFirstText);

        if (!(nameResult == null)){
            Toast.makeText(this, nameResult, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!(secondNameResult == null)){
            Toast.makeText(this, secondNameResult, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!(passwordFirstResult == null)){
            Toast.makeText(this, passwordFirstResult, Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!(birthdayValidation.birthdayValidation(birthdayButton.getText().toString()))){
            Toast.makeText(this, "Выберите день рождения", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!passwordValidation.isPasswordEqual(passwordFirstText, passwordSecondText)){
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            return false;
        }

        this.name = nameText;
        this.secondName = secondNameText;
        return true;
    }

    public void birthdayDate(View view){
        DateChoose dateChoose = new DateChoose(view);
        dateChoose.showBirthdayDate();
    }

}