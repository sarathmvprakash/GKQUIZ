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
  private MediaPlayer firstMediaPlayer;
  private MediaPlayer secondMediaPlayer;
  private int startingBackgoundSound;
  private int normalBackgoundSound;
  private int rightAnswerBackgoundSound;
  private int wrongAnswerBackgoundSound;
  private int currentBackgroundSoundPaying;
  private static final int START_BACKGROUND_SOUND = 1;
  private static final int NORMAL_BACKGROUND_SOUND = 2;

  public Sound(Context context) {
    this.context = context;
    this.startingBackgoundSound = R.raw.normal;
    this.normalBackgoundSound = R.raw.normal2;
    this.rightAnswerBackgoundSound = R.raw.clap;
    this.wrongAnswerBackgoundSound = R.raw.wrong;
  }

  public void checkSoundFinishedPlaying() {
    firstMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
      public void onCompletion(MediaPlayer mp) {
        currentBackgroundSoundPaying = NORMAL_BACKGROUND_SOUND;
        firstMediaPlayer.stop();
        normalBackgroundSound();
      }
    });
  }

  public void startBackgroundSound() {
    if (!isSoundMuted()) {
      currentBackgroundSoundPaying = START_BACKGROUND_SOUND;
      firstMediaPlayer = MediaPlayer.create(context, startingBackgoundSound);
      firstMediaPlayer.start();
      checkSoundFinishedPlaying();
    }
  }

  public void normalBackgroundSound() {
    secondMediaPlayer = MediaPlayer.create(context, normalBackgoundSound);
    secondMediaPlayer.setLooping(true);
    secondMediaPlayer.start();
  }

  public void rightAnswerBackgroundSound() {
    if (!isSoundMuted()) {
      firstMediaPlayer = MediaPlayer.create(context, rightAnswerBackgoundSound);
      firstMediaPlayer.start();
    }
  }

  public void wrongAnswerBackgroundSound() {
    if (!isSoundMuted()) {
      stopMusic();
      firstMediaPlayer = MediaPlayer.create(context, wrongAnswerBackgoundSound);
      firstMediaPlayer.start();
    }
  }

  public void stopMusic() {
    if (currentBackgroundSoundPaying == 1) {
      firstMediaPlayer.stop();
    } else {
      secondMediaPlayer.stop();
    }
  }

  public boolean isSoundMuted() {
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
    return sp.getBoolean("CHECKBOX", false);
  }
}
