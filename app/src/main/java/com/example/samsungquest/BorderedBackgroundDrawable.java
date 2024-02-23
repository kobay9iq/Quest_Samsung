package com.example.samsungquest;

import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

public class BorderedBackgroundDrawable extends ShapeDrawable {
  public BorderedBackgroundDrawable(float cornerRadius, int borderWidth, int borderColor, int fillColor) {
    super(new RoundRectShape(new float[]{cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius, cornerRadius}, null, null));
    Paint paint = getPaint();
    paint.setColor(fillColor);
    paint.setStyle(Paint.Style.FILL_AND_STROKE);
    paint.setStrokeWidth(borderWidth);
    paint.setColor(borderColor);
  }
}

