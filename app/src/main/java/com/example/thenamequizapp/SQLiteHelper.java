package com.example.thenamequizapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;


public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        queryData("CREATE TABLE IF NOT EXISTS PEOPLE(id VARCHAR PRIMARY KEY, image BLOB, name VARCHAR)");
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String id, byte[] image, String name) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO PEOPLE VALUES (?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, id);
        statement.bindBlob(2, image);
        statement.bindString(3, name);


        statement.executeInsert();
    }

    public void updateData(String id, byte[] image, String name) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE PEOPLE SET image = ?, name = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindBlob(1, image);
        statement.bindString(2, name);
        statement.bindString(3, id);

        statement.execute();
        database.close();
    }

    public void deleteData(String id) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "DELETE FROM PEOPLE WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}