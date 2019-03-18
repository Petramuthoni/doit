package com.example.mydo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class editatsk extends AppCompatActivity {
    EditText titleDoes,descDoes,dateDoes;
    Button btnSaveUpdate,btnDelete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editatsk);
        titleDoes=(EditText)findViewById(R.id.titleDoes);
        descDoes=(EditText)findViewById(R.id.descDoes);
        dateDoes=(EditText)findViewById(R.id.dateDoes);
        btnDelete=(Button)findViewById(R.id.btnDelete);
        btnSaveUpdate=(Button)findViewById(R.id.btnSaveatask);
        titleDoes.setText(getIntent().getStringExtra("titleDoes"));
        descDoes.setText(getIntent().getStringExtra("descDoes"));
        dateDoes.setText(getIntent().getStringExtra("dateDoes"));
        final String keykeyDoes=getIntent().getStringExtra("keyDoes");
        reference= FirebaseDatabase.getInstance().getReference().child("BoxDoes").child("Does" + keykeyDoes);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Intent a=new Intent(editatsk.this,MainActivity.class);
                            startActivity(a);
                        }else{
                            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               reference.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       dataSnapshot.getRef().child("titleDoes").setValue(titleDoes.getText().toString());
                       dataSnapshot.getRef().child("descDoes").setValue(descDoes.getText().toString());
                       dataSnapshot.getRef().child("dateDoes").setValue(dateDoes.getText().toString());
                       dataSnapshot.getRef().child("keyDoes").setValue(keykeyDoes);
                       Intent a=new Intent(editatsk.this,MainActivity.class);
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
