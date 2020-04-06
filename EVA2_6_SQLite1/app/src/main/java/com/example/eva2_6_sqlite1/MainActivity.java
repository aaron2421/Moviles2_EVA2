package com.example.eva2_6_sqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = this.openOrCreateDatabase("miBdd", MODE_PRIVATE, null);

        db.execSQL("create table amigo2 (ID integer PRIMARY KEY autoincrement, name text, phone text); ");

        db.execSQL( "insert into amigo(name, phone) values ('AAA', '555-1111');" );
        db.execSQL( "insert into amigo(name, phone) values ('BBB', '555-2222');" );
        db.execSQL( "insert into amigo(name, phone) values ('CCC', '555-3333');" );
    }

}
