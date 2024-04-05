public class Main extends SudokuGenerator {

    public static void main(String[] args) {
        // 0 = extremely easy, 1 = easy, 2 = medium, 3, = difficult, 4 = impossible
        int[][] grid;
        SudokuGenerator generator = new SudokuGenerator();
        SudokuSolver solver = new SudokuSolver();
        grid = generator.generate(9, 4);
        //grid = empty();
        //solver.solve(grid);
        printGrid(grid);
        count(grid);

    }

    public static int[][] multipleSolutions() {
        return new int[][] {{0, 8, 0, 0, 0, 9, 7, 4, 3}, {0, 5, 0, 0, 0, 8, 0, 1, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0},
                            {8, 0, 0, 0, 0, 5, 0, 0, 0}, {0, 0, 0, 8, 0, 4, 0, 0, 0}, {0, 0, 0, 3, 0, 0, 0, 0, 6},
                            {0, 0, 0, 0, 0, 0, 0, 7, 0}, {0, 3, 0, 5, 0, 0, 0, 8, 0}, {9, 7, 2, 4, 0, 0, 0, 5, 0}};
    }

    public static int[][] empty() {
        return new int[][] {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}};
    }

    public static int[][] hardest() {
        return new int[][] {{8, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 3, 6, 0, 0, 0, 0, 0}, {0, 7, 0, 0, 9, 0, 2, 0, 0},
                            {0, 5, 0, 0, 0, 7, 0, 0, 0}, {0, 0, 0, 0, 4, 5, 7, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 3, 0},
                            {0, 0, 1, 0, 0, 0, 0, 6, 8}, {0, 0, 8, 5, 0, 0, 0, 1, 0}, {0, 9, 0, 0, 0, 0, 4, 0, 0}};
    }

    public static void count(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println("This grid has " + count + " digits missing.");
    }
}