package com.example.login.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.login.R;
import com.example.login.repository.implementation.UserDAO;
import com.example.login.repository.implementation.impl.UserDAOImpl;

/**
 * Created by Common Sense on 8/15/2014.
 */
public class Login extends Activity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button login = (Button) findViewById(R.id.btnSingIn);
        Button cancel = (Button) findViewById(R.id.btnback1);

        login.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {

        switch (view.getId())
        {
            case R.id.btnSingIn:
            EditText getpass = (EditText) findViewById(R.id.etPass);
            EditText getuser = (EditText) findViewById(R.id.etUsername);

            UserDAO userOBJ = new UserDAOImpl(this);

            if (userOBJ.findUserByUsername(getuser.getText().toString(), getpass.getText().toString()) == true) {

                Intent home = new Intent(Login.this , view_details.class);
                startActivity(home);
            }
                else
            {
                Toast.makeText(Login.this , "you mad bro ? "+ getuser.getText().toString() +" " + getpass.getText().toString(), Toast.LENGTH_SHORT).show();
                getpass.setText("");
                getuser.setText("");
            }
                break;

            case R.id.btnback1 :
                Intent m = new Intent(Login.this , main.class);
                startActivity(m);
                break;
        }

    }
}