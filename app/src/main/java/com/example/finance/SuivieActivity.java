package com.example.finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SuivieActivity extends AppCompatActivity {

    private DatabaseReference reference;
    public String id = EpargneActivity.choisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivie);
        TextView choisie = findViewById(R.id.choisie);
        choisie.setText(id);
        reference = FirebaseDatabase.getInstance().getReference("comptes");
        TextView solde = findViewById(R.id.solde);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot dataSnapshot = snapshot.child(id);
                Compte compte = dataSnapshot.getValue(Compte.class);
                float s = compte.getSolde();
                solde.setText(s+" DT");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }
}