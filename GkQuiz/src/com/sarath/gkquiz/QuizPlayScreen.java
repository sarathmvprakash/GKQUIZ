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
  private TextView question,indicator_100,indicator_200,indicator_300,indicator_500,indicator_1000,indicator_2000,
   indicator_4000,indicator_8000,indicator_16000,indicator_32000,
   indicator_64000,indicator_125000,indicator_250000,indicator_500000,indicator_1Million;
  private TextView option1;
  private TextView option2;
  private TextView option3;
  private TextView option4;
  private TextView countDown;
  private int quizLimit;
  private int quizId;
  private List<QuizEntry> quizEntries;
  private CountDownTimer timer;
  private int gamesWon;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.play_quiz);
    QuestionGenerator generator = new QuestionGenerator();
    quizEntries = generator.getQuizEntries();
    quizLimit = quizEntries.size();
    quizId = 0;
    gamesWon = 0;
    question = (TextView)findViewById(R.id.tv_question);
    option1 = (TextView)findViewById(R.id.tv_choice_1);
    option2 = (TextView)findViewById(R.id.tv_choice_2);
    option3 = (TextView)findViewById(R.id.tv_choice_3);
    option4 = (TextView)findViewById(R.id.tv_choice_4);
    indicator_100 = (TextView)findViewById(R.id.tv_rs100);
    indicator_200 = (TextView)findViewById(R.id.tv_rs200);
    indicator_300 = (TextView)findViewById(R.id.tv_rs300);
    indicator_500 = (TextView)findViewById(R.id.tv_rs500);
    indicator_1000 = (TextView)findViewById(R.id.tv_rs1000);
    indicator_2000 = (TextView)findViewById(R.id.tv_rs2000);
    indicator_4000 = (TextView)findViewById(R.id.tv_rs4000);
    indicator_8000 = (TextView)findViewById(R.id.tv_rs8000);
    indicator_16000 = (TextView)findViewById(R.id.tv_rs16000);
    indicator_32000 = (TextView)findViewById(R.id.tv_rs32000);
    indicator_64000 = (TextView)findViewById(R.id.tv_rs64000);
    indicator_125000 = (TextView)findViewById(R.id.tv_rs125000);
    indicator_250000 = (TextView)findViewById(R.id.tv_rs250000);
    indicator_500000 = (TextView)findViewById(R.id.tv_rs500000);
    indicator_1Million = (TextView)findViewById(R.id.tv_1million);
    countDown = (TextView)findViewById(R.id.tv_countdown);
    setOnClickListener(option1);
    setOnClickListener(option2);
    setOnClickListener(option3);
    setOnClickListener(option4);
    updateQuiz();
    amountWonTextBoxIndicator();
  }

  private void setOnClickListener(final TextView selectedOption) {
    selectedOption.setOnClickListener(new OnClickListener() {
      @Override public void onClick(View v) {
        if(checkCurrentQuestion(selectedOption)) {
          gamesWon++;
          amountWonTextBoxIndicator();
          if(timer != null){
            timer.cancel();
            timer = null;
          }
          selectedOption.setBackgroundColor(Color.GREEN);
          ++quizId;
          delay();
          displayAmountWon();
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
          new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              toastMethod(Color.RED, "GAME OVER");
              new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                  displayAmountWon();
                  new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                      finish();
                    }
                  }, 4000);
                }
              }, 4000);
            }
          }, 4000);
        }
      }
    });
  }

  private void toastMethod(int color, String post){
    Toast toast = Toast.makeText(this, post, Toast.LENGTH_SHORT);
    toast.getView().setBackgroundColor(color);
    toast.show();
  }

  private void updateQuiz() {
    if (quizId < quizLimit) {
      countdownTimer();
      option1.setBackgroundColor(getResources().getColor(R.color.blue));
      option2.setBackgroundColor(getResources().getColor(R.color.blue));
      option3.setBackgroundColor(getResources().getColor(R.color.blue));
      option4.setBackgroundColor(getResources().getColor(R.color.blue));
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
	    countDown.setText("TIMED OUT");
	    countDown.setTextColor(Color.RED);
	    new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
            displayAmountWon();
            new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                finish();
              }
            }, 4000);
          }
        }, 4000);
	  }
	}.start();
  }

  private void displayAmountWon(){
    if (gamesWon == 0){
	  toastMethod(Color.GREEN, "WON Rs 0");
	}
	else if (gamesWon == 1){
	  toastMethod(Color.GREEN, "WON Rs 100");
	}
    else if (gamesWon == 2){
      toastMethod(Color.GREEN, "WON Rs 200");
	}
    else if (gamesWon == 3){
      toastMethod(Color.GREEN, "WON Rs 300");
	}
    else if (gamesWon == 4){
      toastMethod(Color.GREEN, "WON Rs 500");
    }
    else if (gamesWon == 5){
      toastMethod(Color.GREEN, "WON Rs 1,000");
    }
    else if (gamesWon == 6){
      toastMethod(Color.GREEN, "WON Rs 2,000");
    }
    else if (gamesWon == 7){
      toastMethod(Color.GREEN, "WON Rs 4,000");
    }
    else if (gamesWon == 8){
      toastMethod(Color.GREEN, "WON Rs 8,000");
    }
    else if (gamesWon == 9){
      toastMethod(Color.GREEN, "WON Rs 16,000");
    }
    else if (gamesWon == 10){
      toastMethod(Color.GREEN, "WON Rs 32,000");
    }
    else if (gamesWon == 11){
      toastMethod(Color.GREEN, "WON Rs 64,000");
    }
    else if (gamesWon == 12){
      toastMethod(Color.GREEN, "WON Rs 125,000");
    }
    else if (gamesWon == 13){
      toastMethod(Color.GREEN, "WON Rs 250,000");
    }
    else if (gamesWon == 14){
      toastMethod(Color.GREEN, "WON Rs 500,000");
    }
    else if (gamesWon == 15){
      toastMethod(Color.GREEN, "WON Rs 1 Millon !!!!!");
    }
  }

  public void delay(){
    new Handler().postDelayed(new Runnable() {
	  @Override
	  public void run() {
	    updateQuiz();
	  }
	}, 1000);
  }

  public void amountWonTextBoxIndicator(){
    if(gamesWon == 0){
      indicator_100.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 1){
      indicator_100.setTextColor(Color.GREEN);
      indicator_200.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 2){
      indicator_200.setTextColor(Color.GREEN);
      indicator_300.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 3){
      indicator_300.setTextColor(Color.GREEN);
      indicator_500.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 4){
      indicator_500.setTextColor(Color.GREEN);
      indicator_1000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 5){
      indicator_1000.setTextColor(Color.GREEN);
      indicator_2000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 6){
      indicator_2000.setTextColor(Color.GREEN);
      indicator_4000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 7){
      indicator_4000.setTextColor(Color.GREEN);
      indicator_8000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 8){
      indicator_8000.setTextColor(Color.GREEN);
      indicator_16000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 9){
      indicator_16000.setTextColor(Color.GREEN);
      indicator_32000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 10){
      indicator_32000.setTextColor(Color.GREEN);
      indicator_64000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 10){
      indicator_64000.setTextColor(Color.GREEN);
      indicator_125000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 11){
      indicator_125000.setTextColor(Color.GREEN);
      indicator_250000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 12){
      indicator_250000.setTextColor(Color.GREEN);
      indicator_500000.setTextColor(getResources().getColor(R.color.orange));
    }
    else if(gamesWon == 13){
      indicator_500000.setTextColor(Color.GREEN);
      indicator_1Million.setTextColor(getResources().getColor(R.color.orange));
    }
  }

  public boolean checkCurrentQuestion(TextView selectedOption){
    if(selectedOption.getText().equals(quizEntries.get(quizId).answer)) {
      return true;
    }
    else{
      return false;
    }
  }
}
