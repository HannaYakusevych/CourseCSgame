package com.example.course_cs_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;

import com.example.course_cs_game.CardGame.GameCards;

public class MenuCards extends AppCompatActivity implements OnClickListener {

    // Settings of the game
    public static int numOfCardPairs = 8;
    public static int numOfCardTypes = 13;
    public static int maxNumOfCardTypes = 13;
    // TODO: Time depends on number of cards and level
    public static int timeForGame = 25000;
    public static int[] enabledCards = new int[maxNumOfCardTypes];
    public static int backId = R.drawable.back;


    Button start;
    Button settings;

    // Overriding the reaction of Back button
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        super.onUserLeaveHint();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game_menu);

        // Find elements
        start = findViewById(R.id.card_game_start);
        settings = findViewById(R.id.card_game_settings);

        start.setOnClickListener(this);
        settings.setOnClickListener(this);

        for (int i = 0; i < numOfCardTypes; i++) {
            enabledCards[i] = 1;
        }

    }

    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.card_game_start:
                intent = new Intent(this, GameCards.class);
                System.out.println("Log: Start the game");
                startActivity(intent);
                break;
            case R.id.card_game_settings:
                intent = new Intent(this, SettingsCards.class);
                startActivity(intent);
                break;
        }
    }
}
