package com.example.pwin.lab5;
//Peng Xie 40328958
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
    }
    //Add Meal and Day to database
    //Input Format is not Parsed
    public void addFood(View view){
        Intent intent = new Intent(this,AddActivity.class);
        startActivity(intent);
    }
    //Search Daily intake Energy with specific date.
    //Input Format is not Parsed
    //Tap on Entry will remove that meal.
    public void searchFood(View view){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
}
