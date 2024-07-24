package com.example.primecoding;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class quiz1 extends AppCompatActivity
        implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private ImageView Image;
    private TextView questionTextView;
    private int correct = 0;
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.a, true),
            new Question(R.string.b, true),
            new Question(R.string.c, true),
            new Question(R.string.d, false),
            new Question(R.string.e, true),
            new Question(R.string.f, true),
            new Question(R.string.g, true),
            new Question(R.string.h, false),
            new Question(R.string.i, false),
            new Question(R.string.j, true),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        getSupportActionBar().setTitle("Quiz 1");
        nextButton = findViewById(R.id.next_button);
        questionTextView
                = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:
                if (currentQuestionIndex < 11) {
                    currentQuestionIndex
                            = currentQuestionIndex + 1;
                    if (currentQuestionIndex == 10) {
                        questionTextView.setText(getString(
                                R.string.correct, correct));
                        nextButton.setVisibility(
                                View.INVISIBLE);
                        trueButton.setVisibility(
                                View.INVISIBLE);
                        falseButton.setVisibility(
                                View.INVISIBLE);
                        if (correct > 5)
                            Image.setImageResource(R.drawable.cup);
                        else
                            Image.setImageResource(
                                    R.drawable.resu);
                    }
                    else {
                        updateQuestion();
                    }
                }
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion()
    {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(
                questionBank[currentQuestionIndex]
                        .getAnswerResId());
        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 0:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 1:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 2:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 3:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 4:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 5:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 6:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 7:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 8:
                Image.setImageResource(R.drawable.funny1);
                break;
            case 9:
                Image.setImageResource(R.drawable.funny1);
                break;
        }
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = questionBank[currentQuestionIndex]
                .isAnswerTrue();
        int toastMessageId;

        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;

        }
        else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(quiz1.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}
