package org.example;

import org.example.exceptions.IncorrectMenuOptionException;
import org.example.tools.Entry;

public class GamesManager {

    private final InventoryManager inventoryManager = new InventoryManager();

    public void initiate() {
        boolean close = false;
        int selectedMenuOption = -1;

        do {
            try {
                selectedMenuOption = menu();
            } catch (IncorrectMenuOptionException e) {
                System.out.println(e.getMessage());
            }

            switch (selectedMenuOption) {
                case 1:
                    inventoryManager.createNewGame();
                    break;
                case 2:
                    inventoryManager.updateInventoryForGame();
                    break;
                case 3:
                    inventoryManager.showAvailableGames();
                    break;
                case 4:
                    inventoryManager.searchForGameName();
                    break;
                case 5:
                    inventoryManager.removeGameFromInventory();
                    break;
                case 6:
                    inventoryManager.filterGameByCategory();
                    break;
                case 7:
                    inventoryManager.filterGameByDifficulty();
                    break;
                case 0:
                    close = true;
                    break;
                default: break;
            }
        } while (!close);
    }

    public int menu() throws IncorrectMenuOptionException {
        System.out.println(
                "Menú:" +
                        "\n1.- Crear un nuevo juego de mesa y añadirlo al inventario. " +
                        "\n2.- Actualizar la cantidad disponible de un juego en el inventario. " +
                        "\n3.- Mostrar todos los juegos disponibles, incluyendo el precio final con IVA." +
                        "\n4.- Buscar un juego específico por su nombre. " +
                        "\n5.- Eliminar un juego del inventario. " +
                        "\n6.- Filtrar juegos según su categoría." +
                        "\n7 - Filtrar juego según su dificultad. " +
                        "\n0.- Salir."
        );

        int menuOption = Entry.readInt("Select a menu option between 0 and 7");
        if (menuOption < 0 || menuOption > 7) throw new IncorrectMenuOptionException("Menu option should be between 0 and 7.");
        else return menuOption;
    }
}
