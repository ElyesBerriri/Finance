package com.example.finance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void epargne(View view) {
        Intent intent = new Intent(this, EpargneActivity.class);
        startActivity(intent);
    }
    public void creer(View view) {
        Intent intent = new Intent(this, NewEpargneActivity.class);
        startActivity(intent);
    }
}