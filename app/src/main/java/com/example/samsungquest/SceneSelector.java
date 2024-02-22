package com.example.samsungquest;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
Создает n-ое рандомных количество сцен из пула, возвращает в GameContoller коллекцию с ними
*/

public class SceneSelector {
  private static final Integer SCENESINPOOL = 20;
  public static void createRandomScenes(GameScene[] scenes, Context context) throws FileNotFoundException {
    Random random = new Random();
    Resources resources = context.getResources();
    String packageName = context.getPackageName();
    String json = JsonReader.readJsomFromAssets(context,"scenes.json");

    for (int i = 0; i < scenes.length; i++) {
      int sceneNum = random.nextInt(SCENESINPOOL - 1);
      int[][] choices;
      String[] strings;
      Drawable drawable;


      int drawId = resources.getIdentifier("scene" + (sceneNum + 1), "drawable", packageName);
      // возможно, надо добавить "@strings/"
      // и поменять "array" на "strings" (или перетащить массивы строк в arrays.xml)
      int strId = resources.getIdentifier( "scene" + (sceneNum+1), "array", packageName);

      if (strId != 0 && drawId != 0 && json != null) {
        drawable = ResourcesCompat.getDrawable(resources, drawId, null);
        strings = resources.getStringArray(strId);
        choices = JsonReader.processJsonString(json, sceneNum);
      } else {
        throw new FileNotFoundException(String.format("Reading error. StrID:%d. drawID:%d.", strId, drawId));
      }

      scenes[i] = new GameScene(drawable, strings, choices[0], choices[1]);
    }
  }
}
