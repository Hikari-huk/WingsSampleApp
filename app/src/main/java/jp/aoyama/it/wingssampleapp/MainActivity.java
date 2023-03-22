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

    /**
     * リストがタップされたときの処理が記述されたメンバクラス。
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            // タップされた定食名を取得。
//            String item = (String) parent.getItemAtPosition(position);
//            // トーストで表示する文字列を生成。
//            String show = "あなたが選んだ定食: " + item;
//            // トーストの表示。
//            Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();
            // 注文確認ダイアログフラグメントオブジェクトを生成。
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            // ダイアログ表示。
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }

        System.out.println("5章");
        System.out.println("7章");

    }

}

