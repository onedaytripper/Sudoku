import java.util.Random;

public class SudokuGenerator extends SudokuSolver {

    /* Generates a random sudoku board. */
    public int[][] generate(int size, int n) {
        int[][] grid = new int[size][size];
        int value = 0;

        // Puts a random number 1 - 9 in each box to help randomize solution
        for (int i = 0; i < size; i = i + (int) Math.sqrt(size)) {
            for (int j = 1; j < size; j = j + (int) Math.sqrt(size)) {
                while (!isSafe(grid, i, j, value)) {
                    value = 1 + (int)(Math.random() * ((9 - 1) + 1));
                }
                grid[i][j] = value;
            }
        }
        // Fill in the rest of the grid
        grid = this.getSolution(grid);

        int removed = 0;
        Random random = new Random();
        while (removed != n) {
            grid[random.nextInt(grid.length)][random.nextInt(grid.length)] = 0;

        }

        return grid;
    }
}
