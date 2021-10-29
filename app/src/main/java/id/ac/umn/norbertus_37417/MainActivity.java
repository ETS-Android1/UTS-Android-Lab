package id.ac.umn.norbertus_37417;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import id.ac.umn.norbertus_37417.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.btnProfile.setOnClickListener(v -> {
            Intent goToProfile = new Intent(this , ProfileActivity.class);
            goToProfile.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            this.startActivity(goToProfile);

        });

        bind.btnLibrary.setOnClickListener(v -> {
            Intent goToAuth = new Intent(this, AuthActivity.class);
            startActivity(goToAuth);
        });
    }

}
