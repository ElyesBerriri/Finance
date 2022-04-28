package com.example.finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewEpargneActivity extends AppCompatActivity {

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_epargne);
    }

    public void addCompte(View view) {


        EditText e0 = (EditText) findViewById(R.id.compte_id);
        String id = e0.getText().toString().trim();

        EditText  e1 = (EditText) findViewById(R.id.impot);
        float impot = Float.parseFloat(e1.getText().toString().trim());

        EditText e2 = (EditText) findViewById(R.id.jan);
        float jan = Float.parseFloat(e2.getText().toString().trim());

        EditText e3 = (EditText) findViewById(R.id.fev);
        float fev = Float.parseFloat(e3.getText().toString().trim());

        EditText e4 = (EditText) findViewById(R.id.mars);
        float mars = Float.parseFloat(e4.getText().toString().trim());

        EditText e5 = (EditText) findViewById(R.id.avr);
        float avr = Float.parseFloat(e5.getText().toString().trim());

        EditText e6 = (EditText) findViewById(R.id.mai);
        float mai = Float.parseFloat(e6.getText().toString().trim());

        EditText e7 = (EditText) findViewById(R.id.juin);
        float juin = Float.parseFloat(e7.getText().toString().trim());

        EditText e8 = (EditText) findViewById(R.id.juil);
        float juil = Float.parseFloat(e8.getText().toString().trim());

        EditText e9 = (EditText) findViewById(R.id.aout);
        float aout = Float.parseFloat(e9.getText().toString().trim());

        EditText e10 = (EditText) findViewById(R.id.sep);
        float sep = Float.parseFloat(e10.getText().toString().trim());

        EditText e11 = (EditText) findViewById(R.id.oct);
        float oct = Float.parseFloat(e11.getText().toString().trim());

        EditText e12 = (EditText) findViewById(R.id.nov);
        float nov = Float.parseFloat(e12.getText().toString().trim());

        EditText e13 = (EditText) findViewById(R.id.dec);
        float dec = Float.parseFloat(e13.getText().toString().trim());

        EditText e14 = findViewById(R.id.solde_input);
        float solde = Float.parseFloat(e14.getText().toString().trim());

        int j;
        EditText e15 = findViewById(R.id.jours);
        if(e15.getText().toString().equals(""))
            j=0;
        else
            j = Integer.parseInt(e15.getText().toString().trim());

        int m;
        EditText e16 = findViewById(R.id.mois);
        if(e16.getText().toString().equals(""))
            m=0;
        else
            m = Integer.parseInt(e16.getText().toString().trim());

        int a;
        EditText e17 = findViewById(R.id.annee);
        if(e17.getText().toString().equals(""))
            a=0;
        else
            a = Integer.parseInt(e17.getText().toString().trim());

        reference = FirebaseDatabase.getInstance().getReference("comptes");

        if(id.equals(""))
            Toast.makeText(NewEpargneActivity.this,"Tu dois donner un id au compte !",Toast.LENGTH_SHORT).show();
        else if(j==0 || j>31)
            Toast.makeText(NewEpargneActivity.this,"Tu dois préciser un jour valide !",Toast.LENGTH_SHORT).show();
        else if(m==0 || m>12)
            Toast.makeText(NewEpargneActivity.this,"Tu dois préciser un mois valide !",Toast.LENGTH_SHORT).show();
        else if(a<1000)
            Toast.makeText(NewEpargneActivity.this,"Tu dois préciser une année valide !",Toast.LENGTH_SHORT).show();
        else{
            Compte compte = new Compte(id,j,m,a,solde,impot,jan,fev,mars,avr,mai,juin,juil,aout,sep,oct,nov,dec);
            reference.child(id).setValue(compte).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(NewEpargneActivity.this, MainActivity.class));
                        Toast.makeText(NewEpargneActivity.this,"Le compte est ajouté avec succés !",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(NewEpargneActivity.this,"Echec lors du création du compte !",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
}