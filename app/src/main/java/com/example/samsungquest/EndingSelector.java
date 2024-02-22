package com.example.samsungquest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;

public class EndingSelector {
  private int endID;
  private Context context;

  public EndingSelector(int[] stats, Context context) {
    this.context = context;
    int gold = stats[0];
    int rep = stats[1];
    int population = stats[2];

    if (gold >= 10) {
      endID = 1;
    } else if (rep >= 10) {
      endID = 2;
    } else if (population >= 10) {
      endID = 3;
    } else if (gold == 0) {
      endID = 4;
    } else if (rep == 0) {
      endID = 5;
    } else if (population == 0) {
      endID = 6;
    } else {
      endID = 7;
    }
  }

  public Drawable getPic() {
    int drawId = context.getResources().getIdentifier(
         "end" + (endID), "drawable", context.getPackageName());
    Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), drawId, null);
    return drawable;
  }

  public String getStr() {
    return context.getResources().getStringArray(R.array.ends)[endID-1];
  }
}
