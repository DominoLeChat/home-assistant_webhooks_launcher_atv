package com.homecinema.webhook;

import android.app.Activity;
import android.os.Bundle;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(() -> {
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL("http://192.168.0.15:8123/api/webhook/sony_input_bddvd").openConnection();
                conn.setRequestMethod("POST");
                conn.getResponseCode();
            } catch (Exception e) {}
        }).start();
        finish();
    }
}
