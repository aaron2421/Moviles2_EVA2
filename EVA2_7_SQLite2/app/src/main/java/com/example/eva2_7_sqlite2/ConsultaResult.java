package com.example.eva2_7_sqlite2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultaResult extends AppCompatActivity {
    TextView tvConsulta;
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_result);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        tvConsulta = findViewById(R.id.resultado);
        tvConsulta.setText(message);

        //lista = findViewById(R.id.listConsulta);

        //ListAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, message);
        //lista.setAdapter(adaptador);
    }

}
