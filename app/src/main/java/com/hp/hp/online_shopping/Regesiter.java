package com.hp.hp.online_shopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

public class Regesiter extends AppCompatActivity {
EditText name,email,phone,address;
    AsyncHttpClient client;
    JSONArray jarray;
    JSONObject jobject,jobject1;
    RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regesiter);
    }
}
