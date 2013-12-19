package com.sarath.gkquiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupWindow;
/**
 * This class contain the main menu.
 *
 * @author sarath prakash
 */

public class MainMenu extends Activity implements OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_menu);
    Button butPlay = (Button) (findViewById(R.id.btn_play));
    Button butSettings = (Button) (findViewById(R.id.btn_settings));
    Button butExit = (Button) (findViewById(R.id.btn_exit));
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
      initiatePopupWindow();
      break;
    case R.id.btn_exit:
      System.exit(0);
      break;
    default:
      break;
    }
  }

  private void initiatePopupWindow() {
    try {
      LayoutInflater inflater = (LayoutInflater) MainMenu.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      View layout = inflater.inflate(R.layout.popup, (ViewGroup) findViewById(R.id.popup_element11));
      final PopupWindow popupWindow = new PopupWindow(layout, 350, 350, true);
      popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);
      final CheckBox checkBoxMute = (CheckBox) layout.findViewById(R.id.chkbox_mute);
      Button btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
      btnClosePopup.setOnClickListener(new OnClickListener() {
        @Override public void onClick(View v) {
          savePreferences("CHECKBOX", checkBoxMute.isChecked());
          popupWindow.dismiss();
        }
      });
      loadSavedPreferences(checkBoxMute);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void loadSavedPreferences(CheckBox checkBoxMute) {
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
    checkBoxMute.setChecked(sp.getBoolean("CHECKBOX", true));
  }

  private void savePreferences(String key, boolean value) {
    SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
    Editor edit = sp.edit();
    edit.putBoolean(key, value);
    edit.commit();
  }
}
