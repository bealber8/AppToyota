package com.example.beatriz.toyota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ToyotaActivity extends AppCompatActivity {
    private Spinner spinnerOptions;
    TextView textViewModels;
    Button buttonInformation;

    final static String[] models = new String []{"Menú", "Modelos", "Contacto",
            "Login"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_toyota );
        //setContentView(R.layout.activity_toyota);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, models);

        spinnerOptions = (Spinner) findViewById(R.id.spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);

        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id)
            {
                if (pos == 1){
                    goToModels();
                } else {
                    if (pos == 2){
                        goToContact();
                    } else {
                        if (pos == 3){
                            goToLogin();
                        }
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {    }


        });

        textViewModels = (TextView) findViewById(R.id.textViewModels);
        buttonInformation = (Button) findViewById( R.id.buttonInformation );
        buttonInformation.setOnClickListener( (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInformation();
            }
        }));

    }

    private void showInformation() {
        String url = "http://192.168.1.40:40000/api/avensis";
        RequestQueue requestQueue;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        textViewModels.setText("Response from server: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewModels.setText("Error: " + error.toString());

                    }
                });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    private void goToLogin() {

    }

    private void goToContact() {

    }

    private void goToModels() {
        Intent intent = new Intent(this.getApplicationContext(), ModelsActivity.class);
        startActivity(intent);
    }


}
