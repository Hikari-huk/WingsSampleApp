package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setTitle(R.string.toolbar_title);

        toolbar.setTitleTextColor(Color.WHITE);

        toolbar.setSubtitle(R.string.toolbar_subtitle);

        toolbar.setSubtitleTextColor(Color.LTGRAY);

        setSupportActionBar(toolbar);

    }

}

