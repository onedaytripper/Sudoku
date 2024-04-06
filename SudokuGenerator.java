import java.util.Random;

// TODO: Create bounds for empty cells in row, col, box in playable grid
// TODO: Fix - generates grids with multiple solutions
public class SudokuGenerator extends SudokuSolver {

    /* Generates a playable sudoku of the desired difficulty. */
    public int[][] generate(int n) {
        int size = 9;
        Random rand = new Random();
        int[][] grid = new int[size][size];
        int[] min = {26, 32, 46, 50, 54};
        int[] max = {31, 45, 49, 53, 59};
        int targets = 1 + rand.nextInt(max[n] - min[n]) + min[n];

        solve(grid);
        dig(grid, targets);
        return grid;
    }

    /* Removes digits from cells at random. */
    private void dig(int[][] grid, int targets) {
        Random random = new Random();
        int holes = 0, row, col;
        while (holes < targets) {
            row = random.nextInt(grid.length);
            col = random.nextInt(grid.length);

            if (grid[row][col] != 0) {
                grid[row][col] = 0;
                holes++;
            }
        }
    }

    /* Checks if removing a digit creates a grid with multiple solutions. */
    public boolean canBeDug(int[][] grid, int row, int col) {
        throw new UnsupportedOperationException("Not implemented.");
    }
}