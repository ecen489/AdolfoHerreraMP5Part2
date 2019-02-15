package com.example.mp5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class firendsQuiz extends AppCompatActivity {

    private Button sumbitButton;
    private TextView questionDisplay;
    private EditText answerInput;
    private int currentScore;
    private String mainMenu[];


    Intent mainIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_friends);

        mainIntent = new Intent(this,MainActivity.class);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentScore = extras.getInt("score");
            System.out.println("entered here");
            //The key argument here must match that used in the other activity
        }

        mainMenu = getResources().getStringArray(R.array.Friends);
        String randomStr = mainMenu[new Random().nextInt(mainMenu.length)];

        sumbitButton = (Button) findViewById(R.id.button2);
        answerInput = (EditText) findViewById(R.id.editText);

        questionDisplay = (TextView) findViewById(R.id.question);
        questionDisplay.setText(randomStr);

    }

    public void formSubmit(View v) {

        String answer = answerInput.getText().toString();
        String question = questionDisplay.getText().toString();

        if (answer.equalsIgnoreCase("fat") && question.equalsIgnoreCase(mainMenu[0])) {
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
            currentScore += 5;
            mainIntent.putExtra("score",currentScore);
        } else if(answer.equalsIgnoreCase("they were on a break") && question.equalsIgnoreCase(mainMenu[1])) {
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
            currentScore += 5;
            mainIntent.putExtra("score",currentScore);
        } else if(answer.equalsIgnoreCase("true") && question.equalsIgnoreCase(mainMenu[2])) {
            Toast.makeText(this,"Correct", Toast.LENGTH_SHORT).show();
            currentScore += 5;
            mainIntent.putExtra("score",currentScore);
        } else {
            Toast.makeText(this,"Incorrect", Toast.LENGTH_SHORT).show();
            mainIntent.putExtra("score",currentScore);
        }

        startActivity(mainIntent);
        answerInput.setText("");
        finish();

    }
}
