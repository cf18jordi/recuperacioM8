package com.example.recuperaciom8.SQLite.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.recuperaciom8.SQLite.DB.ContactsContract.*;
import com.example.recuperaciom8.SQLite.Model.Ubicacio;

import java.util.ArrayList;

public class ContactsDBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ubicacions.db";


    public ContactsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ContactsEntry.TABLE_NAME + "(" +
                    ContactsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ContactsEntry.COLUMN_NAME_TITLE + " TEXT," +
                    ContactsEntry.COLUMN_NAME_TITLE2 + " TEXT," +
                    ContactsEntry.COLUMN_NAME_TITLE3 + " TEXT)";

    public void dropDatabase(SQLiteDatabase db){
        db.execSQL("DROP TABLE " + ContactsEntry.TABLE_NAME);
    }

    public void insertContact(SQLiteDatabase db, Ubicacio c){
        //Check the bd is open
        if (db.isOpen()){

            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(ContactsEntry.COLUMN_NAME_TITLE, c.getCiutat());
            values.put(ContactsEntry.COLUMN_NAME_TITLE2, c.getTemps());
            values.put(ContactsEntry.COLUMN_NAME_TITLE3, c.getTemperatura());

            db.insert(ContactsEntry.TABLE_NAME, null, values);

        }else{
            Log.i("sql","Database is closed");

        }
    }

    public ArrayList<Ubicacio> getAllData(SQLiteDatabase db) {
        ArrayList<Ubicacio> array_ubi = new ArrayList<>();

        Cursor resultSet = db.rawQuery("select * from Ubicacio", null);
        if (resultSet.moveToFirst()) {
            do {
                String ciutat = resultSet.getString(1);
                String temps = resultSet.getString(2);
                String temperatura = resultSet.getString(3);



                array_ubi.add(new Ubicacio(ciutat, temps, temperatura));
            } while (resultSet.moveToNext());
        }
        resultSet.close();
        return array_ubi;
    }


}
