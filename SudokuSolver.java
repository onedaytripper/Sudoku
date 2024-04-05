import java.util.Random;

public class SudokuSolver extends Sudoku {

    /* Backtracking algorithm to solve for missing values. */
    public boolean solve(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                    randomize(nums); // Avoids sequences of numbers in solution
                    for (int n = 0; n < nums.length; n++) {
                        if (isSafe(grid, i, j, nums[n])) { // Attempt to place each number
                            grid[i][j] = nums[n];
                            // If a valid solution exists, continue searching
                            if (this.solve(grid)) {
                                return true;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    return false; // No more solutions are possible
                }
            }
        }
        return true;
    }

    /* Determines if a number can be safely placed in a certain cell. */
    public boolean isSafe(int[][] grid, int row, int col, int num) {
        // Check row, column
        for (int i = 0; i < grid.length; i++) {
            if (grid[row][i] == num) return false;
            if (grid[i][col] == num) return false;
        }
        // Check box
        int boxSize = (int) Math.sqrt(grid.length);
        int boxRow = row - row % boxSize, boxCol = col - col % boxSize;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (grid[i + boxRow][j + boxCol] == num) return false;
            }
        }
        return true;
    }

    /* Randomizes order of elements in array using Fisher-Yates shuffle. */
    private void randomize(int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }
}