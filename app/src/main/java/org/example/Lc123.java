package org.example;

public class Lc123 {
	public int maxProfit(int[] prices) {
		int l = prices.length;
		if (l <= 1) return 0;

		int[][] dp = new int[l][4];
		// 0 - 未交易 持有
		// 1- 交易一次
		// 2- 交易一次，持有
		// 3- 、
		dp[0][0] = 0-prices[0];

		for (int i = 1;i<l;i++){
			dp[i][0] = Math.max(dp[i-1][0], 0-prices[i]);

			if (i == 1) {
				dp[i][1] = dp[i-1][0] + prices[i];
			} else {
				dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
			}
			if (i>=2){
				if (i == 2){
					dp[i][2] = dp[i][1] - prices[i];
				} else{
					dp[i][2] = Math.max(dp[i-1][1]-prices[i],dp[i-1][2]);
				}
			}

			if (i >= 3) {
				if (i == 3){
					dp[i][3] = dp[i-1][2] + prices[i];
				} else{
					dp[i][3] = Math.max(dp[i-1][2]+prices[i], dp[i-1][3]);
				}
			}

		}

		if (l < 3) {
			return Math.max(0, dp[l-1][1]);
		}
		return Math.max(0, Math.max(dp[l-1][1],dp[l-1][3]));

	}
}
