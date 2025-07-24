import java.util.*;

public class NineByNinePuzzle {
    static class Cell {
        int row, col;
        int value;  // Current value (1-9)
        boolean isPrefilled;
        boolean isHint;
        boolean isTinaFilled;
        Cell(int row, int col, int value, boolean isPrefilled, boolean isHint, boolean isTinaFilled) {
            this.row = row;
            this.col = col;
            this.value = value;
            this.isPrefilled = isPrefilled;
            this.isHint = isHint;
            this.isTinaFilled = isTinaFilled;
        }
    }

    static int[][] grid = new int[9][9];
    static Cell[][] cells = new Cell[9][9];
    static List<Integer> hintList = new ArrayList<>();
    static int minChanges = Integer.MAX_VALUE;
    static List<int[]> minChangedCells = new ArrayList<>();
    static List<Cell> modifiable = new ArrayList<>();
    static int K;

    // Sudoku check helpers
    static boolean[][] rowUsed = new boolean[9][10];
    static boolean[][] colUsed = new boolean[9][10];
    static boolean[][] boxUsed = new boolean[9][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Parse grid and cell types
        for (int i = 0; i < 9; i++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            for (int j = 0; j < 9; j++) {
                String val = line[j];
                int num;
                boolean isPrefilled = false, isHint = false, isTinaFilled = false;
                if (val.charAt(0) == '0') { // Tina-filled
                    num = Integer.parseInt(val.substring(1));
                    isTinaFilled = true;
                } else if (val.charAt(val.length() - 1) == '0') { // Hinted
                    num = Integer.parseInt(val.substring(0, val.length() - 1));
                    isHint = true;
                } else { // Pre-filled
                    num = Integer.parseInt(val);
                    isPrefilled = true;
                }
                grid[i][j] = num;
                cells[i][j] = new Cell(i, j, num, isPrefilled, isHint, isTinaFilled);
                if (!isPrefilled) modifiable.add(cells[i][j]);
            }
        }

        // Parse hint list
        String[] hints = sc.nextLine().trim().split("\\s+");
        for (String s : hints) hintList.add(Integer.parseInt(s));
        Set<Integer> hintSet = new HashSet<>(hintList);

        // Parse K
        K = sc.nextInt();

        // Initialize row/col/box state from pre-filled
        for (int i = 0; i < 9; i++)
            Arrays.fill(rowUsed[i], false);
        for (int i = 0; i < 9; i++)
            Arrays.fill(colUsed[i], false);
        for (int i = 0; i < 9; i++)
            Arrays.fill(boxUsed[i], false);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (cells[i][j].isPrefilled)
                    mark(i, j, grid[i][j], true);

        // Try to solve with minimal changes
        List<int[]> changedCells = new ArrayList<>();
        if (dfs(0, changedCells, 0, hintSet)) {
            if (minChanges == 0) {
                System.out.print("Won");
            } else if (minChanges <= K) {
                for (int[] c : minChangedCells)
                    System.out.println(c[0] + " " + c[1]);
            } else {
                System.out.print("Impossible");
            }
        } else {
            System.out.print("Impossible");
        }
    }

    // Recursive DFS, returns true if possible
    static boolean dfs(int idx, List<int[]> changedCells, int changeCount, Set<Integer> hintSet) {
        if (changeCount > K) return false;
        if (idx == modifiable.size()) {
            if (changeCount < minChanges) {
                minChanges = changeCount;
                minChangedCells = new ArrayList<>(changedCells);
            }
            return true;
        }
        Cell cell = modifiable.get(idx);
        int r = cell.row, c = cell.col;
        int box = (r / 3) * 3 + (c / 3);
        List<Integer> candidates = new ArrayList<>();
        if (cell.isHint) {
            // Only allowed numbers from hintList
            for (int v : hintSet) {
                if (!rowUsed[r][v] && !colUsed[c][v] && !boxUsed[box][v])
                    candidates.add(v);
            }
        } else {
            // Tina-filled: can be any 1-9
            for (int v = 1; v <= 9; v++) {
                if (!rowUsed[r][v] && !colUsed[c][v] && !boxUsed[box][v])
                    candidates.add(v);
            }
        }
        boolean result = false;
        for (int v : candidates) {
            boolean changed = (grid[r][c] != v);
            mark(r, c, v, true);
            int orig = grid[r][c];
            grid[r][c] = v;
            if (changed) changedCells.add(new int[]{r, c});
            if (dfs(idx + 1, changedCells, changeCount + (changed ? 1 : 0), hintSet))
                result = true;
            if (changed) changedCells.remove(changedCells.size() - 1);
            grid[r][c] = orig;
            mark(r, c, v, false);
        }
        return result;
    }

    static void mark(int i, int j, int v, boolean set) {
        rowUsed[i][v] = set;
        colUsed[j][v] = set;
        boxUsed[(i / 3) * 3 + (j / 3)][v] = set;
    }
}