package com.example.finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EpargneActivity extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("comptes");
    private RecyclerView recyclerView;
    private MyAdapterComptes adapter;
    private ArrayList<Compte> list;

    public static String choisie="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epargne);

        recyclerView = findViewById(R.id.list_comptes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new MyAdapterComptes(this, list);
        recyclerView.setAdapter(adapter);
        Query Topteams = root.orderByChild("comptes");
        Topteams.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Compte model = dataSnapshot.getValue(Compte.class);
                        list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void valider(View view) {
        boolean b=false;
        EditText e = findViewById(R.id.a_choisir);
        choisie = e.getText().toString().trim();

        if(choisie.equals("")){
            Toast.makeText(EpargneActivity.this,"Tu dois choisir un compte !",Toast.LENGTH_SHORT).show();
        }
        else{
            for (Compte compte:list)
                if(compte.id.equals(choisie))
                    b=true;
            if(b){
                Intent intent = new Intent(this, SuivieActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(EpargneActivity.this,"L'id donné n'existe pas dans la liste !",Toast.LENGTH_SHORT).show();
            }
        }
    }
}