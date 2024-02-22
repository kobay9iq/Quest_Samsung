package com.example.samsungquest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.samsungquest.databinding.ActivityEndingBinding;

public class EndingActivity extends AppCompatActivity {
  private Player player;
  private ActivityEndingBinding binding;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityEndingBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    player = (Player) getIntent().getSerializableExtra("playerInstance");

  }
}
