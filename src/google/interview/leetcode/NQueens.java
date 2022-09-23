package google.interview.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
	
	public static List <List<String >> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        // initialize each cell with '.'
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        
        List <List<String>> res = new ArrayList<List<String>> ();
        
        // it is enough to check only these 3 directions. We need not check same column because we place 1 
        // queen in each row. We need not check the right row and right diagonals 
        // because we haven't gone till that point at this time.
        // 
        int leftRow[] = new int[n];
        int upperLeftDiagonal[] = new int[2 * n - 1];
        int lowerLeftDiagonal[] = new int[2 * n - 1];
        
        solve(0, board, res, leftRow, lowerLeftDiagonal, upperLeftDiagonal);
        return res;
    }



    static void solve(int col, char[][] board, List < List < String >> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && 
            upperDiagonal[board.length - 1 + col - row] == 0) {
                // mark the queen
            	board[row][col] = 'Q';
                // hash the Queen at index row, col
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                // unmark the queen
                board[row][col] = '.';
                // unhash the queen at index row, col
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    static List<String> construct(char[][] board) {
        List <String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    public static void main(String args[]) {
        int N = 4;
        List < List <String>> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }

}
