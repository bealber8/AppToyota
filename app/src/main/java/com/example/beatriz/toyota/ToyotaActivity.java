package com.example.beatriz.toyota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ToyotaActivity extends AppCompatActivity {
    private Spinner spinnerOptions;

    final static String[] models = new String []{"Menu", "Models", "Contact Us"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_toyota );
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_spinner_item, models );

        spinnerOptions = (Spinner) findViewById( R.id.spinnerOptions );
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinnerOptions.setAdapter( adapter );

        spinnerOptions.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                if (pos == 1) {
                    goToModels();
                } else {
                    if (pos == 2) {
                        goToContact();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }


        } );
    }

    private void goToContact() {
        Intent intent = new Intent(this.getApplicationContext(), ContactUsActivity.class);
        startActivity(intent);
    }

    private void goToModels() {
        Intent intent = new Intent(this.getApplicationContext(), ModelsActivity.class);
        startActivity(intent);
    }


}
