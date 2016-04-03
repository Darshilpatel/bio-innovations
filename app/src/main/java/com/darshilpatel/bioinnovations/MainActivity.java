package com.darshilpatel.bioinnovations;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerView mainRecyclerView;
    Intent intent;

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));
        Intent introIntent = new Intent(MainActivity.this, pagerActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);
        if (isUserFirstTime)
            startActivity(introIntent);


    }

    public void newActivity(View view){
        Intent intent = new Intent(MainActivity.this,finalActivity.class);
        startActivity(intent);
    }

    public void userResponded(View view) {

        int id = view.getId();
        String userId = "";

          userId = view.getResources().getResourceEntryName(id);
        int resourceId = getResources().getIdentifier(userId, "raw", "com.darshilpatel.bioinnovations");

        MediaPlayer mainPlayer = MediaPlayer.create(this, resourceId);
        mainPlayer.start();

        Log.i("button tapped", userId);

    }
}
