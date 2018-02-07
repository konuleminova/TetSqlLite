package com.crocusoft.testsqllite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.crocusoft.testsqllite.DBAdapter.DATABASE_NAME;
import static com.crocusoft.testsqllite.MyDataBase.DB_NAME;


public class MainActivity extends AppCompatActivity {
    public static EditText name, phoneNumber;
    public static Button btnOK;
    SQLiteDatabase checkDB;
    DBAdapter db;
    MyDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.name);
        phoneNumber = (EditText) findViewById(R.id.phone_no);
        btnOK = (Button) findViewById(R.id.btn_ok);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            MyContentProvider myContentProvider=new MyContentProvider();
               // MainActivity.this.deleteDatabase(DB_NAME);
            }
        });
    }
    private boolean isDbPresent() {
        Log.v("db", "is DB present Entry!!!");
        boolean checkFlag = true;
        SQLiteDatabase testDb;
        String testPath = getApplicationContext().getApplicationInfo().dataDir + DATABASE_NAME;
        try {
            testDb = SQLiteDatabase.openDatabase(testPath, null,
                    SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException sqlException) {
            Log.v("db", "DB absent");
            checkFlag = false;
        }
        Log.v("db", "is DB present Exit!!!");
        return checkFlag;
    }
}
