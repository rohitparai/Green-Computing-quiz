package com.greencomputing.quizforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.greencomputing.quizforfun.other.Constants;
import com.greencomputing.quizforfun.other.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EasyQuizActivity extends AppCompatActivity {


    private int currentQuestionIndex = 0;
    private TextView tvQuestion, tvQuestionNumber;
    private Button btnNext;
    private RadioGroup radioGroup;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private List<String> questions;
    private int correctQuestion = 0;
    private Map<String, Map<String, Boolean>> questionsAnswerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_quiz);

        Intent intent = getIntent();
        String subject = intent.getStringExtra(Constants.SUBJECT);

        TextView tvTitle = findViewById(R.id.textView26);

        if (subject.equals(getString(R.string.literature))) {
            questionsAnswerMap = Utils.getRandomMathQuestions(EasyQuizActivity.this, getString(R.string.easy), Constants.QUESTION_SHOWING);
            tvTitle.setText(getString(R.string.hard_quiz));
        } else {
            questionsAnswerMap = Utils.getRandomLiteratureAndGeographyQuestions(this, getString(R.string.moderate), Constants.QUESTION_SHOWING);
            tvTitle.setText(getString(R.string.moderate_quiz));
        }
        questions = new ArrayList<>(questionsAnswerMap.keySet());


        tvQuestion = findViewById(R.id.textView78);
        tvQuestionNumber = findViewById(R.id.textView18);
        btnNext = findViewById(R.id.btnNextQUESTIONeasyANDhard);
        radioGroup = findViewById(R.id.radioGroup);

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton4 = findViewById(R.id.radioButton4);

        findViewById(R.id.btnNextQUESTIONeasyANDhard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                boolean answer = questionsAnswerMap.get(questions.get(currentQuestionIndex)).get(radioButton.getText());

                if (answer) {
                    correctQuestion++;
                }

                currentQuestionIndex++;

                if (btnNext.getText().equals(getString(R.string.next))) {
                    displayNextQuestions();
                } else {
                    Intent intentResult = new Intent(EasyQuizActivity.this, FinalResultActivity.class);
                    intentResult.putExtra(Constants.SUBJECT, subject);
                    intentResult.putExtra(Constants.CORRECT, correctQuestion);
                    intentResult.putExtra(Constants.INCORRECT, Constants.QUESTION_SHOWING - correctQuestion);
                    intentResult.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentResult);
                    finish();
                }

            }
        });

        findViewById(R.id.imageViewStartQuizGeographyOrLiterature).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        displayData();
    }

    private void displayNextQuestions() {
        setAnswersToRadioButton();
        tvQuestion.setText(questions.get(currentQuestionIndex));
        tvQuestionNumber.setText("Current Question: " + (currentQuestionIndex + 1));

        if (currentQuestionIndex == Constants.QUESTION_SHOWING - 1) {
            btnNext.setText(getText(R.string.finish));
        }
    }

    private void displayData() {
        tvQuestion.setText(questions.get(currentQuestionIndex));
        tvQuestionNumber.setText("Current Question: " + (currentQuestionIndex + 1));

        setAnswersToRadioButton();
    }

    private void setAnswersToRadioButton() {

        ArrayList<String> questionKey = new ArrayList(questionsAnswerMap.get(questions.get(currentQuestionIndex)).keySet());

        radioButton1.setText(questionKey.get(0));
        radioButton2.setText(questionKey.get(1));
        radioButton3.setText(questionKey.get(2));
        radioButton4.setText(questionKey.get(3));

    }

          /* Intent getIntent = getIntent();
        questionsAnswerMap = ( HashMap<String,Map<String,Boolean>>) Utils.getRandomMathQuestions(Constants.QUESTION_SHOWING);
        questions = new ArrayList<>(questionsAnswerMap.keySet());

        tvQuestion = findViewById(R.id.textView8);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumberMath);
        btnNext = findViewById(R.id.btnNextQuestionMath);
        etAnswer = findViewById(R.id.tietEnterAnswerMath);

        findViewById(R.id.imageViewStartQuiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answer = etAnswer.getText().toString();

                if (answer.isEmpty()){
                    Toast.makeText(EasyQuizActivity.this, "Answer cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (questionsAnswerMap.get(questions.get(currentQuestionIndex)).equals(answer)) {
                    correctQuestion++;
                }
                currentQuestionIndex++;

                if (btnNext.getText().equals(getString(R.string.next))){
                    displayNextQuestions();
                }else{
                    Intent intentResult = new Intent(EasyQuizActivity.this,FinalResultActivity.class);
                    intentResult.putExtra(Constants.SUBJECT,getString(R.string.math));
                    intentResult.putExtra(Constants.CORRECT,correctQuestion);
                    intentResult.putExtra(Constants.INCORRECT,Constants.QUESTION_SHOWING - correctQuestion);
                    intentResult.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intentResult);
                    finish();
                }
            }
        });

        displayData();
    }

    private void displayNextQuestions() {
        etAnswer.setText("");
        tvQuestion.setText(questions.get(currentQuestionIndex) + " = ?");
        tvQuestionNumber.setText("Current Question: " + (currentQuestionIndex + 1));

        if (currentQuestionIndex == Constants.QUESTION_SHOWING  - 1){
            btnNext.setText(getText(R.string.finish));
        }
    }

    private void displayData() {
        tvQuestion.setText(questions.get(currentQuestionIndex) + " = ?");
        tvQuestionNumber.setText("Current Question: " + (currentQuestionIndex + 1));
    }
*/
}