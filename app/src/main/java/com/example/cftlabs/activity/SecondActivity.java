package com.example.cftlabs.activity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cftlabs.R;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void hello(View view){
        Dialog dialog = new Dialog(SecondActivity.this);
        dialog.setTitle("Hello");
        dialog.setContentView(R.layout.dialog);
        Bundle extra = getIntent().getExtras();
        String name = extra.getString("YourName") + " " + extra.getString("YourSecName");
        TextView text = dialog.findViewById(R.id.name);
        text.setText(name);
        dialog.show();

    }


}
