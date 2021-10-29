package id.ac.umn.norbertus_37417;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.LinkedList;
import java.util.Objects;

import id.ac.umn.norbertus_37417.databinding.ActivityLibraryBinding;

public class LibraryActivity extends AppCompatActivity {

    ActivityLibraryBinding bind;
    String toolbar;
    static String username;
    AdapterLibrary adapter;
    static LinkedList<Library> listLibrary;
    LibraryItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityLibraryBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        toolbar = getIntent().getStringExtra("username");
        if(toolbar !=null){
            storeData();
            username = toolbar;
            Objects.requireNonNull(getSupportActionBar()).setTitle(username);
            Toast.makeText(this,"Welcome, "+ toolbar,Toast.LENGTH_SHORT).show();
        }
        else
            Objects.requireNonNull(getSupportActionBar()).setTitle(username);

        setOnListener();

        adapter = new AdapterLibrary(this, listLibrary, listener);
        bind.rvListLibrary.setAdapter(adapter);
        bind.rvListLibrary.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_profile) {
            Intent goToProfile = new Intent(this , ProfileActivity.class);
            goToProfile.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            this.startActivity(goToProfile);
            return true;
        }
        else if(item.getItemId() == R.id.menu_home){
            this.finish();
            Intent goToHome = new Intent(this, MainActivity.class);
            // Clear all new Activity and set MainActivity as start Activity
            // https://devdeeds.com/clear-backstack-of-activities/
            goToHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(goToHome);
        }
        return super.onOptionsItemSelected(item);

    }
    void setOnListener(){

        listener = new LibraryItemClickListener() {
            @Override
            public void goToDetailLibrary(Library item) {
                Intent intent = new Intent(LibraryActivity.this, LibraryDetailActivity.class);
                intent.putExtra("library", item);
                startActivity(intent);
            }
            @Override
            public void onDeleteLibrary(int position) {
                listLibrary.remove(position);
                Objects.requireNonNull(bind.rvListLibrary.getAdapter()).notifyItemRemoved(position);
                bind.rvListLibrary.smoothScrollToPosition(position+1);
            }
        };
    }

    void storeData(){
        listLibrary = new LinkedList<>();
        listLibrary.add(new Library("Memory of You", "Lofi","memory_of_you"));
        for(int i = 0; i < 7; i++)
            listLibrary.add(new Library("Number "+i,"Numeric", "audio_"+i));
    }
}
