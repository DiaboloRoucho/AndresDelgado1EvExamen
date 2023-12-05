package com.example.andresdelgado1evexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//pausa verde letra 15dp
//play azul letra 20
//record naranja 15
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void cronometro(View v){

        Intent i = new Intent(this, Cronometro.class);
        startActivity(i);
        finish();
    }
}