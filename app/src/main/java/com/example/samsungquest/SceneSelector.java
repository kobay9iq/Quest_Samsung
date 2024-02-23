package com.example.samsungquest;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;


/*
Создает n-ое рандомных количество сцен из пула, возвращает в GameContoller коллекцию с ними
*/

public class SceneSelector {
  private static final Integer SCENESINPOOL = 20;
  public static void createRandomScenes(GameScene[] scenes, Context context) throws IOException {
    Random random = new Random();
    Resources resources = context.getResources();
    String packageName = context.getPackageName();
    String json = JsonReader.readJsomFromAssets(context,"scenes.json");

    for (int i = 0; i < scenes.length; i++) {
      // TODO: сделать защиту от повтора сцен
      int sceneNum = random.nextInt(SCENESINPOOL - 1);
      int[][] choices;
      String[] strings;

      String path = "scenesPic/scene" + (sceneNum + 1) + ".jpeg";
      Drawable drawable = Util.getPicFromAssets(path, context);


      // int drawId = resources.getIdentifier("scene" + (sceneNum + 1), "drawable", packageName);

      // возможно, надо добавить "@strings/"
      // и поменять "array" на "strings" (или перетащить массивы строк в arrays.xml)
      int strId = resources.getIdentifier( "scene" + (sceneNum+1), "array", packageName);

      if (strId != 0 && json != null) {
        strings = resources.getStringArray(strId);
        choices = JsonReader.processJsonString(json, sceneNum);
      } else {
        throw new FileNotFoundException("Reading error. StrID:" + strId);
      }

      scenes[i] = new GameScene(drawable, strings, choices[0], choices[1], context);
    }
  }
}
