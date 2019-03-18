package com.example.mydo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class doesAdapter extends RecyclerView.Adapter<doesAdapter.myViewHolder>{
    Context context;
    ArrayList<mydoes> mydoes;
    public doesAdapter(Context c,ArrayList<mydoes> p){
        context=c;
        mydoes=p;


    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(myViewHolder myViewHolder, int i) {
       myViewHolder.titleDoes.setText(mydoes.get(i).getTitledoes());
        myViewHolder.descDoes.setText(mydoes.get(i).getDescdoes());
        myViewHolder.dateDoes.setText(mydoes.get(i).getDatedoes());

        final String getTitleDoes=mydoes.get(i).getTitledoes();
        final String getDescDoes=mydoes.get(i).getDescdoes();
        final String getDateDoes=mydoes.get(i).getDatedoes();
        final String getkeyDoes=mydoes.get(i).getKeyDoes();
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aa=new Intent(context,editatsk.class);
                aa.putExtra("titleDoes",getTitleDoes);
                aa.putExtra("descDoes",getDescDoes);
                aa.putExtra("dateDoes",getDateDoes);
                aa.putExtra("keyDoes",getkeyDoes);
                context.startActivity(aa);
            }
        });



    }

    @Override
    public int getItemCount() {
        return mydoes.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView titleDoes,descDoes,keyDoes,dateDoes;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            titleDoes=(TextView)itemView.findViewById(R.id.titledoes);
            descDoes=(TextView)itemView.findViewById(R.id.descdoes);
            dateDoes=(TextView)itemView.findViewById(R.id.datedoes);


        }
    }
}
