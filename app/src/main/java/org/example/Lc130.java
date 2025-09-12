package org.example;

public class Lc130 {
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) return;
		for (int i = 0; i<board.length;i++) {
			helper(board,i,0);
			helper(board,i,board[0].length-1);
		}

		for (int j = 0; j<board[0].length;j++) {
			helper(board,0,j);
			helper(board,board.length-1,j);
		}


		for (int i = 0;i<board.length;i++) {
			for (int j = 0; j< board[0].length;j++) {
				if (board[i][j] == 'p') board[i][j] = 'O';
			}
		}
	}

	public void helper(char[][] board, int x, int y) {
		if (x < 0 || x>=board.length ||
				y < 0 || y>=board[0].length ||
				board[x][y] == 'X' || board[x][y] == 'p') return;

		board[x][y] = 'p';

		helper(board,x-1,y);
		helper(board,x+1,y);
		helper(board,x,y+1);
		helper(board,x,y-1);
	}
}
