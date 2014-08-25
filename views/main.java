package com.example.login.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.login.R;

/**
 * Created by Common Sense on 8/15/2014.
 */
public class main extends Activity implements View.OnClickListener{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button login = (Button) findViewById(R.id.btnSingIn);
        Button signup = (Button) findViewById((R.id.btnSignUp));

        login.setOnClickListener(this);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnSingIn:
                Intent login = new Intent(main.this, Login.class);
                startActivity(login);
                break;
            case R.id.btnSignUp:
                Intent signup = new Intent(main.this, register.class);
                startActivity(signup);
                break;
        }
    }
}