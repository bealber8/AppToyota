package com.example.beatriz.toyota;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ModelsActivity extends AppCompatActivity {
    Button buttonAvensis;
    Button buttonAuris;
    Button buttonAygo;
    Button buttonYaris;
    Button buttonGt86;
    Button buttonLandCruiser;
    Button buttonRav4;
    Button buttonChr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonAvensis = (Button) findViewById( R.id.buttonAvensis );
        buttonAvensis.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAvensis();
            }
        }));
    }

    private void goToAvensis() {
        Intent intent = new Intent(this.getApplicationContext(), AvensisActivity.class);
        startActivity(intent);
    }

}
