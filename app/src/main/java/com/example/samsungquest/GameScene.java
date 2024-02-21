package com.example.samsungquest;

import android.graphics.drawable.Drawable;

public class GameScene {
  private final Drawable picture;
  private final String description;
  private final String choice1Str;
  private final int[] choice1Effects;
  private final String choice2Str;
  private final int[] choice2Effects;

  public GameScene(Drawable picture, String[] strings, int[] choice1Effects, int[] choice2Effects) {
    this.picture = picture;
    this.description = strings[0];
    this.choice1Str = strings[1];
    this.choice2Str = strings[2];
    this.choice1Effects = choice1Effects;
    this.choice2Effects = choice2Effects;
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
