package jp.aoyama.it.wingssampleapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SoundManageService extends Service {

    private MediaPlayer _player;

    @Override
    public void onCreate(){
        _player = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        String mediaFileUriStr = "android.resource://" + getPackageName() + "/" + R.raw.sound_city;

        Uri mediaFileUri = Uri.parse(mediaFileUriStr);

        try{
            _player.setDataSource(SoundManageService.this, mediaFileUri);

            _player.setOnPreparedListener(new PlayerPreparedListener());

            _player.setOnCompletionListener(new PlayerCompletionListener());

            _player.prepareAsync();

        } catch (IOException e) {
            Log.e("ServiceSample", "メディアプレーヤー準備時の例外発生");
        }

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy(){
        if(_player.isPlaying()){
            _player.stop();
        }
        _player.release();
        _player = null;

    }


    private class PlayerPreparedListener implements  MediaPlayer.OnPreparedListener{

        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.start();
        }
    }

    private class PlayerCompletionListener implements MediaPlayer.OnCompletionListener{

        @Override
        public void onCompletion(MediaPlayer mp) {
            stopSelf();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}