package com.example.segundaactivdad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

     EditText nom,tel,corr,des;
     DatePicker cal;
     Button sig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=(EditText)findViewById(R.id.Nombre1);
        tel=(EditText)findViewById(R.id.Telefono1);
        corr=(EditText)findViewById(R.id.Correo1);
        des=(EditText)findViewById(R.id.Descripcion1);
        cal= (DatePicker) findViewById(R.id.dpEd);
        sig= (Button) findViewById(R.id.Siguiente);
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nom.getText().toString();
                String tele= tel.getText().toString();
                String corre= corr.getText().toString();
                String desc = des.getText().toString();
                int dia =cal.getDayOfMonth();
                int mes = cal.getMonth();
                int año = cal.getYear();
                Intent i=new Intent(MainActivity.this,MostrarDatos.class);
                i.putExtra("name",name);
                i.putExtra("tele",tele);
                i.putExtra("corre",corre);
                i.putExtra("desc",desc);
                i.putExtra("dia", dia);
                i.putExtra("mes", mes);
                i.putExtra("año", año);
                startActivity(i);
            }
        });
    }
    protected void onResume() {
        super.onResume();
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            String nombre = datos.getString(getResources().getString(R.string.Nombretxt));
            String telefono = datos.getString(getResources().getString(R.string.Telefonotxt));
            String correo = datos.getString(getResources().getString(R.string.Correotxt));
            String descripcion = datos.getString(getResources().getString(R.string.Descripciontxt));
            int idia = Integer.parseInt(String.valueOf(datos.getInt("dia")));
            int imes = Integer.parseInt(String.valueOf(datos.getInt("mes")));
            int iaño = Integer.parseInt(String.valueOf(datos.getInt("año")));
            EditText txtNom=(EditText)findViewById(R.id.Nombre1);
            EditText txtTel=(EditText)findViewById(R.id.Telefono1);
            EditText txtCor=(EditText)findViewById(R.id.Correo1);
            EditText txtDes=(EditText)findViewById(R.id.Descripcion1);
            DatePicker cal=(DatePicker)findViewById(R.id.dpEd);
            txtNom.setText(nombre);
            txtTel.setText(telefono);
            txtCor.setText(correo);
            txtDes.setText(descripcion);
            cal.updateDate(iaño, imes, idia);
        }

    }
}