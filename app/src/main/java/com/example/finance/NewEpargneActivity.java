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

        EditText e0 = findViewById(R.id.compte_id);
        String id = e0.getText().toString().trim();

        float impot=0f;
        EditText e1 = findViewById(R.id.impot);
        if(!e1.getText().toString().trim().equals(""))
            impot = Float.parseFloat(e1.getText().toString().trim());

        float jan=0f;
        EditText e2 = findViewById(R.id.jan);
        if(!e2.getText().toString().trim().equals(""))
            jan = Float.parseFloat(e2.getText().toString().trim());

        float fev=0f;
        EditText e3 = findViewById(R.id.fev);
        if(!e3.getText().toString().trim().equals(""))
            fev = Float.parseFloat(e3.getText().toString().trim());

        float mars=0f;
        EditText e4 = findViewById(R.id.mars);
        if(!e4.getText().toString().trim().equals(""))
            mars = Float.parseFloat(e4.getText().toString().trim());

        float avr=0f;
        EditText e5 = findViewById(R.id.avr);
        if(!e5.getText().toString().trim().equals(""))
            avr = Float.parseFloat(e5.getText().toString().trim());

        float mai=0f;
        EditText e6 = findViewById(R.id.mai);
        if(!e6.getText().toString().trim().equals(""))
            mai = Float.parseFloat(e6.getText().toString().trim());

        float juin=0f;
        EditText e7 = findViewById(R.id.juin);
        if(!e7.getText().toString().trim().equals(""))
            juin = Float.parseFloat(e7.getText().toString().trim());

        float juil=0f;
        EditText e8 = findViewById(R.id.juil);
        if(!e8.getText().toString().trim().equals(""))
            juil = Float.parseFloat(e8.getText().toString().trim());

        float aout=0f;
        EditText e9 = findViewById(R.id.aout);
        if(!e9.getText().toString().trim().equals(""))
            aout = Float.parseFloat(e9.getText().toString().trim());

        float sep=0f;
        EditText e10 = findViewById(R.id.sep);
        if(!e10.getText().toString().trim().equals(""))
            sep = Float.parseFloat(e10.getText().toString().trim());

        float oct=0f;
        EditText e11 = findViewById(R.id.oct);
        if(!e11.getText().toString().trim().equals(""))
            oct = Float.parseFloat(e11.getText().toString().trim());

        float nov=0f;
        EditText e12 = findViewById(R.id.nov);
        if(!e12.getText().toString().trim().equals(""))
            nov = Float.parseFloat(e12.getText().toString().trim());

        float dec=0f;
        EditText e13 = findViewById(R.id.dec);
        if(!e13.getText().toString().trim().equals(""))
            dec = Float.parseFloat(e13.getText().toString().trim());

        float inter=0f;

        float solde=0f;
        EditText e14 = findViewById(R.id.solde_input);
        if(!e14.getText().toString().trim().equals(""))
            solde = Float.parseFloat(e14.getText().toString().trim());

        int j=0;
        EditText e15 = findViewById(R.id.jours);
        if(!e15.getText().toString().equals(""))
            j=Integer.parseInt(e15.getText().toString().trim());

        int m=0;
        EditText e16 = findViewById(R.id.mois);
        if(!e16.getText().toString().equals(""))
            m = Integer.parseInt(e16.getText().toString().trim());

        int a=0;
        EditText e17 = findViewById(R.id.annee);
        if(!e17.getText().toString().equals(""))
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
        else {
            j=j+7;
            if(j>30){
                j=j%31+1;
                if(m!=12)
                    m++;
                else{
                    m=1;
                    a++;
                }
            }

            Compte compte = new Compte(id,solde,solde,inter,j,m,a,impot,jan,fev,mars,avr,mai,juin,juil,aout,sep,oct,nov,dec);
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