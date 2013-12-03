package com.sarath.gkquiz;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * This class is for quiz entry.
 *
 * @author sarath prakash.
 */
public class QuizEntry implements Parcelable {
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

  @Override public int describeContents() {
    return hashCode();
  }

  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(getQuestion());
    dest.writeString(getAnswer());
    dest.writeList(getOptions());
  }

  public QuizEntry(Parcel source) {
    this.question = source.readString();
    this.answer = source.readString();
    this.options = new ArrayList<String>();
    source.readList(options, null);
  }

  public static final Parcelable.Creator<QuizEntry> CREATOR = new Parcelable.Creator<QuizEntry>() {
    public QuizEntry createFromParcel(Parcel in) {
      return new QuizEntry(in);
    }
    public QuizEntry[] newArray(int size) {
      return new QuizEntry[size];
    }
  };
}
