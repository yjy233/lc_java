package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc36 {
	public boolean isValidSudoku(char[][] board) {
		if (board.length <= 0) return true;
		if (board[0].length <= 0) return true;

		Map<Integer, Map<Integer,Set<Character>>> sqMap = new HashMap<>();
		Map<Integer, Set<Character>> rowMap = new HashMap<>();


		for (int x=0; x < board.length; x++) {
			Set<Character> rowSet = new HashSet<>();
			for (int y = 0; y < board[0].length; y++) {
				char c = board[x][y];
				if (c == '.') continue;

				if (rowSet.contains(c)) return false;
				rowSet.add(c);

				if (rowMap.get(y) == null) rowMap.put(y, new HashSet<>());
				if (rowMap.get(y).contains(c)) return false;

				rowMap.get(y).add(c);

				int sx = x/3;
				int sy = y/3;
				if (sqMap.get(sx) == null) sqMap.put(sx, new HashMap<>());
				if (sqMap.get(sx).get(sy) == null) sqMap.get(sx).put(sy, new HashSet<>());
				if (sqMap.get(sx).get(sy).contains(c)) return false;
				sqMap.get(sx).get(sy).add(c);

			}

		}
		return true;
	}
}
