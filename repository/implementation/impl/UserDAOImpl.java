package com.example.login.repository.implementation.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.login.database.DBAdapter;
import com.example.login.domain.Address;
import com.example.login.domain.User;
import com.example.login.repository.implementation.UserDAO;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseph on 2014/08/20.
 */
public class UserDAOImpl implements UserDAO
{
    private SQLiteDatabase database ;
    private DBAdapter dbHelper ;
    //private  final Context ourContext ;


    public UserDAOImpl(Context context)
    {
        dbHelper = new DBAdapter(context);
        //ourContext = context;
    }

    public void open() throws SQLException
    {
        //dbHelper = new DBAdapter(ourContext);
        database = dbHelper.getWritableDatabase();
        //return dbHelper;
    }

    public  void close()
    {
        database.close();
    }

    @Override
    public void createUser(User user)
    {
        try
        {
            open();

            ContentValues values = new ContentValues();

            //values.put(DBAdapter.COLUMN_ID, user.getId());
            values.put(DBAdapter.COLUMN_NAME, user.getFist_name().toString());
            values.put(DBAdapter.COLUMN_SURNAME, user.getSurname().toString());
            values.put(DBAdapter.COLUMN_EMAIL, user.getEmail().toString());
            values.put(DBAdapter.COLUMN_CELL, user.getCell().toString());
            values.put(DBAdapter.COLUMN_PASSWORD, user.getPassword().toString());
            //values.put(DBAdapter., user.getCell().toString());

            database.insert(DBAdapter.user_table , null , values);
            close();


        }
        catch(Exception e)
        {

        }
    }

    @Override
    public void updateUser(User user)
    {
        try
        {
            open();

            ContentValues values = new ContentValues();
            values.put(DBAdapter.COLUMN_ID, user.getId());
            values.put(DBAdapter.COLUMN_NAME, user.getFist_name().toString());
            values.put(DBAdapter.COLUMN_SURNAME, user.getSurname().toString());
            values.put(DBAdapter.COLUMN_EMAIL, user.getEmail().toString());
            values.put(DBAdapter.COLUMN_CELL, user.getCell().toString());
            values.put(DBAdapter.COLUMN_PASSWORD, user.getPassword().toString());
            database.update(DBAdapter.user_table, values , DBAdapter.COLUMN_ID + "=?",
                    new String[]{String.valueOf(user.getId())});

            close();
        }
        catch (Exception e)
        {

        }

    }

    @Override
    public User findUserByID(int id)
    {
        User users = null;
        try {
            open();

            Cursor cursor = database.query(DBAdapter.user_table, new String[]
                    {DBAdapter.COLUMN_ID,
                            DBAdapter.COLUMN_NAME,
                            DBAdapter.COLUMN_SURNAME,
                            DBAdapter.COLUMN_EMAIL,
                            DBAdapter.COLUMN_CELL,
                            DBAdapter.COLUMN_PASSWORD}, DBAdapter.COLUMN_ID + "=?" +
                    new String[]{String.valueOf(id)}, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
            }
             users = new User.Builder(cursor.getString(1))
                    .id(cursor.getInt(0))
                    .surname(cursor.getString(2))
                    .email(cursor.getString(3))
                    .cell(cursor.getString(4))
                    .password(cursor.getString(5))
                    .build();
            close();
        }catch (Exception e)
        {

        }

        return users;
    }



    @Override
    public void deleteUsers(User user)
    {
        try{
            open();

            database.delete(DBAdapter.user_table,
                    DBAdapter.COLUMN_ID +"= ?",

                    new String[]{String.valueOf(user.getId())});

            close();

        }catch (Exception e)
        {

        }


    }



    @Override
    public User getUsers()
    {
        String selectQuery = "SELECT * FROM" + DBAdapter.user_table;
        User users = null;
        try
        {
            open();
Cursor cursor = database.rawQuery(selectQuery , null);


            if(cursor.moveToFirst())
            {
                do{
                     users = new User.Builder(cursor.getString(1))
                            .id(cursor.getInt(0))
                            .surname(cursor.getString(2))
                            .email(cursor.getString(3))
                            .cell(cursor.getString(4))
                            .password(cursor.getString(5))
                            .build();
                }while (cursor.moveToNext());
            }
            close();
        }catch (Exception e)
        {

        }

        return users;
    }

    @Override
    public List<User> getAllUsers()
    {
        String selectAllQ = "SELECT * FROM " +
                DBAdapter.user_table +";";

        List<User> allUsers = new ArrayList<User>();
        try
        {
            open();
            Cursor cursor = database.rawQuery(selectAllQ,null);
            if(cursor.moveToFirst())
            {
                do {
                    User users = new User.Builder(cursor.getString(1))
                            .id(cursor.getInt(0))
                            .surname(cursor.getString(2))
                            .email(cursor.getString(3))
                            .cell(cursor.getString(4))
                            .password(cursor.getString(5))
                            .build();

                    allUsers.add(users);
                }while (cursor.moveToNext());
            }
        }catch (Exception e)
        {

        }

        return allUsers;
    }

    @Override
    public boolean findUserByUsername(String name, String password)
    {
        boolean get_it = false ;
        try {
            String selectAllQ = "SELECT * FROM " + DBAdapter.user_table +";";

            open();

            Cursor cursor = database.rawQuery(selectAllQ, null);

            if (cursor.moveToFirst()) {
                do {
                    User users = new User.Builder(cursor.getString(1))
                            .id(cursor.getInt(0))
                            .surname(cursor.getString(2))
                            .email(cursor.getString(3))
                            .cell(cursor.getString(4))
                            .password(cursor.getString(5))
                            .build();

                    if(users.getFist_name().toString().equals(name) || users.getPassword().toString().equals(password))
                    {
                        get_it = true;
                    }

                } while (cursor.moveToNext());
            }
            close();


        } catch (Exception e) {

        }
        return get_it;
    }



}
