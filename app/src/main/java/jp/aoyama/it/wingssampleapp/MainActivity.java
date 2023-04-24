package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);

        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbarLayout);

        toolbarLayout.setTitle(getString(R.string.toolbar_title));

        toolbarLayout.setExpandedTitleColor(Color.WHITE);

        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY);

    }

}

