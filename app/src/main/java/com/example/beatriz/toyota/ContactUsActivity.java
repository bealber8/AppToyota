package com.example.beatriz.toyota;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContactUsActivity extends AppCompatActivity {
    EditText editTextId;
    EditText editTextName;
    EditText editTextEmail;
    EditText editTextTelephone;
    EditText editTextFeedback;
    Button buttonValidate;

    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Users> usersList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mList = findViewById(R.id.main_list);

        usersList = new ArrayList<>();
        adapter = new UsersAdapters(getApplicationContext(),usersList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextTelephone = (EditText) findViewById(R.id.editTextTelephone);
        editTextFeedback = (EditText) findViewById(R.id.editTextFeedback);

        buttonValidate = (Button) findViewById(R.id.buttonValidate);
        buttonValidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validar();
            }
        });
    }

    private void validar() {
        editTextId.setError(null);
        editTextName.setError(null);
        editTextEmail.setError(null);
        editTextTelephone.setError(null);
        editTextFeedback.setError(null);

        String id = editTextId.getText().toString();
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String telephone = editTextTelephone.getText().toString();
        String feedback = editTextFeedback.getText().toString();

        if (TextUtils.isEmpty(id)){
            editTextId.setError(getString(R.string.errorFieldRequired));
            editTextId.requestFocus();
            return;
        }

        int idNumber = Integer.parseInt(id);

        if (TextUtils.isEmpty(name)){
            editTextName.setError(getString(R.string.errorFieldRequired));
            editTextName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)){
            editTextEmail.setError(getString(R.string.errorFieldRequired));
            editTextEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(telephone)){
            editTextTelephone.setError(getString(R.string.errorFieldRequired));
            editTextTelephone.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(feedback)){
            editTextFeedback.setError(getString(R.string.errorFieldRequired));
            editTextFeedback.requestFocus();
            return;
        }

        String url = ("http://192.168.1.35:40000/api/answer/" + idNumber);
        RequestQueue requestQueue;

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    Users users = new Users();
                    users.setId(response.getString("id"));
                    users.setName(response.getString("name"));
                    users.setEmail(response.getString("email"));

                    usersList.add(users);
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
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
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

    }

}
