package com.example.login.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.login.R;
import com.example.login.domain.Address;
import com.example.login.domain.User;
import com.example.login.repository.implementation.AddressDAO;
import com.example.login.repository.implementation.UserDAO;
import com.example.login.repository.implementation.impl.AddressDAOImpl;
import com.example.login.repository.implementation.impl.UserDAOImpl;

/**
 * Created by Common Sense on 8/20/2014.
 */
public class createAddress extends Activity implements View.OnClickListener
{
    private UserDAO userObj =  null;
    private String[] details = null;
    private  AddressDAO addressC = null;
    private Bundle intent ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address);

        Toast.makeText(createAddress.this, "im in creaTE ADDRESS", Toast.LENGTH_SHORT).show();

        addressC = new AddressDAOImpl(this);
        userObj = new UserDAOImpl(this);

        Button save = (Button) findViewById(R.id.btnSaveAddress);
        //Button update = (Button) findViewById(R.id.btnSaveAddress);
        save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {
        EditText street_name = (EditText) findViewById(R.id.txt_Street_name);
        EditText street_number = (EditText) findViewById(R.id.txt_street_number);
        EditText town = (EditText) findViewById(R.id.txt_town);
        EditText street_code = (EditText) findViewById(R.id.txt_street_code);



         intent = getIntent().getExtras();

        switch (view.getId())
        {
            case R.id.btnSaveAddress:
                if(street_name.getText().toString().equals("") ||
                        street_number.getText().toString().equals("") ||
                        town.getText().toString().equals("") ||
                        street_code.getText().toString().equals(""))
                {
                    Toast.makeText(createAddress.this, "You mad bro", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    String[] addressArray = new String[4];

                    addressArray[0] = street_name.getText().toString();
                    addressArray[1] = street_number.getText().toString();
                    addressArray[2] = town.getText().toString();
                    addressArray[3] = street_code.getText().toString();

                    try
                    {
                        details = new String[5];

                        //Bundle intent = getIntent().getExtras();
                        if (intent != null) {
                            details = intent.getStringArray("users");

                            User user = new
                                    User.Builder(
                                    details[1].toString()).
                                    password(details[0].toString()).
                                    email(details[2].toString()).
                                    surname(details[3].toString()).
                                    cell(details[4].toString()).
                                    build();


                            userObj.createUser(user);


                            Address address = new Address.Builder(addressArray[2]).
                            street_name( addressArray[0].toString()).
                            street_number( Integer.parseInt(addressArray[1]))
                            .postel_code(Integer.parseInt(addressArray[3])).
                                    build();






                            addressC.createAddress(address);
                            Toast.makeText(createAddress.this, "create address pass", Toast.LENGTH_SHORT).show();

                        }

                        Toast.makeText(createAddress.this, "made it to database", Toast.LENGTH_SHORT).show();

                    }catch ( NumberFormatException nfe)
                    {
                        Toast.makeText(createAddress.this, "ints not strings bro", Toast.LENGTH_SHORT).show();

                    }catch ( Exception e)
                    {
                        Toast.makeText(createAddress.this, "epic fail dude" + e, Toast.LENGTH_SHORT).show();

                    }
                }
                Intent view_details = new Intent(createAddress.this , view_details.class);

                startActivity(view_details);
        }



    }



}