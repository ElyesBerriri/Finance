package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NewEpargneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_epargne);
    }

    public void enregistrer(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}