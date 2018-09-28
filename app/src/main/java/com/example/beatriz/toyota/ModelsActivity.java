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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonAvensis = (Button) findViewById( R.id.buttonAvensis );
        buttonAvensis.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAvensis();
            }
        }));

        buttonAuris = (Button) findViewById( R.id.buttonAuris );
        buttonAuris.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAuris();
            }
        }));

        buttonAygo = (Button) findViewById( R.id.buttonAygo );
        buttonAygo.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAygo();
            }
        }));

        buttonYaris = (Button) findViewById( R.id.buttonYaris );
        buttonYaris.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToYaris();
            }
        }));

        buttonGt86 = (Button) findViewById( R.id.buttonGt86 );
        buttonGt86.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToGt86();
            }
        }));

        buttonLandCruiser = (Button) findViewById( R.id.buttonLandCruiser );
        buttonLandCruiser.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLandCruiser();
            }
        }));

        buttonRav4 = (Button) findViewById( R.id.buttonRav4 );
        buttonRav4.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRav4();
            }
        }));

        buttonChr = (Button) findViewById( R.id.buttonChr );
        buttonChr.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToChr();
            }
        }));
    }

    private void goToChr(){
        Intent intent = new Intent(this.getApplicationContext(), ChrActivity.class);
        startActivity(intent);
    }

    private void goToRav4() {
        Intent intent = new Intent(this.getApplicationContext(), Rav4Activity.class);
        startActivity(intent);
    }

    private void goToLandCruiser() {
        Intent intent = new Intent(this.getApplicationContext(), LandCruiserActivity.class);
        startActivity(intent);
    }

    private void goToGt86() {
        Intent intent = new Intent(this.getApplicationContext(), Gt86Activity.class);
        startActivity(intent);
    }

    private void goToYaris() {
        Intent intent = new Intent(this.getApplicationContext(), YarisActivity.class);
        startActivity(intent);
    }

    private void goToAygo() {
        Intent intent = new Intent(this.getApplicationContext(), AygoActivity.class);
        startActivity(intent);
    }

    private void goToAuris() {
        Intent intent = new Intent(this.getApplicationContext(), AurisActivity.class);
        startActivity(intent);
    }

    private void goToAvensis() {
        Intent intent = new Intent(this.getApplicationContext(), AvensisActivity.class);
        startActivity(intent);
    }

}
