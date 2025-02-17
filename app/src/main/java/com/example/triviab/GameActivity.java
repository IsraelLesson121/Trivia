package com.example.triviab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btna1,btna2,btna3,btna4;
    private TextView tvQuestion;
    private TextView getTvQuestionNumber, tvPoints,tvGameOver;
    private Collection collection;
    private Question currentQuestion;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);
        tvQuestion= findViewById(R.id.tvQuestion);
        btna1 = findViewById(R.id.btna1);
        btna2 = findViewById(R.id.btna2);
        btna3 = findViewById(R.id.btna3);
        btna4 = findViewById(R.id.btna4);

        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        tvPoints = findViewById(R.id.tvPoints);
        getTvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvGameOver = findViewById(R.id.tvGameOver);
        tvGameOver.setVisibility(View.INVISIBLE);

        collection = new Collection();
        collection.initQuestions();
        nextQuestion();

    }

    private void nextQuestion() {
       if(collection.isNotLastQuestion()){
           currentQuestion = collection.getNextQuestion(); //refernce
           tvQuestion.setText(currentQuestion.getQuestion());
           btna1.setText(currentQuestion.getA1());
           btna2.setText(currentQuestion.getA2());
           btna3.setText(currentQuestion.getA3());
           btna4.setText(currentQuestion.getA4());
       }
       else
       {
           tvGameOver.setVisibility((View.VISIBLE));
           CustomDialog customDialog = new CustomDialog(this);
           customDialog.show();

       }
    }

    @Override
    public void onClick(View view) {
     if (view == btna1)
     {
         if(currentQuestion.getCorrect() == 1)
         {
             points++;
         }
     }
        if (view == btna2)
        {
            if(currentQuestion.getCorrect() == 2)
            {
                points++;
            }
        }
        if (view == btna3)
        {
            if(currentQuestion.getCorrect() == 3)
            {
                points++;
            }
        }
        if (view == btna4)
        {
            if(currentQuestion.getCorrect() == 4)
            {
                points++;
            }
        }
        tvPoints.setText("points: " + points);
        if(collection.isNotLastQuestion()){
            getTvQuestionNumber.setText("Question number:" + (collection.getIndex() + 1));
        }
        nextQuestion();

    }

    public void reset() {
        this.points = 0;
        collection.initQuestions();
        tvPoints.setText("Points: " + 0);
        getTvQuestionNumber.setText("Question number " + 1);
        tvGameOver.setVisibility(View.INVISIBLE);
        this.nextQuestion();
    }
}