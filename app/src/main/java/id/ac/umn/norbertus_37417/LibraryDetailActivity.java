package id.ac.umn.norbertus_37417;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import java.util.Objects;

import id.ac.umn.norbertus_37417.databinding.ActivityLibraryDetailBinding;

public class LibraryDetailActivity extends AppCompatActivity {

    ActivityLibraryDetailBinding bind;
    MediaPlayer media;
    Library item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityLibraryDetailBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        item = getIntent().getExtras().getParcelable("library");

        Objects.requireNonNull(getSupportActionBar()).setTitle(item.getTitle());

        bind.detailTitle.setText(item.getTitle());
        bind.detailType.setText(item.getType());
        media = new MediaPlayer();
        bind.btnDetailPlaySfx.setOnClickListener( v -> {
            media = MediaPlayer.create(
                    this,
                    this.getResources().getIdentifier(
                            item.getSoundURI(),
                            "raw",
                            this.getPackageName()));
            media.start();
        });
    }

    @Override
    protected void onStart() {
        Log.d("heroism", "Start");
        super.onStart();

    }

    @Override
    protected void onResume() {
        Log.d("heroism", "Resume");
        super.onResume();

    }

    @Override
    protected void onPause() {
        Log.d("heroism", "Start");
        super.onPause();

    }

    @Override
    protected void onStop() {
        Log.d("heroism", "Stop");
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        Log.d("heroism", "Destroy");
        super.onDestroy();
        if(media.isPlaying()){
            media.release();
            media.release();
            media = null;
            Log.d("heroism", "Music Stop");
        }
    }
}