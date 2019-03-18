package com.example.mydo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView titlepage,subtitlepage,endpage;
    DatabaseReference reference;
    Button btnAddNew;
    RecyclerView ourdoes;
    ArrayList<mydoes> list;
    doesAdapter doesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titlepage=(TextView)findViewById(R.id.titlepage);
        subtitlepage=(TextView)findViewById(R.id.subtitlepage);
        endpage=(TextView)findViewById(R.id.endpage);
        btnAddNew=findViewById(R.id.btnAddNew);
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this,NewTaskAct.class);
                startActivity(a);
            }
        });
        ourdoes=(RecyclerView)findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<mydoes>();

        FirebaseApp.initializeApp(this);
        reference= FirebaseDatabase.getInstance().getReference().child("mydo");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    mydoes p=dataSnapshot1.getValue(mydoes.class);
                    list.add(p);
                }
                doesAdapter=new doesAdapter(MainActivity.this, list);
                ourdoes.setAdapter(doesAdapter);
                doesAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"No Data",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
