package com.example.samsungquest;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.samsungquest.databinding.ActivityGameBinding;
import java.io.FileNotFoundException;
import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
  private final int SCENESNUM = 10;
  private GameController gameController;
  private ActivityGameBinding binding;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityGameBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    String playerName = getIntent().getStringExtra("playerName");
    try {
      gameController = new GameController(playerName, SCENESNUM, this);
    } catch (FileNotFoundException e) {
      Toast.makeText(this, "Something went wrong" + e, Toast.LENGTH_SHORT).show();
      Log.e("Game activity",e.getMessage());
      finish();
    }

    GameScene firstScene = gameController.getFirstScene();
    int[] playerStat = gameController.changePlayerStats(0);

    drawNewScene(firstScene, playerStat);
  }

  @Override
  protected void onStart() {
  super.onStart();
  try {
    binding.button1.setOnClickListener(this);
  } catch (ArrayIndexOutOfBoundsException e) {
    Log.e("Game activity", "ArrayIndexOutOfBoundsException");
    Toast.makeText(this, "Something went wrong" + e, Toast.LENGTH_SHORT).show();
    finish();
  } catch (RuntimeException e) {
    Log.e("Game activity", e.getMessage());
    Toast.makeText(this, "Something went wrong" + e, Toast.LENGTH_SHORT).show();
    finish();
  }
  }

  private void drawNewScene(GameScene scene, int[] playerStat) {
    binding.button1.setText(scene.getChoice1Str());
    binding.button2.setText(scene.getChoice2Str());
    binding.sceneImage.setImageDrawable(scene.getPicture());
    binding.sceneText.setText(scene.getDescription());

    binding.goldIndicator.setText(getString(R.string.goldIndicator) + playerStat[0]);
    binding.reputationIndicator.setText(getString(R.string.reputationIndicator) + playerStat[1]);
    binding.populationIndicator.setText(getString(R.string.populationIndicator) + playerStat[2]);
  }
  @Override
  public void onClick(View v) {
    int[] playerStat;
    if (v.getId() == R.id.button_1) {
        playerStat = gameController.changePlayerStats(1);
    } else if (v.getId() == R.id.button_2) {
        playerStat = gameController.changePlayerStats(2);
    } else {
      playerStat = new int[]{0, 0, 0};
      throw new RuntimeException("onClickError");
    }

    GameScene scene = gameController.changeScene();
    if (scene != null) {
      drawNewScene(scene, playerStat);
    } else {
      startActivity(gameController.startEnding(this));
    }
  }
}
