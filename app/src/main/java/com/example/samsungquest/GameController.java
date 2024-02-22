package com.example.samsungquest;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import java.io.FileNotFoundException;

public class GameController {
  private Player player;
  private GameScene[] scenes;
  private int currentScene;

  public GameController(String playerName, int numOfScenes, Context context)
      throws FileNotFoundException {
    player = new Player(playerName);
    scenes = new GameScene[numOfScenes];
    SceneSelector.createRandomScenes(scenes, context);
  }

  public GameScene getFirstScene() {
    return scenes[0];
  }

  public int[] changePlayerStats(int choice) {
    // TODO: Проигрыш при макс/мин стате
    int[] statsChange;
    if (choice == 1) {
      statsChange = scenes[currentScene].getChoice1Effects();
    } else if (choice == 2) {
      statsChange = scenes[currentScene].getChoice2Effects();
    } else {
      statsChange = new int[]{0, 0, 0};
    }

    player.changeStats(statsChange);
    return player.getStats();
  }

  public GameScene changeScene() {
    try{
      currentScene++;

      boolean isLose = false;
      for (int stat : player.getStats()) {
        if (stat >= 10 || stat <= 0) {
          isLose = true;
        }
      }

      if (currentScene == 10 && isLose) {
        return null;
      }
      return scenes[currentScene];
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public Intent startEnding(Context context) {
    Intent intent = new Intent(context, EndingActivity.class);
    intent.putExtra("playerInstance", player);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    return intent;
  }


}
