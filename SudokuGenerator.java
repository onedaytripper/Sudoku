import java.util.Random;

public class SudokuGenerator {

    public int[][] generate(int size) {
        int[][] grid = new int[size][size];
        Random rand = new Random();

        for (int i = 0; i < 9; i++) {
            int row = rand.nextInt(9), col = rand.nextInt(9);
            grid[row][col] = i;
        }
        return grid;
    }
}
