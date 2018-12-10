package com.example.pwin.lab5;
//Peng Xie 40328958
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportActivity extends AppCompatActivity {
    DatabaseReference myRef;
    Map<String, List<Food>> dataList;
    ChildEventListener childEventListener;
    ReportAdapter  listAdapter;
    ArrayList<Entry> entryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        myRef= FirebaseDatabase.getInstance().getReference("date");
        dataList = new HashMap<String, List<Food>>();
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
        entryList = new ArrayList<Entry>();
        listAdapter = new ReportAdapter(this, entryList);
        ListView result = findViewById(R.id.listView_Daily);
        result.setAdapter(listAdapter);
    }

    public void check(View view){
        listAdapter.clear();
        for(Map.Entry<String, List<Food>> e: dataList.entrySet()){
            String key = e.getKey();
//            Log.d("Entry Key", key);
            int num = 0;
            for(Food f: e.getValue()){
                num += Integer.parseInt(f.getEnergy());
            }
//            Log.d("Entry Energy",String.valueOf(num));
            entryList.add(new Entry(key,Integer.toString(num)));
        }
    }
}
