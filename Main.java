public class Main {

    public static void main(String[] args) {
        SudokuGenerator generator = new SudokuGenerator();
        SudokuSolver solver = new SudokuSolver();
        int[][] grid = generator.generate(9, 10);
        printGrid(grid);

        //printGrid(solver.getSolution(grid));
    }

    public static void printGrid(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}
