package com.example.samsungquest;

import java.io.Serializable;

public class Player implements Serializable {
  private final String name;
  private int gold = 5;
  private int reputation = 5;
  private int population = 5;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int[] getStats() {
    int[] stats = {gold, reputation, population};
    return stats;
  }

  public void changeStats(int[] stats) {
    int[] tempStats = {gold, reputation, population};

    for (int i = 0; i != tempStats.length; i++) {
      if (stats[i] + tempStats[i] <= 0) {
        tempStats[i] = 0;
      } else if (stats[i] + tempStats[i] > 10) {
        tempStats[i] = 10;
      } else if (stats[i] + tempStats[i] <= 10) {
        tempStats[i] += stats[i];
        }
      }

    gold = tempStats[0];
    reputation = tempStats[1];
    population = tempStats[2];
  }
}
