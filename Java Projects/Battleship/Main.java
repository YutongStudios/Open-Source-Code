import java.util.Scanner;
import java.util.Random;

public class Main {
  static final int GRID_SIZE = 10;
  static final int NUM_SHIPS = 5;
  static char[][] grid = new char[GRID_SIZE][GRID_SIZE];
  static Scanner sc = new Scanner(System.in);
  static Random rnd = new Random();
  static int shotsTaken = 0;
  static int shipsSunk = 0;

  public static void main(String[] args) {
    initGrid();
    placeShips();
    playGame();
  }

  static void initGrid() {
    // Initialize grid with water
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        grid[i][j] = 'w';
      }
    }
  }

  static void placeShips() {
    // Place ships on the grid
    int shipLength = 2;
    for (int i = 0; i < NUM_SHIPS; i++) {
      boolean shipPlaced = false;
      while (!shipPlaced) {
        int row = rnd.nextInt(GRID_SIZE);
        int col = rnd.nextInt(GRID_SIZE);
        int direction = rnd.nextInt(2);
        if (direction == 0) { // horizontal
          if (col + shipLength <= GRID_SIZE) {
            shipPlaced = true;
            for (int j = col; j < col + shipLength; j++) {
              grid[row][j] = 's';
            }
          }
        } else { // Vertical
          if (row + shipLength <= GRID_SIZE) {
            shipPlaced = true;
            for (int j = row; j < row + shipLength; j++) {
              grid[j][col] = 's';
            }
          }
        }
      }
      shipLength++;
    }
  }

  static void playGame() {
    // Play the game
    while (shipsSunk < NUM_SHIPS) {
      System.out.print("Enter row: ");
      int row = sc.nextInt();
      System.out.print("Enter column: ");
      int col = sc.nextInt();
      if (grid[row][col] == 's') {
        System.out.println("You hit a ship!");
        grid[row][col] = 'x';
        checkIfSunk(row, col);
      } else {
        System.out.println("You missed.");
      }
      shotsTaken++;
    }
    System.out.println("You sank all ships in " + shotsTaken + " shots.");
  }

  static void checkIfSunk(int row, int col) {
    // Check if ship has sunk
    int shipLength = 1;
    boolean shipSunk = true;
    for (int i = row - 1; i <= row + 1; i++) {
      for (int j = col - 1; j <= col + 1; j++) {
        if (i >= 0 && i < GRID_SIZE && j >= 0 && j < GRID_SIZE && grid[i][j] == 's') {
          shipLength++;
          shipSunk = false;
        }
      }
    }
    if (shipSunk) {
      shipsSunk++;
      System.out.println("You sunk a ship of length " + shipLength + "!");
    }
  }
}
