package org.example;

public class Lc121 {
	public int maxProfit(int[] prices) {
		int l = prices.length;
		int res = 0;
		for (int i = 1; i < l;i++){
			res = Math.max(res, prices[i] - prices[i-1]);
			prices[i] = Math.min(prices[i], prices[i-1]);
		}
		return res;
	}
}
