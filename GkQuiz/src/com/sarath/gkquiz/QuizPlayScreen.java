package com.sarath.gkquiz;

import java.util.List;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is used for quiz board.
 *
 * @author sarath prakash.
 */
public class QuizPlayScreen extends Activity {
  private TextView question;
  private TextView option1;
  private TextView option2;
  private TextView option3;
  private TextView option4;
  private TextView countDown;
  private int quizLimit;
  private int quizId;
  private List<QuizEntry> quizEntries;
  private CountDownTimer timer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.play_quiz);
    QuestionGenerator generator = new QuestionGenerator();
    quizEntries = generator.getQuizEntries();
    quizLimit = quizEntries.size();
    quizId = 0;
    question = (TextView)findViewById(R.id.tv_question);
    option1 = (TextView)findViewById(R.id.tv_choice_1);
    option2 = (TextView)findViewById(R.id.tv_choice_2);
    option3 = (TextView)findViewById(R.id.tv_choice_3);
    option4 = (TextView)findViewById(R.id.tv_choice_4);
    countDown = (TextView)findViewById(R.id.tv_countdown);
    setOnClickListener(option1);
    setOnClickListener(option2);
    setOnClickListener(option3);
    setOnClickListener(option4);
    updateQuiz();
  }

  private void setOnClickListener(final TextView selectedOption) {
    selectedOption.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        if(selectedOption.getText().equals(quizEntries.get(quizId).answer)) {
          if(timer != null){
          timer.cancel();
          timer = null;
          }
          selectedOption.setBackgroundColor(Color.GREEN);
          ++quizId;
          delay();
        } else {
          selectedOption.setBackgroundColor(Color.RED);
          if(option1.getText().equals(quizEntries.get(quizId).answer)){
            option1.setBackgroundColor(Color.GREEN);
          }
          if(option2.getText().equals(quizEntries.get(quizId).answer)){
            option2.setBackgroundColor(Color.GREEN);
          }
          if(option3.getText().equals(quizEntries.get(quizId).answer)){
            option3.setBackgroundColor(Color.GREEN);
          }
          if(option4.getText().equals(quizEntries.get(quizId).answer)){
            option4.setBackgroundColor(Color.GREEN);
          }
          Toast.makeText(getApplicationContext(), "GAME OVER", Toast.LENGTH_LONG).show();
          delay();
          delay();
          finish();
        }
      }
    });
  }

  private void updateQuiz() {
    if (quizId < quizLimit) {
      countdownTimer();
      QuizEntry entry = quizEntries.get(quizId);
      question.setText(entry.question);
      option1.setText(entry.options.get(0));
      option2.setText(entry.options.get(1));
      option3.setText(entry.options.get(2));
      option4.setText(entry.options.get(3));
    }
  }

  private void countdownTimer(){
    timer = new CountDownTimer(60000, 1000) {
      public void onTick(long millisUntilFinished) {
	    countDown.setText("" + millisUntilFinished / 1000);
	  }
	  public void onFinish() {
	    countDown.setText("FINISH");
	    finish();
	  }
	}.start();
  }

  public void delay(){
    new Handler().postDelayed(new Runnable() {
	  @Override
	  public void run() {
	    updateQuiz();
	  }
	}, 1000);
  }
}
