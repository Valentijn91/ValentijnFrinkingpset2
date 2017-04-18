package com.example.vfrin.valentijnfrinkingpset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoToSecondScreen(View view) {

        Intent intent = new Intent (this, Fillinthewords.class);
        startActivity(intent);
        finish();
    }
}
