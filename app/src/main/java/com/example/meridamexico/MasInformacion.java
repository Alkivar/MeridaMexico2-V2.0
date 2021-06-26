package com.example.meridamexico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MasInformacion extends AppCompatActivity {

    Informacion informacion;
    ImageView fotos;
    TextView nombrelugar;
    TextView descripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_informacion);

        informacion=(Informacion) getIntent().getSerializableExtra( "DatosMexico");

        fotos=findViewById(R.id.logo1);
        //fotos.setImageResource(informacion.getFotos());

        nombrelugar=findViewById(R.id.nombrepueblo);
        nombrelugar.setText(informacion.getNombreLugar());

        descripcion=findViewById(R.id.descripcion);
        descripcion.setText(informacion.getDescripcion());


    }
}