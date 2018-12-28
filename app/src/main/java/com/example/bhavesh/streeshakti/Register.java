package com.example.bhavesh.streeshakti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void joinUs(View v)
    { EditText editText1 = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
        EditText editText5 = (EditText) findViewById(R.id.editText5);
        EditText editText6 = (EditText) findViewById(R.id.editText6);
        TextView textView = (TextView) findViewById(R.id.textView);
        String username = editText1.getText().toString();
        String password = editText2.getText().toString();
        String confirmpass = editText3.getText().toString();
        String mobile = editText4.getText().toString();
        String email = editText5.getText().toString();
        String address = editText6.getText().toString();
        textView.setText("Result");

        if(username.isEmpty() || password.isEmpty() || confirmpass.isEmpty() || mobile.isEmpty() || email.isEmpty() || address.isEmpty() ) {
            if(username.isEmpty())
                Toast.makeText(this,"Username Field is Empty",Toast.LENGTH_SHORT).show();
            if(password.isEmpty())
                Toast.makeText(this,"Password Field is Empty",Toast.LENGTH_SHORT).show();
            if(confirmpass.isEmpty())
                Toast.makeText(this,"Confirm Password Field is Empty",Toast.LENGTH_SHORT).show();
            if(mobile.isEmpty())
                Toast.makeText(this,"Mobile Number Field is Empty",Toast.LENGTH_SHORT).show();
            if(address.isEmpty())
                Toast.makeText(this, "Address is Empty", Toast.LENGTH_SHORT).show();
            if(email.isEmpty())
                Toast.makeText(this,"Email ID Field is Empty",Toast.LENGTH_SHORT).show();
        }
                else {
            if(password.length() < 8)
                Toast.makeText(this,"Password length should be more than 8 Letters",Toast.LENGTH_SHORT).show();
            else if ( ! (password.equals(confirmpass)))
                Toast.makeText(this,"Password and Confirm Password does not match",Toast.LENGTH_SHORT).show();
            else if ( ! (mobile.matches("[0-9]{10,}")))
                Toast.makeText(this,"Invalid Mobile Number",Toast.LENGTH_SHORT).show();
            else if ( ! (email.matches("^[a-zA-Z]+[0-9a-zA-Z_]+\\@[a-z]+\\.[a-z]+")))
                Toast.makeText(this,"Invalid Email ID",Toast.LENGTH_SHORT).show();
            else {
                String pass = new String(new char[password.length()-3]).replace("\0","*");
                pass = pass + password.substring(password.length()-3);
                String result = "Username = " + username + "\n";
                result = result + "Password = " + pass + "\n";
                result = result + "Mobile = " + mobile + "\n";
                result = result + "Email ID = " + email;
               // Toast.makeText(this,result,Toast.LENGTH_LONG).show();
                Intent obj = new Intent(this, Login.class);
                startActivity(obj);

            }

        }
    }


}

