package com.example.samsungquest;

import java.io.Serializable;

public class Player implements Serializable {
  private final String name;
  private int gold = 4;
  private int reputation = 2;
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
    gold += stats[0];
    reputation += stats[1];
    population += stats[3];
  }
}
