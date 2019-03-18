package com.example.mydo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTaskAct extends AppCompatActivity {
    TextView titlepage,addtitle;
    EditText titleDoes,descDoes,dateDoes;
    Button save,cancel;
    DatabaseReference reference;
    Integer doesNum=new Random().nextInt();
    String keyDoes=Integer.toString(doesNum);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        titlepage=(TextView)findViewById(R.id.titlepage);
        addtitle=(TextView)findViewById(R.id.addtitle);
        titleDoes=(EditText) findViewById(R.id.titleDoes);
        descDoes=(EditText) findViewById(R.id.descDoes);
        dateDoes=(EditText) findViewById(R.id.dateDoes);
        save=(Button)findViewById(R.id.btnSaveatask);
        cancel=(Button)findViewById(R.id.btnCancel);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference= FirebaseDatabase.getInstance().getReference().child("BoxDoes").child("Does" + doesNum);
                 reference.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         dataSnapshot.getRef().child("titleDoes").setValue(titleDoes.getText().toString());
                         dataSnapshot.getRef().child("descDoes").setValue(descDoes.getText().toString());
                         dataSnapshot.getRef().child("dateDoes").setValue(dateDoes.getText().toString());
                         dataSnapshot.getRef().child("keyDoes").setValue(keyDoes);
                         Intent a=new Intent(NewTaskAct.this,MainActivity.class);
                         startActivity(a);





                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });


            }
        });

    }
}
