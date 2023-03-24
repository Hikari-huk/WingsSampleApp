package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int _cocktailId = -1;

    private String _cocktailName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCocktail = findViewById(R.id.lvCocktail);
        lvCocktail.setOnItemClickListener(new ListItemClickListener());
    }

    public void onSaveButtonClick(View view){
        EditText etNote = findViewById(R.id.etNote);

        etNote.setText("");

        TextView tvCocktailName = findViewById(R.id.tvCocktailName);
        tvCocktailName.setText(getString(R.string.tv_name));

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setEnabled(false);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            _cocktailId = position;
            _cocktailName = (String)parent.getItemAtPosition(position);

            TextView tvCocktailName = findViewById(R.id.tvCocktailName);
            tvCocktailName.setText(_cocktailName);
            Button btnSave = findViewById(R.id.btnSave);
            btnSave.setEnabled(true);
        }
    }
}