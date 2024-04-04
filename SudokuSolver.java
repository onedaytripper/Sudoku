import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    /* Returns a list of all possible valid solutions to the puzzle. */
    public List<int[][]> solve(int[][] grid) {
        List<int[][]> solutions = new ArrayList<>();
        this.solve(grid, solutions);
        return solutions;
    }

    /* Solves for the missing values using recursive backtracking and constraint propagation */
    private boolean solve(int[][] grid, List<int[][]> solutions) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(grid, i, j, num)) {
                            grid[i][j] = num;
                            if (solve(grid, solutions)) {
                                return true;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        int[][] solution = this.copyGrid(grid);
        solutions.add(solution);
        return true;
    }

    /* Determines if a number can be safely placed in a certain cell. */
    public boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int i = 0; i < grid.length; i++) {
            // Check row
            if (grid[row][i] == num) {
                return false;
            }
            // Check column
            if (grid[i][col] == num) {
                return false;
            }
        }
        // Check box
        int boxSize = (int) Math.sqrt(grid.length);
        int boxRow = row - row % boxSize, boxCol = col - col % boxSize;
        for (int i = 0; i < boxSize; i++) {
            for (int j = 0; j < boxSize; j++) {
                if (grid[i + boxRow][j + boxCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    /* Returns a copy of the current configuration of the grid. */
    public int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][grid.length];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, 9);
        }
        return copy;
    }
}