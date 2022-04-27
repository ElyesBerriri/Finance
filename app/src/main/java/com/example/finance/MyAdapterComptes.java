package com.example.finance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapterComptes extends RecyclerView.Adapter<MyAdapterComptes.MyViewHolder>{

    ArrayList<Compte> mList;
    Context context;

    public MyAdapterComptes(Context c, ArrayList<Compte> l){
        this.mList = l;
        this.context = c;
    }

    @NonNull
    @Override
    public MyAdapterComptes.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(context).inflate(R.layout.item_compte,parent, false);
        return new MyAdapterComptes.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterComptes.MyViewHolder holder , int position){
        Compte model = mList.get(position);
        holder.name.setText(model.get_id());
    }

    @Override
    public int getItemCount(){
        return mList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.item_compte_text);
        }
    }
}

