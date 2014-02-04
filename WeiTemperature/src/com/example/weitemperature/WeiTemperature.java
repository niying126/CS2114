package com.example.weitemperature;

import android.widget.Button;
import android.widget.EditText;
import sofia.app.Screen;

public class WeiTemperature
    extends Screen
{

   private EditText temp;
   private Button clear;

   public void initialize()
   {
       temp.setText("12");
   }

   public void clearClicked()
   {
       temp.setText("");
   }

}
