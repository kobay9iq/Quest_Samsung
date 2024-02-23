package com.example.samsungquest;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.samsungquest.databinding.ActivityEndingBinding;
import java.io.IOException;

public class EndingActivity extends AppCompatActivity {
  private Player player;
  private ActivityEndingBinding binding;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityEndingBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    player = (Player) getIntent().getSerializableExtra("playerInstance");

    String endingAppeal = (String) binding.textViewTop.getText();
    endingAppeal = endingAppeal.replace("|", player.getName());
    binding.textViewTop.setText(endingAppeal);

    EndingSelector endingSelector = null;
    try {
      endingSelector = new EndingSelector(player.getStats(), this);
    } catch (IOException e) {
      Toast.makeText(this, "Something went wrong" + e, Toast.LENGTH_SHORT).show();
      Log.e("Ending activity",e.getMessage());
      finish();
    }

    Drawable pic = endingSelector.getPic();
    String str = endingSelector.getStr();

    binding.imageView.setImageDrawable(pic);
    binding.textView.setText(str);

    binding.buttonMainMenu.setOnClickListener(v -> {
      Intent intent = new Intent(this, MainMenuActivity.class);
      startActivity(intent);
    });
  }
}
