package com.example.login.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by joseph on 2014/08/20.
 */
public class DBAdapter extends SQLiteOpenHelper
{
    public static  final String user_table = "USER";
    public static  final String address_table = "ADDRESS";

    public static  final String COLUMN_ID = "_id";

    public static  final String COLUMN_NAME = "name";
    public static  final String COLUMN_SURNAME = "surname";
    public static  final String COLUMN_EMAIL = "email";
    public static  final String COLUMN_CELL = "cell";
    public static  final String COLUMN_PASSWORD = "password";

    public static  final String COLUMN_POSTCODE = "postel_code";
    public static  final String COLUMN_STREET_NAME = "street_name";
    public static  final String COLUMN_STREET_NUMBER = "street_number";
    public static  final String COLUMN_TOWN = "town";


    private  static final String DATABASE_NAME = "addressbookdatabase.db";
    private  static  final int DB_VERSION = 1;

    private static  final String CREATE_TABLE_USERS = " CREATE TABLE IF NOT EXISTS " +
            user_table+" ( "
            +COLUMN_ID +" INTEGER PRIMARY KEY autoincrement ,"
            +COLUMN_NAME+" TEXT NOT NULL ,"
            +COLUMN_SURNAME+" TEXT NOT NULL ,"
            +COLUMN_EMAIL+" TEXT NOT NULL ,"
            +COLUMN_CELL+" TEXT NOT NULL , "
            +COLUMN_PASSWORD+ " TEXT NOT NULL );"
            ;

    private static  final String CREATE_TABLE_Address = "CREATE TABLE IF NOT EXISTS " +
            address_table+" ( "
            +COLUMN_ID +" INTEGER PRIMARY KEY autoincrement , "
            +COLUMN_POSTCODE+" NUMBER NOT NULL ,"
            +COLUMN_STREET_NAME+" TEXT NOT NULL ,"
            +COLUMN_STREET_NUMBER+" NUMBER NOT NULL ,"
            +COLUMN_TOWN+" TEXT NOT NULL);"
            ;

    public DBAdapter(Context context)
    {
        super(context, DATABASE_NAME, null,  DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
       // sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TEST (id TEXT PRIMARY KEY , name TEXT );");
        sqLiteDatabase.execSQL(CREATE_TABLE_Address);
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int old, int updated)
    {
        Log.w(DBAdapter.class.getName(), "UPGRADE FROM VERSION " + old + "to"
                + updated + ",which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS; " + CREATE_TABLE_Address  );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ;" + CREATE_TABLE_USERS );

        onCreate(sqLiteDatabase);

    }

}
