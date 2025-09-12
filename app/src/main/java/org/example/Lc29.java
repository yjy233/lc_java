package org.example;

import java.util.ArrayList;
import java.util.List;

/*
*
* 主要关键就是转-1的，然后就是判断一下 res输入要在 int，注意 divened 是 Interger min ，然后要输出正数的bug
* */
public class Lc29 {
	public int divide(int dividend, int divisor) {
		// 考虑被除数为最小值的情况
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == 1) {
				return Integer.MIN_VALUE;
			}
			if (divisor == -1) {
				return Integer.MAX_VALUE;
			}
		}
		// 考虑除数为最小值的情况
		if (divisor == Integer.MIN_VALUE) {
			return dividend == Integer.MIN_VALUE ? 1 : 0;
		}
		// 考虑被除数为 0 的情况
		if (dividend == 0) {
			return 0;
		}

		int fu = 1;
		if (dividend > 0) {
			dividend = -dividend;
		} else {
			fu = -1;
		}
		if (divisor > 0) {
			divisor = -divisor;
		} else {
			fu = (fu==-1)?1:-1;
		}

		List<Integer> ds = new ArrayList<>();
		List<Integer> ks = new ArrayList<>();

		ds.add(divisor);
		ks.add(1);
		//int realDivisor = divisor;

		//int res = 0;

		//int k = 1;
		while(dividend - ds.getLast() < ds.getLast() ) {
			ks.add(ks.getLast() + ks.getLast());
			ds.add(ds.getLast() + ds.getLast());
		}

		int res = 0;
		int ind = ds.size()-1;
		while(dividend <= divisor && ind >= 0) {
			int realD = ds.get(ind);
			if (dividend > realD) {
				ind--;
				continue;
			}

			res += ks.get(ind);
			if (dividend == realD) break;
			dividend -= realD;
		}
		return (fu==-1)?-res: res;
	}
}
