package com.fdanesse.cardsviews.contacto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fdanesse.cardsviews.R;

public class ContactoActivity extends AppCompatActivity {

    private Toolbar mitoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        mitoolbar = (Toolbar) findViewById(R.id.mitoolbar);
        setSupportActionBar(mitoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
    }
}
