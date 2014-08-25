package com.example.login.repository.implementation.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import com.example.login.database.DBAdapter;
import com.example.login.domain.Address;
import com.example.login.domain.User;
import com.example.login.repository.implementation.AddressDAO;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 2014/08/20.
 */
public class AddressDAOImpl implements AddressDAO
{
    private SQLiteDatabase database;
    private DBAdapter dbHelper;

    public AddressDAOImpl(Context context)
    {
        dbHelper = new DBAdapter(context);
    }

    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();

    }

    public void close()
    {
        dbHelper.close();
    }

    @Override
    public void createAddress(Address address) {
        try {
            open();

            ContentValues values = new ContentValues();
//            values.put(
//                    DBAdapter.COLUMN_ID,
//                    address.getId()
//
//            );
            values.put(
                    DBAdapter.COLUMN_POSTCODE,
                    address.getPostel_code()

            );
            values.put(
                    DBAdapter.COLUMN_STREET_NAME,
                    address.getStreet_name()
            );
            values.put(
                    DBAdapter.COLUMN_STREET_NUMBER,
                    address.getStreet_number()
            );
            values.put(DBAdapter.COLUMN_TOWN,
                    address.getTown()
            );

            database.insert(DBAdapter.address_table, null, values);
            close();

        } catch (Exception e) {
            Toast.makeText(null, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void updateAddress(Address address)
    {
        try {
            open();

            ContentValues values = new ContentValues();
            values.put(DBAdapter.address_table , address.getId());
            values.put(DBAdapter.address_table , address.getPostel_code());
            values.put(DBAdapter.address_table , address.getStreet_name());
            values.put(DBAdapter.address_table , address.getStreet_number());
            values.put(DBAdapter.address_table , address.getTown());

            database.update(DBAdapter.address_table, values , DBAdapter.COLUMN_ID + "=?",
                    new String[]{String.valueOf(address.getId())});

            close();

        }catch (Exception e)
        {

        }
    }

    @Override
    public Address findAddressByID(int id)
    {
        Address address = null;
        try {
            open();

            Cursor cursor = database.query(DBAdapter.address_table, new String[]
                    {DBAdapter.COLUMN_ID,
                            DBAdapter.COLUMN_POSTCODE,
                            DBAdapter.COLUMN_STREET_NAME,
                            DBAdapter.COLUMN_STREET_NUMBER,
                            DBAdapter.COLUMN_TOWN}, DBAdapter.COLUMN_ID + "=?" +
                    new String[]{String.valueOf(id)}, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
            }
                     address = new Address.Builder(cursor.getString(0))
                    .postel_code(cursor.getInt(1))
                    .street_name(cursor.getString(2))
                    .street_number(cursor.getInt(3))
                    .town(cursor.getString(4))
                    .build();

            close();

        }catch (Exception e)
        {

        }

        return address;
    }

    @Override
    public void deleteAddress(Address address)
    {
        try{
            open();

            database.delete(DBAdapter.user_table,
                    DBAdapter.COLUMN_ID +"= ?",

                    new String[]{String.valueOf(address.getId())});

            close();

        }catch (Exception e)
        {

        }
    }

    @Override
    public Address getAddress()
    {
        String selectQuery = "SELECT * FROM" + DBAdapter.user_table;
        Address address = null;
        try
        {
            open();
            Cursor cursor = database.rawQuery(selectQuery , null);


            if(cursor.moveToFirst())
            {
                do{
                    address = new Address.Builder(cursor.getString(0))
                            .postel_code(cursor.getInt(1))
                            .street_name(cursor.getString(2))
                            .street_number(cursor.getInt(3))
                            .town(cursor.getString(4))
                            .build();
                }while (cursor.moveToNext());
            }
            close();
        }catch (Exception e)
        {

        }
        return address;
    }

    @Override
    public List<Address> getAddressList() {
        List<Address> addressList = null;
        try {
            String selectAllQ = "SELECT * FROM " + DBAdapter.address_table;

            addressList = new ArrayList<Address>();
            open();

            Cursor cursor = database.rawQuery(selectAllQ, null);

            if (cursor.moveToFirst()) {
                do {
                    Address address = new Address.Builder(cursor.getString(0))
                            .postel_code(cursor.getInt(1))
                            .street_name(cursor.getString(2))
                            .street_number(cursor.getInt(3))
                            .town(cursor.getString(4))
                            .build();

                    addressList.add(address);

                } while (cursor.moveToNext());
            }
            close();


        } catch (Exception e)
        {
            Toast.makeText(null,  e.toString() , Toast.LENGTH_SHORT).show();

        }
        return addressList;
    }
}
