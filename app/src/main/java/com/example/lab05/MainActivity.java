package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.example.lab05.sharedpreferences";
    LifecycleData currentRun, lifeTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView currentRunTV, lifeTimeTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //load SharedPrefences
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        //instantiate editor
        editor = sharedPreferences.edit();
        currentRun = new LifecycleData();
        currentRun.duration= "Current Run";
        //get LifecycleData from SharedPreferences as String
        String lifecycleDataAsString = sharedPreferences.getString("lifetime", "");
        //Instantiate a new LifecycleData if empty string
            //else convert the JSON to LifecycleData object
        if(lifecycleDataAsString.equals("")){
            lifeTime = new LifecycleData();
            lifeTime.duration="Lifetime";
        } else {
            lifeTime = LifecycleData.parseJSON(lifecycleDataAsString);
        }
        //instantiate TextViews
        lifeTimeTV = findViewById(R.id.lifetime);
        currentRunTV = findViewById(R.id.current);
        //display data on Textviews
        lifeTimeTV.setText(lifeTime.toString());
        currentRunTV.setText(currentRun.toString());
    }
}