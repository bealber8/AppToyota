package com.example.beatriz.toyota;

import android.app.ProgressDialog;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AvensisActivity extends AppCompatActivity {
    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Models> modelsList;
    private RecyclerView.Adapter adapter;

    String url = "http://192.168.1.35:40000/api/avensis";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_avensis );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        mList = findViewById(R.id.main_list);

        modelsList = new ArrayList<>();
        adapter = new ModelsAdapter(getApplicationContext(),modelsList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        showInformation();
    }

    private void showInformation() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Models models = new Models();
                        models.setName(jsonObject.getString("name"));
                        models.setPower(jsonObject.getString("power"));
                        models.setFuel(jsonObject.getString("fuel"));
                        models.setPrice(jsonObject.getString("price"));

                        modelsList.add(models);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    /*private void showInformation() {
        String url = "http://192.168.1.40:40000/api/avensis";
        RequestQueue requestQueue;

        JsonArrayRequest jsonArrayRequest = new
                JsonArrayRequest(Request.Method.GET, url, null,
                new com.android.volley.Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("TAG", response.toString());

                        try {

                            Log.d("JsonArray",response.toString());
                            for(int i=0;i<response.length();i++){
                                JSONObject jresponse = response.getJSONObject(i);
                                String name = jresponse.getString("name");
                                Log.d("nickname",name);
                                textViewModels.setText(name);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //pDialog.dismiss();

                    }
                }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
                //pDialog.dismiss();

            }
        });*/
        //final ListView lstModels = (ListView) findViewById(R.id.lstModels);
        /*
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
            public void onResponse(JSONArray response) {
                        try {
                            //JSONObject modelObj = response.getJSONObject(0);
                            JSONArray modelArray = new JSONArray(response);
                            String[] models = new String[modelArray.length()];
                            for (int i = 0; i < modelArray.length(); i++) {
                                JSONObject jsonObject = modelArray.getJSONObject(i);

                                String name = jsonObject.getString("Name");
                                String power = jsonObject.getString("Power");
                                String gas = jsonObject.getString("Gas");
                                String price = jsonObject.getString("Price");

                                models[i] = " " + name + "" + power + "" + gas + "" +price;

                                //data += "Name: " + name + "Power: " + power +
                                       // "Gas: " + gas + "Price: " + price;

                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, models);
                                lstModels.setAdapter(adapter);
                            }
                            textViewModels.setText(data);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //textViewModels.setText("Error: " + error.toString());
                    Log.e("Volley", "Error");
                }
            });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);*/
        }
/*
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
        requestQueue.add(jsonObjectRequest);*/
/*
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                textViewModels.setText("Response from server: " + response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                textViewModels.setText("Error: " + error.toString());

            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);




        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Do something with response
                        //mTextView.setText(response.toString());

                        // Process the JSON
                        try{
                            // Loop through the array elements
                            for(int i=0;i<response.length();i++){
                                // Get current json object
                                JSONObject information = response.getJSONObject(i);

                                // Get the current student (json object) data
                                String name = information.getString("Name");
                                String power = information.getString("Power");
                                String gas = information.getString("Gas");
                                String price = information.getString("Price");

                                // Display the formatted json data in text view
                                textViewModels.append(name +" " + power +" " + gas +" "+price);
                                textViewModels.append("\n\n");
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred
                        textViewModels.setText("Error");
                    }
                });


        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);*/




