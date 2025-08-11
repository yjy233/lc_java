package org.example;

public class Lc79 {
	boolean res = false;
	public boolean exist(char[][] board, String word) {
		if (word.equals("")) return true;
		int h = board.length;
		if (h<=0) return false;
		int w = board[0].length;
		if (w <= 0) return false;

		boolean[][] path = new boolean[h][w];

		for (int i=0;i<h;i++){
			for (int j=0;j<w;j++) {
				if (res) return true;
				helper(board, word, 0, i, j, path);
			}
		}
		return res;
	}

	public boolean helper(char[][] board, String word, int ind, int x, int y, boolean[][] path){
		if (res) return true;

		if (x < 0 || x >= board.length || y < 0 || y>=board[0].length) return false;

		if (path[x][y]) return false;

		if (board[x][y] == word.charAt(ind)) {
			if (ind == word.length() - 1) {
				res = true;
				return true;
			}
		} else{
			return false;
		}

		path[x][y] = true;
		helper(board, word, ind+1,x+1, y, path);
		helper(board, word, ind+1,x-1, y, path);
		helper(board, word, ind+1,x, y+1, path);
		helper(board, word, ind+1,x, y-1, path);

		path[x][y] = false;
		return res;
	}
}
