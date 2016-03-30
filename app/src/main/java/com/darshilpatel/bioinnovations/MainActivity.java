package com.darshilpatel.bioinnovations;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
