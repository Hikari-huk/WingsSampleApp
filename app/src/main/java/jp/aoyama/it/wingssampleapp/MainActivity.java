package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);

        setSupportActionBar(toolbar);

        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.toolbarLayout);

        toolbarLayout.setTitle(getString(R.string.toolbar_title));

        toolbarLayout.setExpandedTitleColor(Color.WHITE);

        toolbarLayout.setCollapsedTitleTextColor(Color.LTGRAY);

        RecyclerView lvMenu = findViewById(R.id.lvMenu);

        LinearLayoutManager layout = new LinearLayoutManager(MainActivity.this);

        lvMenu.setLayoutManager(layout);

        List<Map<String, Object>> menuList = createTeishokuList();

        RecyclerListAdapter adapter = new RecyclerListAdapter(menuList);

        lvMenu.setAdapter(adapter);

    }

    private List<Map<String, Object>> createTeishokuList() {
        // 定食メニューリスト用のListオブジェクトを用意。
        List<Map<String, Object>> menuList = new ArrayList<>();

        // 「から揚げ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "から揚げ定食");
        menu.put("price", 800);
        menu.put("desc", "若鳥のから揚げにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        // 「ハンバーグ定食」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録。
        menu = new HashMap<>();
        menu.put("name", "ハンバーグ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねハンバーグにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        // 以下データ登録の繰り返し。
        menu = new HashMap<>();
        menu.put("name", "生姜焼き定食");
        menu.put("price", 850);
        menu.put("desc", "すりおろし生姜を使った生姜焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ステーキ定食");
        menu.put("price", 1000);
        menu.put("desc", "国産牛のステーキにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "野菜炒め定食");
        menu.put("price", 750);
        menu.put("desc", "季節の野菜炒めにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "とんかつ定食");
        menu.put("price", 900);
        menu.put("desc", "ロースとんかつにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "ミンチかつ定食");
        menu.put("price", 850);
        menu.put("desc", "手ごねミンチカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "チキンカツ定食");
        menu.put("price", 900);
        menu.put("desc", "ボリュームたっぷりチキンカツにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "コロッケ定食");
        menu.put("price", 850);
        menu.put("desc", "北海道ポテトコロッケにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "回鍋肉定食");
        menu.put("price", 750);
        menu.put("desc", "ピリ辛回鍋肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "麻婆豆腐定食");
        menu.put("price", 800);
        menu.put("desc", "本格四川風麻婆豆腐にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "青椒肉絲定食");
        menu.put("price", 900);
        menu.put("desc", "ピーマンの香り豊かな青椒肉絲にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼き魚定食");
        menu.put("price", 850);
        menu.put("desc", "鰆の塩焼きにサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name", "焼肉定食");
        menu.put("price", 950);
        menu.put("desc", "特性たれの焼肉にサラダ、ご飯とお味噌汁が付きます。");
        menuList.add(menu);

        return menuList;
    }

    private class RecyclerListViewHolder extends RecyclerView.ViewHolder {
        public TextView _tvMenuNameRow;
        public TextView _tvMenuPriceRow;

        public RecyclerListViewHolder(View itemView){
            super(itemView);
            _tvMenuNameRow = itemView.findViewById(R.id.tvMenuNameRow);
            _tvMenuPriceRow = itemView.findViewById(R.id.tvMenuPriceRow);
        }
    }

    private class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListViewHolder>{
        private List<Map<String, Object>> _listData;

        public RecyclerListAdapter(List<Map<String, Object>> listData){
            _listData = listData;
        }

        @Override
        public RecyclerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.row, parent, false);

            RecyclerListViewHolder holder = new RecyclerListViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerListViewHolder holder, int position){
            Map<String, Object> item = _listData.get(position);

            String menuName = (String) item.get("name");

            int menuPrice = (Integer) item.get("price");

            String menuPriceStr = String.valueOf(menuPrice);

            holder._tvMenuNameRow.setText(menuName);
            holder._tvMenuPriceRow.setText(menuPriceStr);
        }

        @Override
        public int getItemCount(){
            return _listData.size();
        }
    }


}

