package com.example.finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
                float s = compte.getSolde2();
                solde.setText(s+" DT");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    public void obtenir_solde(View view) {
        reference = FirebaseDatabase.getInstance().getReference("comptes");
        TextView soldeText = findViewById(R.id.soldePrev);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot dataSnapshot = snapshot.child(id);
                Compte compte = dataSnapshot.getValue(Compte.class);

                int ja=0;
                EditText e15 = findViewById(R.id.jours_suivie);
                if(!e15.getText().toString().equals(""))
                    ja=Integer.parseInt(e15.getText().toString().trim());

                int ma=0;
                EditText e16 = findViewById(R.id.mois_suivie);
                if(!e16.getText().toString().equals(""))
                    ma = Integer.parseInt(e16.getText().toString().trim());

                int aa=0;
                EditText e17 = findViewById(R.id.annee_suivie);
                if(!e17.getText().toString().equals(""))
                    aa = Integer.parseInt(e17.getText().toString().trim());

                int j=compte.getJour();
                int m=compte.getMois();
                int a=compte.getAnnee();
                float solde=compte.getSolde();
                float solde2=compte.getSolde2();
                float inter=compte.getInteret();
                float impot=compte.getTaux_impot();
                float jan= compte.getTaux_jan();
                float fev= compte.getTaux_fev();
                float mars= compte.getTaux_mars();
                float avr= compte.getTaux_avr();
                float mai= compte.getTaux_mai();
                float juin= compte.getTaux_jun();
                float juil= compte.getTaux_juil();
                float aout= compte.getTaux_aout();
                float sept= compte.getTaux_sep();
                float oct= compte.getTaux_oct();
                float nov= compte.getTaux_nov();
                float dec= compte.getTaux_dec();
                float[] tab = new float[2];

                for(int i=a;i<=aa;i++){
                    if(i==a && i==aa){
                        int d;
                        for(int l=m;l<=ma;l++){
                            if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                d=31;
                            else if(l==2)
                                d=28;
                            else
                                d=30;

                            if(l==m && l==ma){
                                for(int k=j;k<=ja;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                            else if(l==m){
                                for(int k=j;k<=d;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                            else if(l==ma){
                                for(int k=1;k<=ja;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                            else{
                                for(int k=1;k<=d;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                        }
                    }
                    else if(i==a){
                        int d;
                        for(int l=m;l<=12;l++){
                            if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                d=31;
                            else if(l==2)
                                d=28;
                            else
                                d=30;

                            if(l==m){
                                for(int k=j;k<=d;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                            else{
                                for(int k=1;k<=d;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                        }
                    }
                    else if(i==aa){
                        int d;
                        for(int l=1;l<=ma;l++){
                            if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                d=31;
                            else if(l==2)
                                d=28;
                            else
                                d=30;

                            if(l==ma){
                                for(int k=1;k<=ja;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                            else{
                                for(int k=1;k<=d;k++){
                                    tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                    solde=tab[0];
                                    inter=tab[1];
                                }
                            }
                        }
                    }
                    else{
                        int d;
                        for(int l=1;l<=12;l++) {
                            if (l == 1 || l == 3 || l == 5 || l == 7 || l == 8 || l == 10 || l == 12)
                                d = 31;
                            else if (l == 2)
                                d = 28;
                            else
                                d = 30;

                            for (int k = 1; k <= d; k++) {
                                tab = traitement(l, k, solde, inter, impot, jan, fev, mars, avr, mai, juin, juil, aout, sept, oct, nov, dec);
                                solde = tab[0];
                                inter = tab[1];
                            }
                        }
                    }
                }

                solde2=solde-compte.getSolde()+compte.getSolde2();
                compte.setSolde(solde);
                compte.setSolde2(solde2);
                compte.setInteret(inter);
                if(aa>a || (aa==a && ma<m) || (aa==a && ma==m && ja<j))
                    soldeText.setText(solde+" DT");
                else
                    soldeText.setText(solde2+" DT");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}

        });
    }

    public void operation(View view){
        reference = FirebaseDatabase.getInstance().getReference("comptes");
        TextView soldeText = findViewById(R.id.solde);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataSnapshot dataSnapshot = snapshot.child(id);
                Compte compte = dataSnapshot.getValue(Compte.class);

                CheckBox ret = findViewById(R.id.retrait);
                CheckBox ver = findViewById(R.id.versement);

                float montant = 0f;
                EditText e14 = findViewById(R.id.montant);
                if (!e14.getText().toString().equals(""))
                    montant = Float.parseFloat(e14.getText().toString().trim());

                int jo = 0;
                EditText e15 = findViewById(R.id.jours_op);
                if (!e15.getText().toString().equals(""))
                    jo = Integer.parseInt(e15.getText().toString().trim());

                int mo = 0;
                EditText e16 = findViewById(R.id.mois_op);
                if (!e16.getText().toString().equals(""))
                    mo = Integer.parseInt(e16.getText().toString().trim());

                int ao = 0;
                EditText e17 = findViewById(R.id.annee_op);
                if (!e17.getText().toString().equals(""))
                    ao = Integer.parseInt(e17.getText().toString().trim());

                int j = compte.getJour();
                int m = compte.getMois();
                int a = compte.getAnnee();
                float solde = compte.getSolde();
                float solde2 = compte.getSolde2();
                float inter=compte.getInteret();
                float impot=compte.getTaux_impot();
                float jan= compte.getTaux_jan();
                float fev= compte.getTaux_fev();
                float mars= compte.getTaux_mars();
                float avr= compte.getTaux_avr();
                float mai= compte.getTaux_mai();
                float juin= compte.getTaux_jun();
                float juil= compte.getTaux_juil();
                float aout= compte.getTaux_aout();
                float sept= compte.getTaux_sep();
                float oct= compte.getTaux_oct();
                float nov= compte.getTaux_nov();
                float dec= compte.getTaux_dec();
                float[] tab;
                int js=jo,ms=mo,as=ao;

                if(ver.isChecked() && !ret.isChecked()){
                    jo=jo+7;
                    if(mo==1&&jo>31 || mo==3&&jo>31 || mo==5&&jo>31 || mo==7&&jo>31 || mo==8&&jo>31 || mo==10&&jo>31){
                        jo=jo%32+1;
                        mo++;
                    }
                    else if(mo==12&&jo>31){
                        jo=jo%32+1;
                        mo=1;
                        ao++;
                    }
                    else if(mo==2&&jo>28){
                        jo=jo%28+1;
                        mo++;
                    }
                    else if(mo==4&&jo>30 || mo==6&&jo>30 || mo==9&&jo>30 || mo==11&&jo>30){
                        jo=jo%31+1;
                        mo++;
                    }
                    while(ferier(jo,mo)){
                        jo=jo+1;
                        if(mo==1&&jo>31 || mo==3&&jo>31 || mo==5&&jo>31 || mo==7&&jo>31 || mo==8&&jo>31 || mo==10&&jo>31){
                            jo=jo%32+1;
                            mo++;
                        }
                        else if(mo==12&&jo>31){
                            jo=jo%32+1;
                            mo=1;
                            ao++;
                        }
                        else if(mo==2&&jo>28){
                            jo=jo%28+1;
                            mo++;
                        }
                        else if(mo==4&&jo>30 || mo==6&&jo>30 || mo==9&&jo>30 || mo==11&&jo>30){
                            jo=jo%31+1;
                            mo++;
                        }
                    }

                    for(int i=a;i<=ao;i++){
                        if(i==a && i==ao){
                            int d;
                            for(int l=m;l<=mo;l++){
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                if(l==m && l==mo){
                                    for(int k=j;k<jo;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                                else if(l==m){
                                    for(int k=j;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                                else if(l==mo){
                                    for(int k=1;k<jo;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                                else{
                                    for(int k=1;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                            }
                        }
                        else if(i==a){
                            int d;
                            for(int l=m;l<=12;l++){
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                if(l==m){
                                    for(int k=j;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                                else{
                                    for(int k=1;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                            }
                        }
                        else if(i==ao){
                            int d;
                            for(int l=1;l<=mo;l++){
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                if(l==mo){
                                    for(int k=1;k<jo;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                                else{
                                    for(int k=1;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde2=solde;
                                    }
                                }
                            }
                        }
                        else{
                            int d;
                            for(int l=1;l<=12;l++) {
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                for (int k = 1; k <= d; k++) {
                                    tab = traitement(l, k, solde, inter, impot, jan, fev, mars, avr, mai, juin, juil, aout, sept, oct, nov, dec);
                                    solde = tab[0];
                                    inter = tab[1];
                                    if (k == js && l == ms && i == as)
                                        solde2 = solde;
                                }
                            }
                        }
                    }
                    solde+=montant;
                    solde2+=montant;
                    compte.setSolde2(solde2);
                    compte.setSolde(solde);
                    compte.setInteret(inter);
                    compte.setJour(jo);
                    compte.setMois(mo);
                    compte.setAnnee(ao);
                    soldeText.setText(solde2+" DT");
                    reference.child(id).setValue(compte);
                }
                else if(ret.isChecked() && !ver.isChecked()){
                    js=js-7;
                    if(js<1){
                        if(ms==1){
                            js+=31;
                            ms=12;
                            as--;
                        }
                        else if(ms==2 || ms==4 || ms==6 || ms==9 || ms==11){
                            js+=31;
                            ms--;
                        }
                        else if(ms==3){
                            js+=28;
                            ms=2;
                        }
                        else{
                            js+=30;
                            ms--;
                        }
                    }
                    while(ferier(js,ms)){
                        js=js-1;
                        if(js<1){
                            if(ms==1){
                                js+=31;
                                ms=12;
                                as--;
                            }
                            else if(ms==2 || ms==4 || ms==6 || ms==9 || ms==11){
                                js+=31;
                                ms--;
                            }
                            else if(ms==3){
                                js+=28;
                                ms=2;
                            }
                            else{
                                js+=30;
                                ms--;
                            }
                        }
                    }
                    for(int i=a;i<=ao;i++){
                        if(i==a && i==ao){
                            int d;
                            for(int l=m;l<=mo;l++){
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                if(l==m && l==mo){
                                    for(int k=j;k<jo;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                                else if(l==m){
                                    for(int k=j;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                                else if(l==mo){
                                    for(int k=1;k<jo;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                                else{
                                    for(int k=1;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                            }
                        }
                        else if(i==a){
                            int d;
                            for(int l=m;l<=12;l++){
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                if(l==m){
                                    for(int k=j;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                                else{
                                    for(int k=1;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                            }
                        }
                        else if(i==ao){
                            int d;
                            for(int l=1;l<=mo;l++){
                                if(l==1||l==3||l==5||l==7||l==8||l==10||l==12)
                                    d=31;
                                else if(l==2)
                                    d=28;
                                else
                                    d=30;

                                if(l==mo){
                                    for(int k=1;k<jo;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                                else{
                                    for(int k=1;k<=d;k++){
                                        tab=traitement(l,k,solde,inter,impot,jan,fev,mars,avr,mai,juin,juil,aout,sept,oct,nov,dec);
                                        solde=tab[0];
                                        inter=tab[1];
                                        if(k==js && l==ms && i==as)
                                            solde-=montant;
                                    }
                                }
                            }
                        }
                        else{
                            int d;
                            for(int l=1;l<=12;l++) {
                                if (l == 1 || l == 3 || l == 5 || l == 7 || l == 8 || l == 10 || l == 12)
                                    d = 31;
                                else if (l == 2)
                                    d = 28;
                                else
                                    d = 30;

                                for (int k = 1; k <= d; k++) {
                                    tab = traitement(l, k, solde, inter, impot, jan, fev, mars, avr, mai, juin, juil, aout, sept, oct, nov, dec);
                                    solde = tab[0];
                                    inter = tab[1];
                                    if (k == js && l == ms && i == as)
                                        solde -= montant;
                                }
                            }
                        }
                    }

                    solde2=solde;
                    compte.setSolde2(solde2);
                    compte.setSolde(solde);
                    compte.setInteret(inter);
                    compte.setJour(jo);
                    compte.setMois(mo);
                    compte.setAnnee(ao);
                    soldeText.setText(solde2+" DT");
                    reference.child(id).setValue(compte);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });
    }

    public boolean ferier(int j,int m){
        return  (j == 1 && m == 1) || (j == 20 && m == 3) || (j == 9 && m == 4) || (j == 1 && m == 5) ||
                (j == 25 && m == 7) || (j == 13 && m == 8) || (j == 15 && m == 10) || (j == 17 && m == 12);
    }

    public float[] traitement(int l,int k,float solde,float inter,float impot,float jan,float fev,float mars
            ,float avr,float mai,float juin,float juil,float aout,float sept,float oct,float nov,float dec){

        float[] tab = new float[2];
        if(l==1){
            if(k==1) {
                solde += inter * (100 - impot)/100;
                inter=0;
            }
            if(!ferier(k,l))
                inter+=jan*solde/36000;
        }
        if(l==2){
            if(!ferier(k,l))
                inter+=fev*solde/36000;
        }
        if(l==3){
            if(!ferier(k,l))
                inter+=mars*solde/36000;
        }
        if(l==4){
            if(k==1) {
                solde += inter * (100 - impot)/100;
                inter=0;
            }
            if(!ferier(k,l))
                inter+=avr*solde/36000;
        }
        if(l==5){
            if(!ferier(k,l))
                inter+=mai*solde/36000;
        }
        if(l==6){
            if(!ferier(k,l))
                inter+=juin*solde/36000;
        }
        if(l==7){
            if(k==1) {
                solde += inter * (100 - impot)/100;
                inter=0;
            }
            if(!ferier(k,l))
                inter+=juil*solde/36000;
        }
        if(l==8){
            if(!ferier(k,l))
                inter+=aout*solde/36000;
        }
        if(l==9){
            if(!ferier(k,l))
                inter+=sept*solde/36000;
        }
        if(l==10){
            if(k==1) {
                solde += inter * (100 - impot)/100;
                inter=0;
            }
            if(!ferier(k,l))
                inter+=oct*solde/36000;
        }
        if(l==11){
            if(!ferier(k,l))
                inter+=nov*solde/36000;
        }
        if(l==12){
            if(!ferier(k,l))
                inter+=dec*solde/36000;
        }
        tab[0]=solde;
        tab[1]=inter;
        return tab;
    }

    public void stopRet(View view){
        CheckBox c = findViewById(R.id.retrait);
        c.setChecked(false);
    }

    public void stopVers(View view){
        CheckBox c = findViewById(R.id.versement);
        c.setChecked(false);
    }
}