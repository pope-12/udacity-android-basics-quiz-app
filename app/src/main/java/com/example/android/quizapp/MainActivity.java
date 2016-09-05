package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //points
    private static double PERFECT_SCORE = 4.0;
    private static double BEGINNING_SCORE = 0.0;
    private double quizScore = BEGINNING_SCORE;

    //Question answers
    private static String FALSE_ANSWER = "false";
    private static String TRUE_ANSWER = "true";
    private static String SERVING_ANSWER = "serving";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * On button click submit the quiz and display the score
     */
    public void submitQuiz(View view) {
        //message to display to the user
        String message;

        //grade each question
        this.question1();
        this.question2();
        this.question3();
        this.question4();

        //set and display message
        message = "Your score: " + this.quizScore + "/" + PERFECT_SCORE;
        this.showToast(message);

        //reset the score
        this.quizScore = BEGINNING_SCORE;
    }

    /*
     * Grade question 1 (checkboxes)
     */
    private void question1() {
        //get checkboxes for this question
        CheckBox Larry = (CheckBox)findViewById(R.id.Larry);
        CheckBox John = (CheckBox)findViewById(R.id.John);
        CheckBox James = (CheckBox)findViewById(R.id.James);
        CheckBox Jay = (CheckBox)findViewById(R.id.Jay);

        //grade each checkbox to see if it matches the expected value and award points accordingly
        this.gradeQuestionPart("" + Larry.isChecked(), TRUE_ANSWER, .25);
        this.gradeQuestionPart("" + James.isChecked(), TRUE_ANSWER, .25);
        this.gradeQuestionPart("" + John.isChecked(), FALSE_ANSWER, .25);
        this.gradeQuestionPart("" + Jay.isChecked(), FALSE_ANSWER, .25);
    }

    /*
     * Grade question 2 (checkboxes)
     */
    private void question2() {
        CheckBox Chris = (CheckBox)findViewById(R.id.Chris);
        CheckBox Nate = (CheckBox)findViewById(R.id.Nate);
        CheckBox Matt = (CheckBox)findViewById(R.id.Matt);
        CheckBox Megan = (CheckBox)findViewById(R.id.Megan);

        this.gradeQuestionPart("" + Nate.isChecked(), TRUE_ANSWER, .25);
        this.gradeQuestionPart("" + Matt.isChecked(), TRUE_ANSWER, .25);
        this.gradeQuestionPart("" + Megan.isChecked(), TRUE_ANSWER, .25);
        this.gradeQuestionPart("" + Chris.isChecked(), FALSE_ANSWER, .25);
    }

    /*
     * Grade question 3 (text input)
     */
    private void question3() {
        EditText values = (EditText)findViewById(R.id.values);

        this.gradeQuestionPart("" + values.getText(), SERVING_ANSWER, 1);
    }

    /*
     * Grade question 4 (radio)
     */
    private void question4() {
        RadioButton lossPrevention = (RadioButton)findViewById(R.id.Loss_Prevention);

        this.gradeQuestionPart("" + lossPrevention.isChecked(), TRUE_ANSWER, 1);
    }

    /*
     * Grades each question part
     * Pass in users answers, the correct answer, and how many points this part is worth
     * If correct, adds value to quiz score
     * There is partial credit given because of how this is implemented,
     * so if a user does nothing they get .75/4 for the checkboxes that should not be checked that aren't
     */
    private void gradeQuestionPart(String userValue, String expectedValue, double questionValue) {
        if (userValue.equals(expectedValue)) {
            this.quizScore += questionValue;
        }
    }

    /*
     * Shows a long toast message
     * Pass in string to display
     */
    private void showToast(String displayText) {
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(this, displayText, duration);
        toast.show();
    }
}
