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
        // Fills in the rest of the grid
        SudokuSolver solver = new SudokuSolver();
        solver.solve(grid);
        dig(grid, 10);
        return grid;
    }

    /* Removes numbers from cells at random while maintaining a single unique solution.
    *  The number of cells cleared indicates the difficulty of the puzzle. */
    private void dig(int[][] grid, int num) {
        int removed = 0, row, col;
        Random random = new Random();
        while (removed < num) {
            row = random.nextInt(grid.length);
            col = random.nextInt(grid.length);
            // Attempts to remove a digit from a random cell
            if (grid[row][col] != 0) {
                int current;
                current = grid[row][col];
                // Checks for multiple solutions
                if (solve(copyGrid(grid)).size() == 1) {
                    grid[row][col] = 0;
                    removed++;
                } else {
                    grid[row][col] = current;
                }
            }
        }
    }
}