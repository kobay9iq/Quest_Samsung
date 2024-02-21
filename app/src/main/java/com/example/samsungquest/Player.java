package com.example.samsungquest;

public class Player {
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

  public int getGold() {
    return gold;
  }

  public void changeGold(int amount) {
    this.gold += amount;
  }

  public int getReputation() {
    return reputation;
  }

  public void changeReputation(int amount) {
    this.reputation += amount;
  }

  public int getPopulation() {
    return population;
  }

  public void changePopulation(int amount) {
    this.population += amount;
  }
}
