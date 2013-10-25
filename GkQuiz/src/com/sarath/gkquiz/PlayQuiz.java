package com.sarath.gkquiz;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is used for quiz board.
 *
 * @author sarath prakash.
 */
public class PlayQuiz extends Activity {
  private TextView question;
  private TextView option1;
  private TextView option2;
  private TextView option3;
  private TextView option4;
  private int quizLimit;
  private int quizId;
  private List<QuizEntry> quizEntries;

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
          Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_LONG).show();
          ++quizId;
          updateQuiz();
        } else {
          Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_LONG).show();
          finish();
        }
      }
    });
  }

  private void updateQuiz() {
    if (quizId < quizLimit) {
      QuizEntry entry = quizEntries.get(quizId);
      question.setText(entry.question);
      option1.setText(entry.options.get(0));
      option2.setText(entry.options.get(1));
      option3.setText(entry.options.get(2));
      option4.setText(entry.options.get(3));
    } else {
      Toast.makeText(getApplicationContext(), "You won the game", Toast.LENGTH_LONG).show();
      finish();
    }
  }
}
