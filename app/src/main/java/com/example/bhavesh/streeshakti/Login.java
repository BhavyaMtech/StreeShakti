package com.example.bhavesh.streeshakti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText Username,Password;
    String str1,str2;
int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void loginFunction(View view){
        Username = (EditText) findViewById(R.id.editText);
        Password =(EditText)findViewById(R.id.editText2);
        str1=Username.getText().toString();
        str2=Password.getText().toString();
        if (str1.isEmpty()||str2.isEmpty()) {
            Toast.makeText(getBaseContext(), "enter all the details", Toast.LENGTH_LONG).show();
            counter++;
        }

        else if (str1.equals("admin") && str2.equals("admin")) {
            Toast.makeText(getBaseContext(),"login successful", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getBaseContext(),"login unsuccessful",Toast.LENGTH_LONG).show();
            counter++;
        }
        if (counter > 3){
            Toast.makeText(getBaseContext(),"You have o attempts. App will close",Toast.LENGTH_LONG).show();
            finish();
        }
        Intent obj = new Intent(this, NextPage.class);
        startActivity(obj);

    }

}

