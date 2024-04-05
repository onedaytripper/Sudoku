import java.util.Random;

// TODO: Create bounds for empty cells in row, col, box in playable grid
public class SudokuGenerator extends SudokuSolver {

    /* Generates a playable sudoku of the desired difficulty. */
    public int[][] generate(int size, int difficulty) {
        int[][] grid = new int[size][size];
        solve(grid);

        int[] min = {26, 32, 46, 50, 54};
        int[] max = {31, 45, 49, 53, 59};

        Random rand = new Random();
        int targets = 1 + rand.nextInt(max[difficulty] - min[difficulty]) + min[difficulty];
        dig(grid, targets);
        return grid;
    }

    /* Removes numbers from cells while maintaining a unique solution. */
    private void dig(int[][] grid, int targets) {
        int holes = 0, row, col, current;
        Random random = new Random();
        while (holes < targets) {
            row = random.nextInt(grid.length);
            col = random.nextInt(grid.length);

            // Pass over empty cells
            if (grid[row][col] != 0) {
                current = grid[row][col];
                // Try each number in empty cell
                for (int num = 0; num < grid.length; num++) {
                    // Skip the current number
                    if (num != current) {
                        grid[row][col] = num;
                        // If a solution exists with this num, reject num
                        if (solve(copyGrid(grid))) { // TODO: Make this if grid has multiple solutions
                            grid[row][col] = 0;
                            holes++;
                            break;
                        }
                        grid[row][col] = current;
                    }
                }
            }
        }
    }
}