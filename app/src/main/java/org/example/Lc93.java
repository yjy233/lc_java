package org.example;

import java.util.ArrayList;
import java.util.List;

public class Lc93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		List<String> path = new ArrayList<>();
		helper(res,path,s,0 );

		return res;
	}

	public void helper(List<String> res,List<String> path, String s, int ind) {
		int l = s.length();
		if (ind >= l) return;
		if (path.size() >=4 ) return;

		for (int i = ind; i < Math.min(l, ind + 3);i++){
			if (s.charAt(ind) == '0' && i != ind) {
				continue;
			}
			String ns = s.substring(ind, i+1);

			int n = -1;
			try {
				n = Integer.parseInt(ns);
			} catch (Exception e) {
				continue;
			}
			//System.out.println(ns);
			if (n == -1 || n > 255) continue;

			path.add(ns);
			//System.out.println("paht " + path.size() + "  xxx.   " + i );
			if (i == l-1 && path.size() == 4){
				res.add(String.join(".", path));
				path.removeLast();
				continue;
			}

			helper(res,path,s,i+1);
			path.removeLast();
		}

	}
}
