package com.example.vfrin.valentijnfrinkingpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Fillinthewords extends AppCompatActivity {

    Story story;            // instance of story
    TextView words_left,    // text of the words left to type
            type_word;      // type of word that has to be typed
    EditText input;         // inputfield for words
    List<Integer> stories;  // list containing all possible stories
    InputStream inputstream;// inputstream for story


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fillinthewords);


        // fill array with all the stories
        stories = new ArrayList<Integer>();
        stories.add(R.raw.madlib0_simple);
        stories.add(R.raw.madlib1_tarzan);
        stories.add(R.raw.madlib2_university);
        stories.add(R.raw.madlib3_clothes);
        stories.add(R.raw.madlib4_dance);

        //getting all id's
        words_left = (TextView)findViewById(R.id.words_left);
        type_word = (TextView) findViewById(R.id.type_word);
        input = (EditText) findViewById(R.id.input);

        // initialize the inputstream with one of the possible stories by getting a
        // random story from the stories array
        inputstream = this.getResources().openRawResource(stories.get((int)Math.floor(Math.random()*stories.size())));
        story = new Story(inputstream);

        // prepare for next word
        nextWord();
    }
    /** When confirm button has been clicked, confirm word if input is not empty */
    public void confirm_word(View view) {

        // check if user put in input
        if (!TextUtils.isEmpty(input.getText())) {
            // put the input from the user in the story
            story.fillInPlaceholder(input.getText().toString());

            // check if story is completely filled
            if (story.isFilledIn()) {
                Intent GoToEndStory = new Intent(this, TheEndStory.class);
                GoToEndStory.putExtra("story", story.toString());

                startActivity(GoToEndStory);
                finish();
            }

            //clear the inputfield
            input.setText("");


            //prepare for next word
            nextWord();
        }

        else{
            Toast toast = Toast.makeText(this, "give me a/an" + story.getNextPlaceholder()+ ",please", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //retrieve information to put on screen for next word
    public void nextWord(){
        words_left.setText(story.getPlaceholderRemainingCount() + "word(s) left");
        type_word.setText("Please type a/an" + story.getNextPlaceholder());
        input.setHint(story.getNextPlaceholder());
    }
}
