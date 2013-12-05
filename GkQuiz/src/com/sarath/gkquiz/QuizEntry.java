package com.sarath.gkquiz;


import java.util.List;

/**
 * This class is for quiz entry.
 *
 * @author sarath prakash.
 */
public class QuizEntry  {
  public final String question;
  public List<String> options;
  public final String answer;

  public QuizEntry(String question, List<String> options, String answer) {
    this.question = question;
    this.answer = answer;
    this.options = options;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public List<String> getOptions() {
    return options;
  }
}
