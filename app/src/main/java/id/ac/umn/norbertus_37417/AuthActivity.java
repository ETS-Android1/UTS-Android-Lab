package id.ac.umn.norbertus_37417;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import id.ac.umn.norbertus_37417.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity {

    private ActivityAuthBinding bind;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.btnGoToLibrary.setOnClickListener(v -> {
            username = bind.etUsername.getText().toString();
            if(username.isEmpty())
                bind.etUsername.setError("Harap Di-isi");

            else{
                Intent goToLibrary = new Intent(this, LibraryActivity.class);
                goToLibrary.putExtra("username", bind.etUsername.getText().toString());
                startActivity(goToLibrary);
                finish();
            }
        });
    }
}
