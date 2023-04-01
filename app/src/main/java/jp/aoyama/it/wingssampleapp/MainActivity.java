package jp.aoyama.it.wingssampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer _player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("12sec");


        _player = new MediaPlayer();
        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.spring_mountain;

        Uri mediaFileUri = Uri.parse(mediaFileUriStr);

        try{
            _player.setDataSource(MainActivity.this, mediaFileUri);

            _player.setOnPreparedListener(new PlayerPreparedListener());

            _player.setOnCompletionListener(new PlayerCompletionListener());

            _player.prepareAsync();

        } catch (IOException e) {
            Log.e("MediaSample", "メディアプレイヤー準備時の例外発生");
        }
    }

    public void onPlayButtonClick(View view){
        Button btPlay = findViewById(R.id.btPlay);

        if(_player.isPlaying()){
            _player.pause();
            btPlay.setText(R.string.bt_play_play);
        }else{
            _player.start();
            btPlay.setText(R.string.bt_play_pause);
        }
    }

    @Override
    protected void onDestroy(){
        if(_player.isPlaying())
            _player.stop();

        _player.release();

        _player = null;

        super.onDestroy();
    }

    private class PlayerPreparedListener implements MediaPlayer.OnPreparedListener{

        @Override
        public void onPrepared(MediaPlayer mp) {
            Button btPlay = findViewById(R.id.btPlay);
            btPlay.setEnabled(true);
            Button btBack = findViewById(R.id.btBack);
            btBack.setEnabled(true);
            Button btForward = findViewById(R.id.btForward);
            btForward.setEnabled(true);
        }
    }

    private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener{

        @Override
        public void onCompletion(MediaPlayer mp) {
            Button btPlay = findViewById(R.id.btPlay);
            btPlay.setText(R.string.bt_play_play);
        }
    }

}
