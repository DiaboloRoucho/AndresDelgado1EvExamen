package com.example.andresdelgado1evexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cronometro extends AppCompatActivity {

    TextView contador;
    RecyclerView rv;
    List<Objeto> l;
    BigInteger suma, inc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);
        contador = findViewById(R.id.textView);
        suma = new BigInteger("0");
        inc = new BigInteger("0");
        createRV();
        inc();
    }
    public void play(View v){
        if (inc.toString().compareTo("0")==0)
        inc = inc.add(new BigInteger("1"));
    }

    public void inc(){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(()->{

            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                suma = suma.add(inc);
                handler.post(()->{
                contador.setText(suma.toString());
                });
            }
        });
    }
    public void pausar(View v){
        if (inc.toString().compareTo("1")==0)
            inc = inc.subtract(new BigInteger("1"));
    }
    public void record(View v){
        l.add(new Objeto(contador.toString(), "segundos"));
        rv.setAdapter(new RecyclerViewAdapter(l));
    }
    public void createRV(){
        rv = (RecyclerView) findViewById(R.id.rvMain);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        l = Arrays.asList(new Objeto("5", "segundos"));
        rv.setAdapter(new RecyclerViewAdapter(l));
    }

}