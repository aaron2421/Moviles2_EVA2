package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static String res = "";
    //public ArrayList<String> listaNueva = new ArrayList<>();

    SQLiteDatabase db;
    EditText editNombre;
    EditText editCelular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNombre = findViewById(R.id.edNombre);
        editCelular = findViewById(R.id.edCelular);

        db = this.openOrCreateDatabase("miBdd", MODE_PRIVATE, null);

        //db.execSQL("create table amigo (ID integer PRIMARY KEY autoincrement, name text, phone text); ");

        /*
        db.execSQL( "insert into amigo(name, phone) values ('Aaron', '555-1111');" );
        db.execSQL( "insert into amigo(name, phone) values ('Beto', '555-2222');" );
        db.execSQL( "insert into amigo(name, phone) values ('Lalo', '555-3333');" );
         */

    }

    public void anadir(View v){
        db.execSQL( "insert into amigo(name, phone) values ('" + editNombre.getText().toString() + "', '"+ editCelular.getText().toString() +"');" );
    }

    public void consulta(View v){
        String sql = "select * from amigo";
        Cursor c1 = db.rawQuery(sql, null);
        //int i = 0;
        c1.moveToPosition(-1);
        while ( c1.moveToNext() ) {
            int ID = c1.getInt(0);
            String name = c1.getString(1);
            String phone = c1.getString(c1.getColumnIndex("phone"));

            //listaNueva.add(name + " - " + phone);

            res += ID + " " + name + " " + phone + "\n";

        }
            Intent intent = new Intent(this, ConsultaResult.class);
            intent.putExtra(EXTRA_MESSAGE, res);
            startActivity(intent);
    }
}
