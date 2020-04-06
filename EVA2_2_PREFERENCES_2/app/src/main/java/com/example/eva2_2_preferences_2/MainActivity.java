package com.example.eva2_2_preferences_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();
        transaccion.replace(android.R.id.content, new Preferencias());
        transaccion.commit();
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        Toast.makeText(this, shared.getString("NOMBRE", "xx"), Toast.LENGTH_LONG).show();
    }

    public static class Preferencias extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preference_screen, rootKey);
        }
    }
}
