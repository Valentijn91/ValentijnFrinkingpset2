package com.example.vfrin.valentijnfrinkingpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TheEndStory extends AppCompatActivity {

    TextView EndStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_end_story);

        //initialize the textfield by id
        EndStory = (TextView)findViewById(R.id.endstory);

        //get the story from the extras and initialize
        Bundle extras = getIntent().getExtras();
        String story = extras.getString("story", "No story to show");

        //write story
        EndStory.setText(story);

    }


    public void goback(View view) {

        Intent goToHome = new Intent(this, MainActivity.class);
        startActivity(goToHome);
        finish();
    }
}
