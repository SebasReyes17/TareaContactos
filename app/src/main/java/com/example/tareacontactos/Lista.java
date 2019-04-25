package com.example.tareacontactos;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Lista extends AppCompatActivity {

    String[] mDatos;
    ListView mListView;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.acercade:
                AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
                mensaje.setTitle("Información");
                mensaje.setMessage(R.string.txt_Acerca_de);
                Dialog dialog = mensaje.create();
                dialog.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        mDatos=getResources().getStringArray(R.array.contactos);
        mListView=findViewById(R.id.lista);
        ArrayAdapter<String> adaptadorLista =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mDatos);
        mListView.setAdapter(adaptadorLista);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String telefono, aux;
               aux=mDatos[position];
               int n=aux.length();
               telefono=aux.substring(n-11,n);
             if (ActivityCompat.checkSelfPermission(view.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
               {
                   return;
               }
               startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono)));
           }
       });
    }



}