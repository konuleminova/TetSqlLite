package com.crocusoft.testsqllite;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Asus on 2/7/2018.
 */

public class MyDataBase extends SQLiteOpenHelper {
    public static String DB_NAME = "mydb.db";
    public static String TABLE_NAME = "mycontacts";
    public static String KEY_ID = "_id";
    public static String KEY_NAME = "_name";
    public static String KEY_PHONE_NO = "_phoneNumber";
    public static String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PHONE_NO + " TEXT" + ")";
    public MyDataBase(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public MyDataBase open() throws SQLException {
        this.getWritableDatabase();
        return this;
    }
}
