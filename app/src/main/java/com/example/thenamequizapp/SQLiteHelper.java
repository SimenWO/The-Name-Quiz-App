package com.example.thenamequizapp;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;


public class SQLiteHelper extends SQLiteOpenHelper {

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        //queryData("CREATE TABLE IF NOT EXISTS PEOPLE(id VARCHAR PRIMARY KEY, image BLOB, name VARCHAR)");
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String id, Drawable image, String name) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO PEOPLE VALUES (?, ?, ?)";

        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, id);
        statement.bindBlob(2, bitmapdata);
        statement.bindString(3, name);


        statement.executeInsert();
    }

    public void updateData(String id, Drawable image, String name) {
        SQLiteDatabase database = getWritableDatabase();

        String sql = "UPDATE PEOPLE SET image = ?, name = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);


        Bitmap bitmap = ((BitmapDrawable) image).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bitmapdata = stream.toByteArray();

        statement.bindBlob(1, bitmapdata);
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