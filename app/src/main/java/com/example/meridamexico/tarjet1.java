package com.example.meridamexico;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class tarjet1 extends AppCompatActivity {

    ArrayList<Informacion> listadeDatos1= new ArrayList<>();
    RecyclerView listadoGrafico;
    FirebaseFirestore baseDatos=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarjet1);

        listadoGrafico=findViewById(R.id.listado);
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        crearlista();

    }


    public void cambiarIdioma(String lenguaje){

        Locale idioma=new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration  configuraciontelefono=getResources().getConfiguration();
        configuraciontelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuraciontelefono,getBaseContext().getResources().getDisplayMetrics());

    }



    public boolean onCreateOptionsMenu (Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();

        switch (id){

            case(R.id.opcion1):

                Intent intent1= new Intent(tarjet1.this,Acercade.class);
                startActivity(intent1);

                break;

            case(R.id.opcion2):

                cambiarIdioma("en");
                Intent intent2= new Intent(tarjet1.this,tarjet1.class);
                startActivity(intent2);

                break;

            case(R.id.opcion3):

                cambiarIdioma("es");
                Intent intent3= new Intent(tarjet1.this,tarjet1.class);
                startActivity(intent3);

                break;

        }

        return super.onOptionsItemSelected(item);

    }

    private void crearlista(){

        baseDatos.collection("Meridaa")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String NombreLugar=document.get("NombreLugar").toString();
                                String descripcion=document.get("descripcion").toString();
                                String foto=document.get("foto").toString();

                                listadeDatos1.add(new Informacion(NombreLugar,descripcion,foto));

                            }

                            ListaAdaptador adaptador=new ListaAdaptador(listadeDatos1);
                            listadoGrafico.setAdapter(adaptador);


                    }else{

                        }
                    }
                });

    }

}