package com.example.login.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.login.R;
import com.example.login.domain.Address;
import com.example.login.domain.User;
import com.example.login.repository.implementation.UserDAO;
import com.example.login.repository.implementation.impl.UserDAOImpl;

import java.lang.reflect.Array;

/**
 * Created by Common Sense on 8/15/2014.
 */
public class home extends Activity implements View.OnClickListener{
    private TextView emailCon;
    private TextView usernameCon;
    private TextView lastCon;
    private TextView cellCon;

    //private  String password = null;
    private UserDAO userObj =  null;

    private String[] details = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        userObj = new UserDAOImpl(this);

       // Bundle bun = getIntent().getExtras();
        //details.get("usersDetails");
        //details.get

        //String[] details = bun.getStringArray("arrayDetails");
        //int count =  details.length;

        //details = bun.getStringArray("usersDetails");


        Button submit = (Button) findViewById(R.id.btnSingInConfirm);
        Button nope = (Button) findViewById(R.id.btnNotConfirm);

        submit.setOnClickListener(this);
        nope.setOnClickListener(this);

//         details = new String[5];
//        Bundle intent = getIntent().getExtras();
//        if(intent != null)
//        {
//            details = intent.getStringArray("arrayDetails");
//
//        }
//        else
//        {
//            Toast.makeText(getApplicationContext(), "The ship sank!", Toast.LENGTH_SHORT).show();
//        }

//         emailCon.setText(details.);
//         usernameCon = (EditText) findViewById(R.id.etUserNameConfirm);
//         lastCon = (EditText) findViewById(R.id.txtLastNameConfirm);
//         cellCon = (EditText) findViewById(R.id.txtCellConfirm);

       // password = details[0];

//        usernameCon.setText(details[1].toString());
//        emailCon.setText(details[2].toString());
//
//        lastCon.setText(details[3].toString());
//        cellCon.setText(details[4].toString());



    }

    @Override
    public void onClick(View view)
    {
switch (view.getId()) {
    case R.id.btnSingInConfirm:

     details = new String[5];
        String[] de = new String[5];

    Bundle intent = getIntent().getExtras();
    if (intent != null) {
        de = intent.getStringArray("arrayDetails");


//        User user = new
//                User.Builder(
//                details[1].toString()).
//                password(details[0].toString()).
//                email(details[2].toString()).
//                surname(details[3].toString()).
//                cell(details[4].toString()).
//                build();
//
//        userObj.createUser(user);
//        Toast.makeText(getApplicationContext(), "Date wrote to database!", Toast.LENGTH_SHORT).show();

        Intent address = new Intent(home.this, createAddress.class);
        address.putExtra("users", de);


        startActivity(address);

    } else {
        Toast.makeText(getApplicationContext(), "The ship sank!", Toast.LENGTH_SHORT).show();
    }
        break;
    case R.id.btnNotConfirm:
        Intent main = new Intent(home.this, com.example.login.views.main.class);
        startActivity(main);
        break;

}
    }
}