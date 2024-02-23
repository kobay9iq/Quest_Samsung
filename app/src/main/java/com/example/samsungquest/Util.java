package com.example.samsungquest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.IOException;

public class Util {
  public static Drawable getPicFromAssets(String path, Context context) throws IOException {
    return Drawable.createFromStream(context.getAssets().open(path), null);
  }
}
