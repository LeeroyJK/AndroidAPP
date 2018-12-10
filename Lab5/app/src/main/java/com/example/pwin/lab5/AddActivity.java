package com.example.pwin.lab5;
//Peng Xie 40328958
//Add Meal and on a Day.
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {
//    public static ArrayList<Food> localFoodList = new ArrayList<Food>();
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("date");
    }
    public void add(View view){
        EditText dateText = findViewById(R.id.editText_date);
        String date = dateText.getText().toString();
        EditText foodName = findViewById(R.id.editText_FoodName);
        String name = foodName.getText().toString();
        EditText calorieUnit = findViewById(R.id.editText_unit);
        String unit = calorieUnit.getText().toString();

        if(name.length()>0){
            Food f = new Food(name,unit);
            myRef.child(date).child(name).setValue(f);
            Toast.makeText(this,f.getName()+" Added.", Toast.LENGTH_LONG).show();
        }
        foodName.setText("");
        calorieUnit.setText("");
    }
    public void goHome(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
