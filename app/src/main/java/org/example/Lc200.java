package org.example;

public class Lc200 {
	public int numIslands(char[][] grid) {
		int res = 0;

		int h = grid.length;
		if (h<=0) return 0;
		int w = grid[0].length;
		if (w<=0) return 0;

		for (int i = 0;i<h;i++){
			for (int j = 0;j<w;j++){
				if (grid[i][j] == '0') continue;
				res++;
				helper(grid,h,w,i,j);
			}
		}
		return res;
	}

	public void  helper(char[][] grid, int h, int w, int x, int y){
		if (x >= h || x<0 || y>=w || y<0) return;

		if (grid[x][y] != '1') return;

		grid[x][y] = '0';

		helper(grid,h,w,x+1,y);
		helper(grid,h,w,x-1,y);
		helper(grid,h,w,x,y+1);
		helper(grid,h,w,x,y-1);
	}
}
