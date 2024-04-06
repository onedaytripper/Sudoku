public class Sudoku {

    /* Confirms that the current grid represents a valid solution. */
    public boolean isValid(int[][] grid) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    /* Returns a copy of the current grid. */
    public int[][] copyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                copy[i][j] = grid[i][j];
            }
        }
        return copy;
    }

    /* Prints the current grid. */
    public static void printGrid(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("---------------------");
            }
            for (int col = 0; col < grid.length; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}