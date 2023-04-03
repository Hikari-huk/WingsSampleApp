package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("14sec");
        System.out.println("13sec");
        System.out.println("12sec");
        System.out.println("11sec");
        System.out.println("10sec");
        System.out.println("5sec");
        System.out.println("7sec");

    }

}

