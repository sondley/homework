package com.example.homework;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button login;
    private TextView message;

    private int counter = 3;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://videocash.herokuapp.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        username = (EditText)findViewById(R.id.usernameId);
        password = (EditText)findViewById(R.id.passwordId);
        login = (Button) findViewById(R.id.loginId);
        //message = (TextView)findViewById(R.id.loginMessage);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

    }
    public void validate(String userName,String userPassword) {
        if ((userName.equals("abc")) && (userPassword.equals("1234"))) {

            Log.d("HI", "Yes");



            //setContentView(R.layout.billing_info);
        }


    }

    private void sendAndRequestResponse() {

        //RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        //String Request initialized
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("response : "+response.toString());

                Toast.makeText(getApplicationContext(),"Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

               System.out.println("error : "+error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }
}
