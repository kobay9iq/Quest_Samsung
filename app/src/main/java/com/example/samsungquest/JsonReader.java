package com.example.samsungquest;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {
  public static int[][] processJsonString(String json, int id) throws FileNotFoundException {
    try{
      JSONObject jsonObject = new JSONObject(json);
      JSONArray scenesArray = jsonObject.getJSONArray("scenes");
      JSONObject sceneObject = scenesArray.getJSONObject(id);

      JSONArray firstChoiceArray = sceneObject.getJSONArray("firstChoice");
      JSONArray secondChoiceArray = sceneObject.getJSONArray("secondChoice");

      int[][] choices = new int[2][firstChoiceArray.length()];

      for (int i = 0; i != firstChoiceArray.length(); i++) {
        choices[0][i] = firstChoiceArray.getInt(i);
      }
      for (int i = 0; i != secondChoiceArray.length(); i++) {
        choices[1][i] = secondChoiceArray.getInt(i);
      }

      return choices;
    } catch (JSONException e) {
      Log.e("JSON_ERROR", e.getMessage());
      throw new FileNotFoundException("JSON process error");
    }
  }

  public static String readJsomFromAssets(Context context, String fileName)
      throws FileNotFoundException {
    String json;
    try {
      AssetManager assetManager = context.getAssets();

      InputStream inputStream = assetManager.open(fileName);

      int size = inputStream.available();
      byte[] buffer = new byte[size];
      inputStream.read(buffer);
      inputStream.close();
      json = new String(buffer, StandardCharsets.UTF_8);

    } catch (IOException e) {
      throw new FileNotFoundException("JSON open error");
    }
    return json;
  }
}
