import java.util.Random;

public class Sudoku {
    private final int[][] grid;
    private final int size;
    int m;

    public Sudoku (int s) {
        if (s % 3 != 0) {
            System.out.println("Error.");
            System.exit(0);
        }

        size = s;
        // this.m = m;

        grid = new int[s][s];
        fillBoard();
    }

    public int getSize() {
        return size;
    }

    public void fillBoard() {
        int n = 0;
        for (int i = 0; i < grid.length / 3; i++) {
            fillBox(n);
            n += 3;
        }
    }

    // Randomly generates 3x3 grids until an eligible one is found
    public void fillBox(int n) {
        while (!boxCheck(n)) {
            for (int r = n; r < n + 3; r++) {
                for (int c = n; c < n + 3; c++) {
                    grid[r][c] = getRandom();
                }
            }
        }
    }

    public boolean boardCheck() {
        for (int i = 0; i < 9; i++) {
            if (rowCheck(i) && colCheck(i) && boxCheck(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean rowCheck(int n) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                if (grid[r][c] == n) {
                    count++;
                }
            }
            if (count != 1) return false;
        }
        return true;
    }

    public boolean colCheck(int n) {
        int count = 0;
        for (int c = 0; c < grid.length; c++) {
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] == n) {
                    count++;
                }
            }
            if (count != 1) return false;
        }
        return (count == 1);
    }

    public boolean boxCheck(int i) {
        int count = 0;
        int[][] box = new int[3][3];

        for (int n = 0; n < grid.length; n++) {
            for (int r = i; r < i + 3; r++) {
                for (int c = i; c < i + 3; c++) {
                    box[r][c] = grid[r][c];
                    if (box[r][c] == n) {
                        count++;
                    }
                }
            }
            if (count != 1) return false;
        }
        return true;
    }

    public int getRandom() {
        Random r = new Random();
        return r.nextInt(10);
    }
}
