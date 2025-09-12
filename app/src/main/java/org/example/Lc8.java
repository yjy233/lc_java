package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc8 {
	public int myAtoi(String s) {

		s = rmPrSpace(s);

		boolean res = isResMoreThanZero(s);
		List<Integer> nums = getNumList(s);

		return getRes(res,nums);
	}

	public String rmPrSpace(String s) {
		for (int i = 0;i<s.length();i++){
			if (s.charAt(i) == ' ') {
				continue;
			}

			return s.substring(i);
		}
		return s;
	}

	public boolean isResMoreThanZero(String s){
		boolean res = true;
		if (s.length() <= 0) return res;

		if (s.charAt(0) == '-') return false;
		return res;
	}

	public List<Integer> getNumList(String s) {
		List<Integer> nums = new ArrayList<>();

		if (s.length() <= 0) return nums;

		int st = (s.charAt(0) == '-' || s.charAt(0) == '+')? 1:0;
		for (int i = st;i<s.length();i++){
			int n = char2Int(s.charAt(i));
			if (n == -1) break;
			nums.add(n);
		}

		List<Integer> newNums = new ArrayList<>();
		boolean isFirst = true;
		for (int n: nums) {
			if (n != 0) {
				newNums.add(n);
				isFirst = false;
				continue;
			}

			if (isFirst) continue;
			newNums.add(n);
		}
		nums = newNums;


		return nums;
	}


	public int char2Int(char c){
		int d = (int) c - (int) '0';
		if (d < 0 || d >= 10) return -1;

		return d;
	}

	public boolean isOverFlowInt(boolean fu, List<Integer> nums){
		int l = nums.size();
		if (l < 10) return false;
		if (l > 10) return true;

		List<Integer> limit = Arrays.asList(2,1,4,7,4,8,3,6,4,7);
		for (int i = 0; i<10;i++) {
			if (i < 9) {
				if (nums.get(i) > limit.get(i)) return true;
				if (nums.get(i) < limit.get(i)) return false;
			}

			if (i == 9) {
				if (fu) return nums.get(i) > 7;
				return nums.get(i) > 8;
			}
		}

		return true;
	}

	public int getRes(boolean fu, List<Integer> nums) {
		//if  2147483648
		if (isOverFlowInt(fu,nums)) return fu? 2147483647: -2147483648;



		int res = 0;
		for (int n: nums) {
			res *= 10;
			res += n;
		}


		return fu? res: -1*res;
	}
}
