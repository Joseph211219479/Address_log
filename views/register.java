package com.example.login.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.login.R;

/**
 * Created by Common Sense on 8/15/2014.
 */
public class register extends Activity implements View.OnClickListener{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);



        Button login = (Button) findViewById(R.id.btnSingIn);
        Button cancel = (Button) findViewById(R.id.btnback2);
        login.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        EditText getName = (EditText) findViewById(R.id.etUserName);
        EditText getpass = (EditText) findViewById(R.id.etPass);
        EditText getEmail = (EditText) findViewById(R.id.etEmail);
        EditText getLast = (EditText) findViewById(R.id.txtLastName);
        EditText getCell = (EditText) findViewById(R.id.txtCell);


        switch (view.getId())
        {
            case R.id.btnSingIn:
                if(getName.getText().toString().equals("") ||
                        getpass.getText().toString().equals("") ||
                        getEmail.getText().toString().equals(""))
                {
                    Toast.makeText(register.this, "You mad bro", Toast.LENGTH_SHORT).show();
                    getName.setText("");
                    getpass.setText("");
                    getEmail.setText("");
                    getLast.setText("");
                    getCell.setText("");
                }
                else if(getEmail.getText().toString().contains("@"))
                {

                    //ContentValues values = new ContentValues();

//                    values.put("password",getpass.getText().toString() );
//                    values.put("username", getName.getText().toString());
//                    values.put("email",  getEmail.getText().toString());
//                    values.put("surname" , getLast.getText().toString());
//                    values.put("cell", getCell.getText().toString());

//                    ArrayList<String> details = new ArrayList<String>();
//                    details.add(getpass.getText().toString());
//                    details.add( getName.getText().toString());
//                    details.add(  getEmail.getText().toString());
//                    details.add(getLast.getText().toString());
//                    details.add(getCell.getText().toString());

                    String[] detailsArray = new String[5];
                    detailsArray[0] = getpass.getText().toString();
                    detailsArray[1] = getName.getText().toString();
                    detailsArray[2] = getEmail.getText().toString();
                    detailsArray[3] = getLast.getText().toString();
                    detailsArray[4]=  getCell.getText().toString();


//                    User user = new
//                            User.Builder(
//                            getName.getText().toString()).
//                            password(getpass.getText().toString()).
//                            email(getEmail.getText().toString()).
//                            surname(getLast.getText().toString()).
//                            cell(getCell.getText().toString()).build();

                    //homeobj.putExtra("usersDetails", values);
                    Intent homeobj = new Intent(register.this, home.class);
                   // Intent homeobj = new Intent(register.this, createAddress.class);

                    homeobj.putExtra("arrayDetails",detailsArray );
                    startActivity(homeobj);

                }
                break;
            case R.id.btnback2:

                Intent main = new Intent(register.this, com.example.login.views.main.class);
                startActivity(main);
                break;
        }
    }
}