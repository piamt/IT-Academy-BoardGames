package org.example.models;

import org.example.categories.Category;

import java.util.Objects;
import java.util.UUID;

public class BoardGame {
    private String id;
    private String name;
    private double price;
    private DifficultyLevel difficultyLevel;
    private Category category;
    private int stock;

    public BoardGame(String name, double price, DifficultyLevel difficultyLevel, Category category, int stock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.difficultyLevel = difficultyLevel;
        this.category = category;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public double getFinalPrice() {
        return price * 1.10; // TODO: Round to 2 decimals
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public Category getCategory() {
        return category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return Objects.equals(name, boardGame.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", price with IVA=" + String.format("%.2f", getFinalPrice()) +
                ", stock='" + stock + '\'' +
                ", category='" + category.getName() + '\'' +
                ", difficulty='" + difficultyLevel.toString().toLowerCase() + '\'' +
                '}';
    }
}