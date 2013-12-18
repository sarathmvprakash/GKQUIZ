package com.sarath.gkquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * This class contain the main menu.
 *
 * @author sarath prakash
 */

public class MainMenu extends Activity implements OnClickListener {
  Button butPlay ,butSettings,butExit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_menu);
    butPlay = (Button)(findViewById(R.id.btn_play));
    butSettings = (Button)(findViewById(R.id.btn_settings));
    butExit = (Button)(findViewById(R.id.btn_exit));
    butPlay.setOnClickListener(this);
    butSettings.setOnClickListener(this);
    butExit.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
    case R.id.btn_play:
      Intent i = new Intent(MainMenu.this, QuizPlayScreen.class);
      startActivity(i);
      break;
    case R.id.btn_settings:
      // TODO: Show settings dialog box for enabling/disabling sound.
      break;
    case R.id.btn_exit:
      System.exit(0);
      break;
    default:
      break;
    }
  }
}
