package com.hp.hp.online_shopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
EditText phone,password;
    AsyncHttpClient client;
    JSONArray jarray;
    JSONObject jobject,jobject1;
    RequestParams params;
    String api="http://srishti-systems.info/projects/online_shopping/login.php?contactnum=8888&password=jan";
    String url="http://srishti-systems.info/projects/online_shopping/login.php?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        client = new AsyncHttpClient();
        params = new RequestParams();


    }

    public void login(View view) {
        String phone_string=phone.getText().toString();
        String pass_string=password.getText().toString();
        params.put("contactnum",phone_string);
        params.put("password",pass_string);
        if(pass_string!=""&&pass_string!="") {
            client.get(url, params, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(String content) {
                    super.onSuccess(content);
try{

    jobject = new JSONObject(content);
    String s = jobject.getString("status");
if(s.equalsIgnoreCase("success"))
{
     startActivity(new Intent(Login.this,Dash.class));

}
else{
    Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
}
}catch (Exception e){}

                }
            });
        }else{
            Toast.makeText(Login.this, "Fiels cant be empty", Toast.LENGTH_SHORT).show();

        }

    }

    public void Register(View view) {
        startActivity(new Intent(Login.this,Regesiter.class));

    }
}
