class Solution {
    List<List<String>> result = new ArrayList<>();
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        place(0, n);
        return result;
    }

    void place(int row, int n) {
        if (row == n) {
            List<String> one = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                one.add(new String(board[i]));
            }
            result.add(one);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (cols[c] || diag1[row + c] || diag2[row - c + n]) continue;
            cols[c] = true;
            diag1[row + c] = true;
            diag2[row - c + n] = true;
            board[row][c] = 'Q';
            place(row + 1, n);
            board[row][c] = '.';
            cols[c] = false;
            diag1[row + c] = false;
            diag2[row - c + n] = false;
        }
    }
}