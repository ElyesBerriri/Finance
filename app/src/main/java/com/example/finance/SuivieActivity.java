package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SuivieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suivie);
        TextView t = findViewById(R.id.choisie);
        t.setText(EpargneActivity.choisie);
    }
}