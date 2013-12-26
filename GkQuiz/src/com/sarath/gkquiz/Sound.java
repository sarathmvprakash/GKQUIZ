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
  private int secondCurrentBackgroundSoundPaying;
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
        currentBackgroundSoundPaying = START_BACKGROUND_SOUND;
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
    firstMediaPlayer = MediaPlayer.create(context, normalBackgoundSound);
    firstMediaPlayer.setLooping(true);
    firstMediaPlayer.start();
  }

  public void rightAnswerBackgroundSound() {
    if (!isSoundMuted()) {
      secondMediaPlayer = MediaPlayer.create(context, rightAnswerBackgoundSound);
      secondCurrentBackgroundSoundPaying = NORMAL_BACKGROUND_SOUND;
      secondMediaPlayer.start();
    }
  }

  public void wrongAnswerBackgroundSound() {
    if (!isSoundMuted()) {
      secondMediaPlayer = MediaPlayer.create(context, wrongAnswerBackgoundSound);
      secondCurrentBackgroundSoundPaying = NORMAL_BACKGROUND_SOUND;
      secondMediaPlayer.start();
    }
  }

  public void stopMusic() {
    if (currentBackgroundSoundPaying == START_BACKGROUND_SOUND) {
      firstMediaPlayer.stop();
    } else if (secondCurrentBackgroundSoundPaying == NORMAL_BACKGROUND_SOUND) {
      secondMediaPlayer.stop();
    } else if (currentBackgroundSoundPaying == START_BACKGROUND_SOUND && secondCurrentBackgroundSoundPaying == NORMAL_BACKGROUND_SOUND) {
      firstMediaPlayer.stop();
      secondMediaPlayer.stop();
    }
  }

  public boolean isSoundMuted() {
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
    return sp.getBoolean("CHECKBOX", false);
  }
}
