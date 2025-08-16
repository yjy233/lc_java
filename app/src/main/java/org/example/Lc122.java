package org.example;

public class Lc122 {
	public int maxProfit(int[] prices) {
		int l = prices.length;
		if (l <= 1) return 0;
		int[][] dp = new int[l][2];

		dp[0][1] = 0 - prices[0];

		for (int i= 1;i < l;i++){
			dp[i][0] = Math.max(dp[i-1][0],prices[i] + dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
		}

		return dp[l-1][0];
	}
}
