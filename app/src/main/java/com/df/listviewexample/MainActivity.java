package com.df.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.df.listviewexample.models.Carro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvLista;
    private ArrayList<Carro> listaCarros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        listaCarros = bundle.getParcelableArrayList("listaCarros");
        lvLista = findViewById(R.id.lvLista);
        AdapterCar adapterCar = new AdapterCar(this, listaCarros);
        lvLista.setAdapter(adapterCar);
        lvLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Has seleccionado " + listaCarros.get(position).getNombre(), Toast.LENGTH_LONG).show();
    }
}