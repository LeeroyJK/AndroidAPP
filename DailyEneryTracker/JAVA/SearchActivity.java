package com.example.pwin.lab5;
//Peng Xie 40328958
/*
1 Extra Activity that Sum the Energy intake of Day.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    private Map<String,List<Food>> dataList;
    private FoodAdapter listAdapter;
    private ArrayList<Food> searchList;
    private ChildEventListener childEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("date");
        dataList = new HashMap<String, List<Food>>();
        searchList = new ArrayList<Food>();


        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ArrayList<Food> food = new ArrayList<Food>();
                for(DataSnapshot d: dataSnapshot.getChildren()){
                   food.add(d.getValue(Food.class));
                }
                dataList.put(dataSnapshot.getKey(), food);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        myRef.addChildEventListener(childEventListener);

        listAdapter = new FoodAdapter(this, searchList);
        ListView result = findViewById(R.id.listViewResults);
        result.setAdapter(listAdapter);
        result.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food selected = (Food) parent.getItemAtPosition(position);
                myRef.child(findDate()).child(selected.getName()).removeValue();
                searchList.remove(position);
                listAdapter.notifyDataSetChanged();
            }
        });
    }
    public void search(View view){
        listAdapter.clear();
        boolean found = false;
        EditText text = (EditText)findViewById(R.id.editText_searchDate);
        String search = text.getText().toString();
        Log.d("DataList", String.valueOf(dataList.containsKey("01-01-18")));
        if(dataList.containsKey(search)){
            for(Food f : dataList.get(search)){
                listAdapter.add(f);
            }
            found = true;
        }

        if(!found){
            Toast.makeText(this, search+ " Not Found.", Toast.LENGTH_LONG).show();
        }
    }
    public void goHome(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public String findDate(){
        EditText text = (EditText)findViewById(R.id.editText_searchDate);
        String search = text.getText().toString();
        return search;
    }
}
