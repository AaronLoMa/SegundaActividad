package com.example.segundaactivdad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MostrarDatos extends AppCompatActivity {
TextView Nombre2;
    TextView Telefono2;
    TextView Correo2;
    TextView Descripcion2;
    TextView Cal2;

Button Editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        Nombre2=(TextView)findViewById(R.id.Nombre2);
        Telefono2=(TextView)findViewById(R.id.Telefono2);
        Correo2=(TextView)findViewById(R.id.Correo2);
        Descripcion2=(TextView)findViewById(R.id.Descripcion2);
        Cal2=(TextView)findViewById(R.id.Cal2);
        Editar=(Button)findViewById(R.id.Editar);
        Editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MostrarDatos.this,MainActivity.class);
                Bundle para=getIntent().getExtras();
                 String Nombre1=Nombre2.getText().toString();
                String Nombre2=Telefono2.getText().toString();
                String Nombre3=Correo2.getText().toString();
                String Nombre4=Descripcion2.getText().toString();
                int dia =para.getInt("dia");
                int mes = para.getInt("mes");
                int año = para.getInt("año");
                i.putExtra(getResources().getString(R.string.Nombretxt),Nombre1);
                i.putExtra(getResources().getString(R.string.Telefonotxt),Nombre2);
                i.putExtra(getResources().getString(R.string.Correotxt),Nombre3);
                i.putExtra(getResources().getString(R.string.Descripciontxt),Nombre4);
                i.putExtra("dia", dia);
                i.putExtra("mes", mes);
                i.putExtra("año", año);
                startActivity(i);
            }
        });
        mostrarDato();
    }

    private void mostrarDato() {
        Bundle datos=this.getIntent().getExtras();
        String nombre = datos.getString("name");
        String telefono=datos.getString("tele");
        String correo=datos.getString("corre");
        String descripcion=datos.getString("desc");
        int dia = (datos.getInt("dia"));
        int mes =(datos.getInt("mes"));
        int año = (datos.getInt("año"));
        Nombre2.setText(nombre);
        Telefono2.setText(telefono);
        Correo2.setText(correo);
        Descripcion2.setText(descripcion);
        Cal2.setText(dia +"/"+ (mes+1)+"/"+ año);

}
}