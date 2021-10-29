package id.ac.umn.norbertus_37417;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.Objects;

import id.ac.umn.norbertus_37417.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setTitle("Profile");

        String[] references = {
                "https://developer.android.com/training/appbar/setting-up",
                "https://developer.android.com/guide/components/activities/tasks-and-back-stack",
                "https://developer.android.com/guide/components/activities/activity-lifecycle",
                "https://www.py4u.net/discuss/624094",
                "https://developer.android.com/guide/navigation/navigation-custom-back",
                "https://www.tabnine.com/code/java/methods/android.app.Activity/onBackPressed",
                "https://youtu.be/ujKDN_ZtGHQ",
                "https://youtu.be/vBxNDtyE_Co",
                "https://youtu.be/69C1ljfDvl0",
                "https://youtu.be/ODg638Qzp8g",
                "https://youtu.be/M_0q6rGUsNc",
                "https://developer.android.com/guide/topics/ui/menus#options-menu",
                "https://developer.android.com/guide/navigation/navigation-custom-back",
                "https://stackoverflow.com/questions/3185103/how-to-define-a-circle-shape-in-an-android-xml-drawable-file",
                "https://stackoverflow.com/questions/22105775/imageview-in-circular-through-xml",
                "https://github.com/hdodenhof/CircleImageView",
                "https://stackoverflow.com/questions/47107105/android-button-has-setontouchlistener-called-on-it-but-does-not-override-perform",
                "https://stackoverflow.com/questions/10863572/programmatically-go-back-to-the-previous-fragment-in-the-backstack",
                "https://github.com/bignerdranch/expandable-recycler-view/issues/357",
                "https://newbedev.com/recyclerview-item-click-listener-the-right-way",
                "https://stackoverflow.com/questions/33995483/recyclerview-child-item-on-click-issues",
                "https://stackoverflow.com/questions/24952312/ontouchlistener-warning-ontouch-should-call-viewperformclick-when-a-click-is-d",
                "https://youtube.com/playlist?list=PL9Ngw9rdv8NI79HIqT2iz4EPUFgnhCoCn",
                "https://devdeeds.com/clear-backstack-of-activities/",
                "https://developer.android.com/guide/fragments/create",
                "https://stackoverflow.com/questions/10863572/programmatically-go-back-to-the-previous-fragment-in-the-backstack",
                "https://www.py4u.net/discuss/624094",
                "https://stackoverflow.com/questions/25586427/how-to-get-back-to-previous-activity-from-a-fragment",
                "https://stackoverflow.com/questions/20669504/which-method-gets-called-in-the-parent-activity-when-the-user-clicks-on-back-in",
                "https://stackoverflow.com/questions/12266502/android-mediaplayer-stop-and-play"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, references);

        bind.lvProfileReference.setAdapter(adapter);
    }
}
