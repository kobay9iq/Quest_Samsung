package com.example.samsungquest;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainMenuActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mainmenu);

    Button startButton = findViewById(R.id.button_start_game);
    EditText editText = findViewById(R.id.editText_hero_name);

    startButton.setOnClickListener(
        v -> {
          String heroName = editText.getText().toString();
          if (heroName.isEmpty()) {
            Toast.makeText(this, R.string.emptyNameError, Toast.LENGTH_SHORT).show();
          } else {
            String playerName = editText.getText().toString();

          }
        });
  }
}