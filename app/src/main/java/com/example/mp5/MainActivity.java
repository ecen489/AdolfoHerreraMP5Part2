package com.example.mp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int currentScore;
    private TextView scoreBoard;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.resetButton);
        scoreBoard = findViewById(R.id.score);
        final Intent HistoryIntent = new Intent(this,DispImages.class);
        final Intent MarvelIntent = new Intent(this,marvelQuiz.class);
        final Intent FriendsIntent = new Intent(this,firendsQuiz.class);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            currentScore = extras.getInt("score");
            scoreBoard.setText(Integer.toString(currentScore));
        }


        String mainMenu[] = getResources().getStringArray(R.array.oses);
        ListAdapter list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainMenu);
        ListView clickableList2 = (ListView) findViewById(R.id.mainList);
        clickableList2.setAdapter(list);



        clickableList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    HistoryIntent.putExtra("score",currentScore);
                    startActivity(HistoryIntent);
                    finish();

                }
                else if (position == 1) {
                    MarvelIntent.putExtra("score",currentScore);
                    startActivity(MarvelIntent);
                    finish();

                }
                else if (position == 2) {
                    FriendsIntent.putExtra("score",currentScore);
                    startActivity(FriendsIntent);
                    finish();
                } else {
                    System.out.println("Error Pressing an Item");
                }
            }
        });
    }

    public void resetScoreBoard (View v) {
        currentScore = 0;
        scoreBoard.setText("0");
    }

}
