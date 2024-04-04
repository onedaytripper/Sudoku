public class SudokuSolver {

    public int[][] getSolution(int[][] grid) {
        solve(grid);
        return grid;
    }

    private boolean solve(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    for (int num = 1; num < 10; num++) {
                        if (isSafe(grid, i, j, num)) {
                            grid[i][j] = num;
                            if (solve(grid)) {
                                return true;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int[][] grid, int row, int col, int num) {
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
}