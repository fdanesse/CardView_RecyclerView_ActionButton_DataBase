package com.fdanesse.cardsviews.acercade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.fdanesse.cardsviews.R;
import com.mikhaellopez.circularimageview.CircularImageView;

public class AcercadeActivity extends AppCompatActivity {

    private Toolbar mitoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        mitoolbar = (Toolbar) findViewById(R.id.generic_toolbar);
        setSupportActionBar(mitoolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayUseLogoEnabled(false);

        CircularImageView circularImageView = (CircularImageView)findViewById(R.id.foto);
        // https://github.com/lopspower/CircularImageView
    }
}
