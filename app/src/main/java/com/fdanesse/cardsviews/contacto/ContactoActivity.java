package com.fdanesse.cardsviews.contacto;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fdanesse.cardsviews.R;

public class ContactoActivity extends AppCompatActivity {

    private Toolbar mitoolbar;
    private EditText nombre;
    private EditText correo;
    private EditText password;
    private EditText comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        mitoolbar = (Toolbar) findViewById(R.id.generic_toolbar);
        setSupportActionBar(mitoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);

        nombre = (EditText) findViewById(R.id.nombre);
        correo = (EditText) findViewById(R.id.correo);
        password = (EditText) findViewById(R.id.password);
        comentario = (EditText) findViewById(R.id.comentario);

        Button enviar = (Button) findViewById(R.id.enviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(comentario, "Mensaje Enviado.", Snackbar.LENGTH_INDEFINITE).show();
            }
        });
    }
}
