package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        boolean fromNotification = intent.getBooleanExtra("fromNotification", false);

        if(fromNotification){
            Button btPlay = findViewById(R.id.btPlay);
            Button btStop = findViewById(R.id.btStop);

            btPlay.setEnabled(false);
            btStop.setEnabled(true);
        }

    }

    public void onPlayButtonClick(View view){
        Intent intent = new Intent(MainActivity.this, SoundManageService.class);

        startService(intent);

        Button btPlay = findViewById(R.id.btPlay);
        Button btStop = findViewById(R.id.btStop);

        btPlay.setEnabled(false);
        btStop.setEnabled(true);
    }

    public void onStopButtonClick(View view){
        Intent intent = new Intent(MainActivity.this, SoundManageService.class);

        stopService(intent);

        Button btPlay = findViewById(R.id.btPlay);
        Button btStop = findViewById(R.id.btStop);
        btPlay.setEnabled(true);
        btStop.setEnabled(false);
    }
}

