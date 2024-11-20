package org.example;

import org.example.categories.Category;
import org.example.exceptions.GameNotFoundException;
import org.example.exceptions.IncorrectNameException;
import org.example.models.BoardGame;
import org.example.models.DifficultyLevel;
import org.example.tools.Entry;

import java.util.HashSet;
import java.util.Optional;

public class InventoryManager {

    private final HashSet<BoardGame> gamesInventory = new HashSet<>();

    public void createNewGame() {
        try {
            String name = readName();
            Optional<BoardGame> result = gamesInventory.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
            if (result.isPresent()) {
                System.out.println("Game already exists: " + result.get());
                return;
            }
            double price = readPrice();
            DifficultyLevel difficultyLevel = readDifficultyLevel();
            Category category = readCategory();
            int stock = readStock();
            createNewGame(new BoardGame(name, price, difficultyLevel, category, stock));
        } catch (IncorrectNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewGame(BoardGame game) {
        gamesInventory.add(game);
    }

    public void updateInventoryForGame() {
        try {
            String name = readName();
            BoardGame boardGame = searchForGameName(name);
            System.out.println(boardGame);
            int newStock = readStock();
            boardGame.setStock(newStock);
        } catch (IncorrectNameException | GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public BoardGame[] getAvailableGames() {
        return gamesInventory.toArray(new BoardGame[gamesInventory.size()]);
    }

    public void showAvailableGames() {
        gamesInventory.forEach(System.out::println);
    }

    public void searchForGameName() {
        try {
            String name = readName();
            BoardGame boardGame = searchForGameName(name);
            System.out.println(boardGame);
        } catch (IncorrectNameException | GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeGameFromInventory() {
        try {
            String name = readName();
            BoardGame boardGame = searchForGameName(name);
            gamesInventory.remove(boardGame);
        } catch (IncorrectNameException | GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void filterGameByCategory() {
        Category category = readCategory();
        gamesInventory.stream().filter(x -> x.getCategory() .equals(category)).forEach(System.out::println);
    }

    public void filterGameByDifficulty() {
        DifficultyLevel difficultyLevel = readDifficultyLevel();
        gamesInventory.stream().filter(x -> x.getDifficultyLevel() == difficultyLevel).forEach(System.out::println);
    }

    private BoardGame searchForGameName(String name) throws GameNotFoundException {
        Optional<BoardGame> result = gamesInventory.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
        if (result.isEmpty()) throw new GameNotFoundException("Game name not found inside inventory");
        return result.get();
    }

    private String readName() throws IncorrectNameException {
        String gameName = Entry.readString("Enter the board game name:");
        if (gameName.length() < 3) {
            throw new IncorrectNameException("Incorrect name, it is too short.");
        } else {
            return gameName;
        }
    }

    private double readPrice() {
        return Entry.readDouble("Enter price for game:");
    }

    private int readStock() {
        return Entry.readInt("Enter stock number:");
    }

    private Category readCategory() {
        return Entry.readCategory("Enter a valid category (rol/chance/strategy)");
    }

    private DifficultyLevel readDifficultyLevel() {
        return Entry.readDifficulty("Enter a valid difficulty level (low/medium/hard)");
    }
}
