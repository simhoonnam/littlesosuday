package com.example.hoont.jsonprojectstudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDefault();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://skpla.net/ggqME", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //Log.d("sunrin result",);
                tv1.setText(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("sunrin result",statusCode+"");
            }
        });

        String getServerData = "{domino:100,pizza:'맛있다'}";

        try {
            JSONObject jsonObject = new JSONObject(getServerData);
            String domino = jsonObject.getString("domino");
            String pizza = jsonObject.getString("pizza");


            Log.i("json text :","domino = "+ domino+",pizza = "+ pizza );

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setDefault() {
        tv1=(TextView)findViewById(R.id.tv1);
    }
}
