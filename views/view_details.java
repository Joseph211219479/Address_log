package com.example.login.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.login.R;
import com.example.login.domain.Address;
import com.example.login.domain.User;
import com.example.login.repository.implementation.AddressDAO;
import com.example.login.repository.implementation.UserDAO;
import com.example.login.repository.implementation.impl.AddressDAOImpl;
import com.example.login.repository.implementation.impl.UserDAOImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Common Sense on 8/24/2014.
 */
public class view_details extends Activity implements View.OnClickListener{
    private List<User> studentList = new ArrayList<User>();
    private List<Address> addList = new ArrayList<Address>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_details);

        Button btnclose =  (Button) findViewById(R.id.btnClose);
        btnclose.setOnClickListener(this);

        final UserDAO userdao = new UserDAOImpl(this);
        final AddressDAO addressdao = new AddressDAOImpl(this);

        studentList = userdao.getAllUsers();
        addList = addressdao.getAddressList();

        String[] surnames = new String[studentList.size()];
        String[] cell = new String[studentList.size()];

        last(surnames);
        cells(cell);
        int[] buttons = new int[studentList.size()];
//
        ListView listview;

        dataRetriever adapter = new dataRetriever(view_details.this, surnames, cell, buttons);
        listview = (ListView) findViewById(R.id.listv);
        listview.setAdapter(adapter);

    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnClose:
                finish();
                break;


        }

    }

    public void last( String[] values )
    {
        int count = 0;

        for( User s : studentList )
        {
            values[count] = s.getSurname();
            count++;
        }
    }

    public void cells( String[] values )
    {
        int count = 0;

        for( User s : studentList )
        {
            values[count] = s.getCell();
            count++;
        }
    }
}