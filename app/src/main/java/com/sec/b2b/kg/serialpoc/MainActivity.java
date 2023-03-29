package com.sec.b2b.kg.serialpoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.RestrictionsManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String SERIAL_KEY = "device_serial";

    public void setTextView(String text){
        TextView textView = findViewById(R.id.text_view);
        textView.setText(text);
    }
    public Bundle getApplicationRestrictions(){
        RestrictionsManager restrictionsManager = (RestrictionsManager) getSystemService(Context.RESTRICTIONS_SERVICE);
        Bundle bundle = restrictionsManager.getApplicationRestrictions();
        return bundle;
    }
    public String getSerial(Bundle bundle){
        if(bundle.containsKey(SERIAL_KEY)){
           return bundle.getString(SERIAL_KEY);
        } else {
            return "error";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTextView("ala ma kota");
    }

    @Override
    protected void onResume() {
        super.onResume();
        setTextView(getSerial(getApplicationRestrictions()));
    }
}