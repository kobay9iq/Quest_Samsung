package com.example.samsungquest;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class GameScene {
  private final Drawable picture;
  private final String description;
  private final String choice1Str;
  private final int[] choice1Effects;
  private final String choice2Str;
  private final int[] choice2Effects;
  private final Context context;

  public GameScene(Drawable picture, String[] strings, int[] choice1Effects, int[] choice2Effects, Context context) {
    this.picture = picture;
    this.context = context;
    this.description = strings[0];
    this.choice1Effects = choice1Effects;
    this.choice2Effects = choice2Effects;
    this.choice1Str = addEffectsToStr(strings[1], choice1Effects);
    this.choice2Str = addEffectsToStr(strings[2], choice2Effects);
  }

  private String addEffectsToStr(String str, int[] choiceEffects) {
    String newStr = str;
    for (int i = 0; i != choiceEffects.length; i++) {
      if (choiceEffects[i] != 0) {
        switch (i) {
          case 0:
            newStr += context.getString(R.string.goldStr) + choiceEffects[i];
            break;
          case 1:
            newStr += context.getString(R.string.repStr) + choiceEffects[i];
            break;
          case 2:
            newStr += context.getString(R.string.popStr) + choiceEffects[i];
            break;
          default:
            newStr += String.format("\n?: %d", choiceEffects[i]);
            break;
        }
      }
    }
    return newStr;
  }

  public Drawable getPicture() {
    return picture;
  }

  public String getDescription() {
    return description;
  }

  public String getChoice1Str() {
    return choice1Str;
  }

  public int[] getChoice1Effects() {
    return choice1Effects;
  }

  public String getChoice2Str() {
    return choice2Str;
  }

  public int[] getChoice2Effects() {
    return choice2Effects;
  }
}
