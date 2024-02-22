package com.example.samsungquest;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.samsungquest.databinding.ActivityMainmenuBinding;

public class MainMenuActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityMainmenuBinding binding = ActivityMainmenuBinding.inflate(getLayoutInflater());
    // setContentView(R.layout.activity_mainmenu);
    setContentView(binding.getRoot());

    binding.buttonStartGame.setOnClickListener(
        v -> {
          String heroName = binding.editTextHeroName.getText().toString();
          if (heroName.isEmpty()) {
            Toast.makeText(this, R.string.emptyNameError, Toast.LENGTH_SHORT).show();
          } else {
            String playerName = binding.editTextHeroName.getText().toString();

            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("playerName", playerName);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
          }
        });
  }
}