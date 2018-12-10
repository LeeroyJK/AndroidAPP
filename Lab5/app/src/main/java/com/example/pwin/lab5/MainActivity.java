package com.example.pwin.lab5;
//Peng Xie 40328958
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Go to Report Activity that show Daily Energy Report
    public void compute(View view){
        Intent intent = new Intent(this, ReportActivity.class);
        startActivity(intent);
    }
    //Go to Firebase to Add/Search/Remove on Database
    public void dataBase(View view){
        Intent intent = new Intent(this,DatabaseActivity.class);
        startActivity(intent);
    }
}
