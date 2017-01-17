package com.fdanesse.cardsviews;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.fdanesse.cardsviews.acercade.AcercadeActivity;
import com.fdanesse.cardsviews.contacto.ContactoActivity;
import com.fdanesse.cardsviews.detalle.DetalleActivity;
import com.fdanesse.cardsviews.mimascota.FragmentMiMascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar maintoolbar;
    private FragmentMain fragmentMain;
    private FragmentMiMascota fragmentMiMascota;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintoolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(maintoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);

        tabLayout = (TabLayout) findViewById(R.id.lenguetas);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragmentMain = new FragmentMain();
        fragmentMiMascota = new FragmentMiMascota();
        fragments.add(fragmentMain);
        fragments.add(fragmentMiMascota);

        viewPager.setAdapter(new NoteBook(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.pata);

        FloatingActionButton camara = (FloatingActionButton) findViewById(R.id.Camara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Ejercicio Mascotas",
                        Snackbar.LENGTH_LONG).setAction("Accion", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.actionstar:
                intent = new Intent(MainActivity.this, DetalleActivity.class);
                startActivity(intent);
                break;
            case R.id.Contacto:
                intent = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent);
                break;
            case R.id.AcercaDe:
                intent = new Intent(MainActivity.this, AcercadeActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }
}
