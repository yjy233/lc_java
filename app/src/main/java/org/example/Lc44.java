package org.example;

public class Lc44 {
	public boolean isMatch(String s, String p) {
		String np = "";


		int h = s.length();
		int w = p.length();
		if (s.isEmpty()) {
			for (int i = 0;i< w;i++){
				if (p.charAt(i) != '*') return false;
			}
			return true;
		}

		boolean[][] dp = new boolean[h+1][w+1];

		dp[0][0] = true;

		for (int i = 0;i<h;i++){
			for (int j = 0;j<w; j++) {
				if (dp[i+1][j+1]) continue;
				if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
					if (dp[i][j]){
						dp[i+1][j+1] = true;
						continue;
					}
					continue;
				}

				if (p.charAt(j) != '*') continue;

				if (j == 0) {
					for (int k = 0; k<=h;k++) dp[k][1] = true;
					continue;
				}

				for (int k = 0;k<=h;k++) {
					if (dp[k][j]) {
						for (int z = k;z<=h;z++) dp[z][j+1] = true;
					}
				}

			}
		}

		//for (boolean[] line: dp){
		//	for (boolean x: line) {
		//		System.out.print(String.valueOf(x)+" ");
		//	}
		//	System.out.println("");
		//}
		return dp[h][w];
	}
}
