package com.example.tareacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText password;
    private String usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.edtNombre);
        password=findViewById(R.id.edtPassword);
        usuario="sebastianseyer@hotmail.com";
        contraseña="1234";
    }

    public void onClick (View view)
    {
        String nom, contr;
        nom=name.getText().toString();
        contr=password.getText().toString();
        if(nom.equals(usuario)&&contr.equals(contraseña)){
        Intent Contactos = new Intent(this,Lista.class);
        startActivity(Contactos);
        }else{
           Toast.makeText(this,"Usuario o contraseña incorrectos",Toast.LENGTH_LONG).show();
        }
    }
}
