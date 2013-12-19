package com.sarath.gkquiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.preference.PreferenceManager;
/**
 * This class is for sound.
 *
 * @author sarath prakash.
 */

public class Sound {
  private final Context context;
  private MediaPlayer mediaPlayer;
  private MediaPlayer mediaPlayer2;
  private int startingBackgoundSound;
  private int normalBackgoundSound;
  private int rightAnswerBackgoundSound;
  private int wrongAnswerBackgoundSound;
  private int currentBackgroundSoundPaying;

  public Sound(Context context) {
    this.context = context;
    this.startingBackgoundSound = R.raw.normal;
    this.normalBackgoundSound = R.raw.normal2;
    this.rightAnswerBackgoundSound = R.raw.clap;
    this.wrongAnswerBackgoundSound = R.raw.wrong;
  }

  public void checkSoundFinishedPlaying() {
    mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
      public void onCompletion(MediaPlayer mp) {
        currentBackgroundSoundPaying = 2;
        mediaPlayer.stop();
        normalBackgroundSound();
      }
    });
  }

  public void startBackgroundSound() {
    if (!isSoundEnabled()) {
      currentBackgroundSoundPaying = 1;
      mediaPlayer = MediaPlayer.create(context, startingBackgoundSound);
      mediaPlayer.start();
      checkSoundFinishedPlaying();
    }
  }

  public void normalBackgroundSound() {
    mediaPlayer2 = MediaPlayer.create(context, normalBackgoundSound);
    mediaPlayer2.setLooping(true);
    mediaPlayer2.start();
  }

  public void rightAnswerBackgroundSound() {
    if (!isSoundEnabled()) {
      mediaPlayer = MediaPlayer.create(context, rightAnswerBackgoundSound);
      mediaPlayer.start();
    }
  }

  public void wrongAnswerBackgroundSound() {
    if (!isSoundEnabled()) {
      stopMusic();
      mediaPlayer = MediaPlayer.create(context, wrongAnswerBackgoundSound);
      mediaPlayer.start();
    }
  }

  public void stopMusic() {
    if (currentBackgroundSoundPaying == 1) {
      mediaPlayer.stop();
    } else {
      mediaPlayer2.stop();
    }
  }

  private boolean isSoundEnabled() {
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
    return sp.getBoolean("CHECKBOX", true);
  }
}
